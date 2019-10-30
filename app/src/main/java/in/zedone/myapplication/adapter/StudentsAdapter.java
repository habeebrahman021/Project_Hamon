package in.zedone.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import in.zedone.myapplication.R;
import in.zedone.myapplication.StudentsDetailsActivity;
import in.zedone.myapplication.model.Student;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.StudentsViewHolder> {

    Context context;
    List<Student> studentList;

    public StudentsAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @Override
    public StudentsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_student, parent, false);
        StudentsViewHolder holder = new StudentsViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(StudentsViewHolder holder, final int position) {

        holder.txtName.setText(studentList.get(position).getName());
        holder.txtAge.setText("Age :" + studentList.get(position).getAge());
        holder.txtEmail.setText(studentList.get(position).getEmail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(context, StudentsDetailsActivity.class);
                in.putExtra("id",studentList.get(position).getId());
                in.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(in);
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class StudentsViewHolder extends RecyclerView.ViewHolder {

        TextView txtName, txtAge, txtEmail;

        public StudentsViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_name);
            txtAge = itemView.findViewById(R.id.txt_age);
            txtEmail = itemView.findViewById(R.id.txt_email);
        }
    }
}
