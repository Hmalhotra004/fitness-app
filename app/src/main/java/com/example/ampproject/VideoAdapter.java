package com.example.ampproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder>{
    private List<VideoItem> videoItemList;
    private Context context;

    public VideoAdapter(List<VideoItem> videoItemList, Context context) {
        this.videoItemList = videoItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public VideoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_video,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapter.ViewHolder holder, int position) {

        VideoItem videoItem = videoItemList.get(position);
        holder.videotitle.setText(videoItem.getTitle());

        String thumbnailURL = "https://img.youtube.com/vi/"  + videoItem.getVideoId() + "/0.jpg";

        Glide.with(context).load(thumbnailURL).into(holder.videoThumbnail);

        holder.videoThumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.videoThumbnail.setVisibility(View.GONE);
                holder.ytplayer.setVisibility(View.VISIBLE);
                holder.ytplayer.getYouTubePlayerWhenReady(youTubePlayer -> youTubePlayer.cueVideo(videoItem.getVideoId(),0));
            }
        });
        holder.ytplayer.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onError(@NonNull YouTubePlayer youTubePlayer, @NonNull PlayerConstants.PlayerError error) {
//                super.onError(youTubePlayer, error);

                holder.ytplayer.setVisibility(View.GONE);
                holder.videoThumbnail.setVisibility(View.VISIBLE);

            }

            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
//                super.onReady(youTubePlayer);
                youTubePlayer.cueVideo(videoItem.getVideoId(),0);
            }
        });
    }

    @Override
    public int getItemCount() {
        return videoItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        Toolbar top;

        TextView videotitle;

        ImageView videoThumbnail;

        YouTubePlayerView ytplayer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            videotitle = itemView.findViewById(R.id.videotitle);
            videoThumbnail=itemView.findViewById(R.id.videoThumbnail);
            top=itemView.findViewById(R.id.top);
            ytplayer=itemView.findViewById(R.id.ytplayer);
        }
    }
}
