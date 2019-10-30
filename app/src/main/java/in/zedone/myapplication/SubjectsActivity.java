package in.zedone.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import in.zedone.myapplication.adapter.SubjectsAdapter;
import in.zedone.myapplication.api.RetrofitApi;
import in.zedone.myapplication.model.Subject;
import in.zedone.myapplication.model.Subjects;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubjectsActivity extends AppCompatActivity {

    List<Subject> subjectList;
    RecyclerView recyclerView;
    SubjectsAdapter subjectsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);
        subjectList = new ArrayList<>();
        subjectsAdapter = new SubjectsAdapter(getApplicationContext(),subjectList);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(subjectsAdapter);

        loadData();
    }

    public void loadData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitApi api = retrofit.create(RetrofitApi.class);

        Call<Subjects> call = api.getSubjects();

        call.enqueue(new Callback<Subjects>() {
            @Override
            public void onResponse(Call<Subjects> call, Response<Subjects> response) {

                //In this point we got our hero list
                //thats damn easy right ;)
                Subjects subjects = response.body();
                subjectList.addAll(subjects.getSubjectList());
                //Toast.makeText(SubjectsActivity.this, String.valueOf(heroList.size()), Toast.LENGTH_SHORT).show();
                subjectsAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<Subjects> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
