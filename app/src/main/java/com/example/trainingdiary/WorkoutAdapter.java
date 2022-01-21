package com.example.trainingdiary;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder> {

    private String[] data;

    public WorkoutAdapter(String[] data){
        this.data = data;
    }


    @NonNull
    @Override
    public WorkoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        if(!data[0].equals("null")){
            view = inflater.inflate(R.layout.list_item_layout, parent, false);
        }else{
            System.out.println(data.length);
            view = inflater.inflate(R.layout.list_item_layout_no_training, parent, false);
        }

        return new WorkoutViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutViewHolder holder, int position) {
        String title = data[position];
        holder.txtView.setText((title));

    }

    @Override
    public int getItemCount() {
        if(data.length == 0) {
            return 1;
        }else
        return data.length;
    }

    public class WorkoutViewHolder extends RecyclerView.ViewHolder{
        ImageView imgIcon;
        TextView txtView, txtViewNoTraining;

       public WorkoutViewHolder(@NonNull View itemView) {
           super(itemView);
           txtView = (TextView) itemView.findViewById(R.id.textItem);
           txtViewNoTraining = (TextView) itemView.findViewById(R.id.textItemNoTraining);
       }
   }
}
