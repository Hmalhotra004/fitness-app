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
import com.example.ampproject.Model.VideoItem;
import com.example.ampproject.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {
    private List<VideoItem> videoItemList;
    private Context context;

    public VideoAdapter(List<VideoItem> videoItemList, Context context) {
        this.videoItemList = videoItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_video, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VideoItem videoItem = videoItemList.get(position);

        // Set the video title
        holder.videotitle.setText(videoItem.getTitle());

        // Create the thumbnail URL using YouTube video ID
        String thumbnailURL = "https://img.youtube.com/vi/" + videoItem.getVideoId() + "/0.jpg";
        Glide.with(context).load(thumbnailURL).into(holder.videoThumbnail);

        // When thumbnail is clicked, hide it and show the YouTube player
        holder.videoThumbnail.setOnClickListener(v -> {
            holder.videoThumbnail.setVisibility(View.GONE);
            holder.ytplayer.setVisibility(View.VISIBLE);

            holder.ytplayer.getYouTubePlayerWhenReady(youTubePlayer -> {
                if (youTubePlayer != null) {
                    youTubePlayer.cueVideo(videoItem.getVideoId(), 0);
                }
            });
        });

        // Add listener for the YouTube player
        holder.ytplayer.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onError(@NonNull YouTubePlayer youTubePlayer, @NonNull PlayerConstants.PlayerError error) {
                // Hide YouTube player and show thumbnail again on error
                holder.ytplayer.setVisibility(View.GONE);
                holder.videoThumbnail.setVisibility(View.VISIBLE);
            }

            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                // Cue video when ready
                if (youTubePlayer != null) {
                    youTubePlayer.cueVideo(videoItem.getVideoId(), 0);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return videoItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView videotitle;
        ImageView videoThumbnail;
        YouTubePlayerView ytplayer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            videotitle = itemView.findViewById(R.id.videotitle);
            videoThumbnail = itemView.findViewById(R.id.videoThumbnail);
            ytplayer = itemView.findViewById(R.id.ytplayer);
        }
    }
}
