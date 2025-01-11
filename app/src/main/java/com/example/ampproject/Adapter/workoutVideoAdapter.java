package com.example.ampproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ampproject.Models.workoutVideo;
import com.example.ampproject.R;

import java.util.List;

public class workoutVideoAdapter extends RecyclerView.Adapter<workoutVideoAdapter.ViewHolder> {

  private Context context;
  private List<workoutVideo> workoutVideoList;

  public workoutVideoAdapter(Context context, List<workoutVideo> workoutVideoList) {
    this.context = context;
    this.workoutVideoList = workoutVideoList;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    // Get the workoutVideo object at this position
    workoutVideo video = workoutVideoList.get(position);

    // Bind the data to the views
    holder.titleTextView.setText(video.getTitle());
    holder.headerTextView.setText(video.getHeader());
    holder.durationTextView.setText(video.getDuration());
  }

  @Override
  public int getItemCount() {
    return workoutVideoList.size(); // Return the size of the list
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {
    TextView titleTextView, headerTextView, durationTextView;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);

      // Initialize TextViews from the layout
      titleTextView = itemView.findViewById(R.id.videoTitle);
      headerTextView = itemView.findViewById(R.id.videoHeader);
      durationTextView = itemView.findViewById(R.id.videoDuration);
    }
  }
}
