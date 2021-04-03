package com.example.others.RecycleViews;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {

    private List<Todo> todos;

    public TodoAdapter(List<Todo> todos) {
        this.todos = todos;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvTaskNote;
        private final CheckBox cbxStatus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTaskNote = (TextView) itemView.findViewById(R.id.tvTaskNote);
            cbxStatus = itemView.findViewById(R.id.cbxStatus);
        }

        public TextView getTvTaskNote() {
            return tvTaskNote;
        }

        public CheckBox getCbxStatus() {
            return cbxStatus;
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View todoView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_views_item,parent,false);
        return new ViewHolder(todoView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTaskNote.setText(todos.get(position).getTaskNote());

        if(todos.get(position).isStatus() == true) {
            holder.cbxStatus.setChecked(true);
        }
    }

    @Override
    public int getItemCount() {
//       IT IS ALWAYS NEEDED TO KNOW THE SIZE OF THE DATASET AS THE LAYOUT MANAGER WHO'S GOING TO MAKE
//       TRE RECYCLEVIEWS WILL KNOW HWO MANY TIMES IT WILL CREATE VIEWS AND BIND DATA.
        return todos.size();
    }

}
