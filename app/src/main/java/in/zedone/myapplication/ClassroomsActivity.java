package in.zedone.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import in.zedone.myapplication.adapter.ClassroomsAdapter;
import in.zedone.myapplication.api.RetrofitApi;
import in.zedone.myapplication.model.Classroom;
import in.zedone.myapplication.model.Classrooms;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClassroomsActivity extends AppCompatActivity {

    List<Classroom> classroomList;
    RecyclerView recyclerView;
    ClassroomsAdapter classroomsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classrooms);

        classroomList = new ArrayList<>();
        classroomsAdapter = new ClassroomsAdapter(getApplicationContext(),classroomList);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(classroomsAdapter);

        loadData();
    }

    public void loadData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitApi api = retrofit.create(RetrofitApi.class);

        Call<Classrooms> call = api.getClassrooms();

        call.enqueue(new Callback<Classrooms>() {
            @Override
            public void onResponse(Call<Classrooms> call, Response<Classrooms> response) {

                //In this point we got our hero list
                //thats damn easy right ;)
                Classrooms classrooms = response.body();
                classroomList.addAll(classrooms.getClassroomList());
                //Toast.makeText(ClassroomsActivity.this, String.valueOf(heroList.size()), Toast.LENGTH_SHORT).show();
                classroomsAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<Classrooms> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                t.getStackTrace();
            }
        });
    }
}
