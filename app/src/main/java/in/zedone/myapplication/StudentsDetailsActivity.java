package in.zedone.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import in.zedone.myapplication.api.RetrofitApi;
import in.zedone.myapplication.model.Student;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StudentsDetailsActivity extends AppCompatActivity {

    TextView txtName, txtEmail, txtAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_details);

        txtName = findViewById(R.id.txt_name);
        txtAge = findViewById(R.id.txt_age);
        txtEmail = findViewById(R.id.txt_email);

        loadData();
    }


    public void loadData(){
        Intent in = getIntent();
        final int stud_id = in.getIntExtra("id",0);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitApi api = retrofit.create(RetrofitApi.class);

        Call<Student> call = api.getStudent(stud_id);

        call.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {

                Student student = response.body();

                txtName.setText(student.getName());
                txtAge.setText("Age : "+student.getAge());
                txtEmail.setText(student.getEmail());
            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
