package in.zedone.myapplication.api;


import in.zedone.myapplication.model.AssignSub;
import in.zedone.myapplication.model.Classroom;
import in.zedone.myapplication.model.Classrooms;
import in.zedone.myapplication.model.Student;
import in.zedone.myapplication.model.Students;
import in.zedone.myapplication.model.Subject;
import in.zedone.myapplication.model.Subjects;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

public interface RetrofitApi {

    String BASE_URL = "https://hamon-interviewapi.herokuapp.com/";

    @GET("students?api_key=f3A9B")
    Call<Students> getStudents();

    @GET("students/{id}?api_key=f3A9B")
    Call<Student> getStudent(@Path("id") int id);

    @GET("subjects?api_key=f3A9B")
    Call<Subjects> getSubjects();

    @GET("subjects/{id}?api_key=f3A9B")
    Call<Subject> getSubject(@Path("id") int id);

    @GET("classrooms?api_key=f3A9B")
    Call<Classrooms> getClassrooms();

    @GET("classrooms/{id}?api_key=f3A9B")
    Call<Classroom> getClassroom(@Path("id") int id);

    @PATCH("classrooms/{id}?api_key=f3A9B")
    Call<AssignSub> assignSub(@Body int subject, @Path("id") int id);

}
