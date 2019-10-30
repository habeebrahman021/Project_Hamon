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
import in.zedone.myapplication.SubjectsDetailActivity;
import in.zedone.myapplication.model.Subject;

public class SubjectsAdapter extends RecyclerView.Adapter<SubjectsAdapter.SubjectsViewHolder> {

    Context context;
    List<Subject> subjectList;

    public SubjectsAdapter(Context context, List<Subject> subjectList) {
        this.context = context;
        this.subjectList = subjectList;
    }

    @Override
    public SubjectsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_subject, parent, false);
        SubjectsViewHolder holder = new SubjectsViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(SubjectsViewHolder holder, final int position) {

        holder.txtName.setText(subjectList.get(position).getName());
        holder.txtCredits.setText("Credits :" + subjectList.get(position).getCredits());
        holder.txtTeacher.setText(subjectList.get(position).getTeacher());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(context, SubjectsDetailActivity.class);
                in.putExtra("id",subjectList.get(position).getId());
                in.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(in);
            }
        });
    }

    @Override
    public int getItemCount() {
        return subjectList.size();
    }

    public class SubjectsViewHolder extends RecyclerView.ViewHolder {

        TextView txtName, txtCredits, txtTeacher;

        public SubjectsViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_name);
            txtCredits = itemView.findViewById(R.id.txt_credits);
            txtTeacher = itemView.findViewById(R.id.txt_teacher);
        }
    }
}
