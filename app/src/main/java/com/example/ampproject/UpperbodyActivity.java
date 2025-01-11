package com.example.ampproject;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ampproject.Adapter.workoutVideoAdapter;
import com.example.ampproject.Models.workoutVideo;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class UpperbodyActivity extends AppCompatActivity {

  public RecyclerView recyclerView;

  public workoutVideoAdapter videoAdapter;

  private List<workoutVideo> videoItemList;

  private FirebaseFirestore db;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_upperbody);

    db = FirebaseFirestore.getInstance();

    recyclerView=findViewById(R.id.upperbodyrecycler);
    if (recyclerView != null) {
      recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    videoItemList = new ArrayList<>();

    videoAdapter=new workoutVideoAdapter(this,videoItemList);
    recyclerView.setAdapter(videoAdapter);

//    if (clickableLayout != null) {
//      clickableLayout.setOnClickListener(v -> {
//        // Show a toast message indicating the layout was clicked
//        Toast.makeText(this, "Layout clicked", Toast.LENGTH_SHORT).show();
//
//        // Redirect to YouTube video using Intent
//        String videoUrl = "https://www.youtube.com/watch?v=dQw4w9WgXcQ"; // Replace with your YouTube video ID
//        Intent intent = new Intent(Intent.ACTION_VIEW, android.net.Uri.parse(videoUrl));
//        startActivity(intent);
//      });
//    } else {
//      Toast.makeText(this, "Clickable layout not found", Toast.LENGTH_SHORT).show();
//    }

    fetchVideos();
  }

  private void fetchVideos() {
    db.collection("videos")
      .get()
      .addOnCompleteListener(task -> {
        if (task.isSuccessful() && task.getResult() != null) {
          for (DocumentSnapshot document : task.getResult()) {
            try {
              // Map Firestore document to VideoItem model
              workoutVideo videoItem = document.toObject(workoutVideo.class);

              // Check for null values
              if (videoItemList != null) {
                videoItemList.add(videoItem);
              } else {
                Log.w("UPPERBODY", "Skipped document with missing fields: " + document.getId());
              }
            } catch (Exception e) {
              Log.e("UPPERBODY", "Error parsing document: " + document.getId(), e);
            }
          }
          // Notify adapter of data changes
          videoAdapter.notifyDataSetChanged();
        } else {
          Log.e("UPPERBODY", "Error fetching documents: ", task.getException());
        }
      });
  }
}
