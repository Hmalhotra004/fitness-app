package com.example.ampproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ampproject.Models.workoutVideo;
import com.example.ampproject.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.List;

public class workoutVideoAdapter extends RecyclerView.Adapter<workoutVideoAdapter.ViewHolder> {
  private List<workoutVideo> videoItemList;
  private Context context;

  public workoutVideoAdapter(List<workoutVideo> videoItemList, Context context) {
    this.videoItemList = videoItemList;
    this.context = context;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.videoitem, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    workoutVideo videoItem = videoItemList.get(position);

    // Set the video title
    holder.videotitle.setText(videoItem.getTitle());

  }

  @Override
  public int getItemCount() {
    return videoItemList.size();
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {

    TextView videotitle, videoHeader,videoDuration;
    ImageView videoThumbnail;


    public ViewHolder(@NonNull View itemView) {
      super(itemView);

      videotitle = itemView.findViewById(R.id.videoTitle);
      videoHeader = itemView.findViewById(R.id.videoHeader);
      videoThumbnail = itemView.findViewById(R.id.videoImage);
      videoDuration = itemView.findViewById(R.id.videoDuration);

    }
  }
}
