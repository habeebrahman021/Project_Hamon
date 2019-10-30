package in.zedone.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import in.zedone.myapplication.api.RetrofitApi;
import in.zedone.myapplication.model.AssignSub;
import in.zedone.myapplication.model.Classrooms;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStud = findViewById(R.id.btn_students);
        btnStud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),StudentsActivity.class));
            }
        });
        Button btnSub = findViewById(R.id.btn_subjects);
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SubjectsActivity.class));
            }
        });

        Button btnClass = findViewById(R.id.btn_classrooms);
        btnClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ClassroomsActivity.class));
            }
        });
    }
}
