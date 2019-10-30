package in.zedone.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import in.zedone.myapplication.api.RetrofitApi;
import in.zedone.myapplication.model.Subject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubjectsDetailActivity extends AppCompatActivity {

    TextView txtName, txtTeacher, txtCredits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects_detail);

        txtName = findViewById(R.id.txt_name);
        txtCredits = findViewById(R.id.txt_credits);
        txtTeacher = findViewById(R.id.txt_teacher);

        loadData();
    }


    public void loadData(){
        Intent in = getIntent();
        final int sub_id = in.getIntExtra("id",0);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitApi api = retrofit.create(RetrofitApi.class);

        Call<Subject> call = api.getSubject(sub_id);

        call.enqueue(new Callback<Subject>() {
            @Override
            public void onResponse(Call<Subject> call, Response<Subject> response) {

                Subject subject = response.body();

                txtName.setText(subject.getName());
                txtCredits.setText("Credits : "+subject.getCredits());
                txtTeacher.setText(subject.getTeacher());
            }

            @Override
            public void onFailure(Call<Subject> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
