package in.zedone.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import in.zedone.myapplication.ClassroomsDetailActivity;
import in.zedone.myapplication.R;
import in.zedone.myapplication.model.Classroom;

public class ClassroomsAdapter extends RecyclerView.Adapter<ClassroomsAdapter.ClassroomsViewHolder> {

    Context context;
    List<Classroom> classroomList;

    public ClassroomsAdapter(Context context, List<Classroom> classroomList) {
        this.context = context;
        this.classroomList = classroomList;
    }

    @Override
    public ClassroomsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_classroom, parent, false);
        ClassroomsViewHolder holder = new ClassroomsViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ClassroomsViewHolder holder, final int position) {

        holder.txtName.setText(classroomList.get(position).getName());
        holder.txtSize.setText("Size :" + classroomList.get(position).getSize());
        holder.txtLayout.setText(classroomList.get(position).getLayout());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(context, ClassroomsDetailActivity.class);
                in.putExtra("id",classroomList.get(position).getId());
                in.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(in);
            }
        });
    }

    @Override
    public int getItemCount() {
        return classroomList.size();
    }

    public class ClassroomsViewHolder extends RecyclerView.ViewHolder {

        TextView txtName, txtSize, txtLayout;

        public ClassroomsViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_name);
            txtSize = itemView.findViewById(R.id.txt_size);
            txtLayout = itemView.findViewById(R.id.txt_layout);
        }
    }
}
