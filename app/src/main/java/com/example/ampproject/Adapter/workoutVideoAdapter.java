package com.example.ampproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ampproject.Models.workoutVideo;
import com.example.ampproject.R;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class workoutVideoAdapter extends RecyclerView.Adapter<workoutVideoAdapter.ViewHolder> {

  private Context context;
  private List<workoutVideo> workoutVideoList;

  private FirebaseFirestore db;

  public workoutVideoAdapter(Context context, List<workoutVideo> workoutVideoList) {
    this.context = context;
    this.workoutVideoList = workoutVideoList;
    this.db = FirebaseFirestore.getInstance();
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.videoitem, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    workoutVideo currentItem = workoutVideoList.get(position);

    // Set data for views
    holder.title.setText(currentItem.getTitle());
    holder.header.setText(currentItem.getHeader());
    holder.duration.setText(currentItem.getDuration());

//     Use Glide to load the image from URL
//    Glide.with(context)
//      .load(currentItem.getImageUrl())
//      .into(holder.imageView);

  }

  @Override
  public int getItemCount() {
    return workoutVideoList.size();
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView title, header, duration;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      imageView = itemView.findViewById(R.id.videoImage);
      title = itemView.findViewById(R.id.videoTitle);
      header = itemView.findViewById(R.id.videoHeader);
      duration = itemView.findViewById(R.id.videoDuration);
    }
  }
}
