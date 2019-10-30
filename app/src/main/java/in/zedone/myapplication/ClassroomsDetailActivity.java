package in.zedone.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import in.zedone.myapplication.api.RetrofitApi;
import in.zedone.myapplication.model.Classroom;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClassroomsDetailActivity extends AppCompatActivity {

    TextView txtName, txtLayout, txtSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classrooms_detail);

        txtName = findViewById(R.id.txt_name);
        txtSize = findViewById(R.id.txt_size);
        txtLayout = findViewById(R.id.txt_layout);

        loadData();
    }


    public void loadData() {
        Intent in = getIntent();
        final int class_id = in.getIntExtra("id", 0);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitApi api = retrofit.create(RetrofitApi.class);

        Call<Classroom> call = api.getClassroom(class_id);

        call.enqueue(new Callback<Classroom>() {
            @Override
            public void onResponse(Call<Classroom> call, Response<Classroom> response) {

                Classroom classroom = response.body();

                txtName.setText(classroom.getName());
                txtSize.setText("Size : " + classroom.getSize());
                txtLayout.setText(classroom.getLayout());
            }

            @Override
            public void onFailure(Call<Classroom> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}