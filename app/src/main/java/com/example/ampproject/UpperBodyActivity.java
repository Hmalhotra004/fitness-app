package com.example.ampproject;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ampproject.Adapter.workoutVideoAdapter;
import com.example.ampproject.Models.workoutVideo;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class UpperBodyActivity extends AppCompatActivity {

  private RecyclerView recyclerView;
  private workoutVideoAdapter videoAdapter;
  private List<workoutVideo> videoItemList;
  private FirebaseFirestore db;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_upper_body);

    db = FirebaseFirestore.getInstance();

    recyclerView = findViewById(R.id.upperbodyRec);
    recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    videoItemList = new ArrayList<>();
    videoAdapter = new workoutVideoAdapter(this, videoItemList);
    recyclerView.setAdapter(videoAdapter);

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
