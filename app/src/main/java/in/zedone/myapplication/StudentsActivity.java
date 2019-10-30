package in.zedone.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import in.zedone.myapplication.adapter.StudentsAdapter;
import in.zedone.myapplication.api.RetrofitApi;
import in.zedone.myapplication.model.Student;
import in.zedone.myapplication.model.Students;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StudentsActivity extends AppCompatActivity {

    List<Student> studentList;
    RecyclerView recyclerView;
    StudentsAdapter studentsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);

        studentList = new ArrayList<>();
        studentsAdapter = new StudentsAdapter(getApplicationContext(),studentList);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(studentsAdapter);

        loadData();
    }

    public void loadData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitApi api = retrofit.create(RetrofitApi.class);

        Call<Students> call = api.getStudents();

        call.enqueue(new Callback<Students>() {
            @Override
            public void onResponse(Call<Students> call, Response<Students> response) {

                //In this point we got our hero list
                //thats damn easy right ;)
                Students students = response.body();
                studentList.addAll(students.getStudentList());
                //Toast.makeText(StudentsActivity.this, String.valueOf(heroList.size()), Toast.LENGTH_SHORT).show();
                studentsAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<Students> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
