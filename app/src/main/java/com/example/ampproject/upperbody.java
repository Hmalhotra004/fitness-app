package com.example.ampproject;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class upperbody extends AppCompatActivity {

    private RecyclerView recyclerView;

    private VideoAdapter videoAdapter;

    private List<VideoItem> videoItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_upperbody);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        videoItemList = new ArrayList<>();

        videoItemList.add(new VideoItem("15 min STANDING ARM WORKOUT | With Dumbbells | Upper Body | No Pushups or Plank","i-Ci1PxwUpY&list"));
        videoItemList.add(new VideoItem("15 min EXPRESS UPPER BODY WORKOUT | With Dumbbells | Arm Focused | No Pushups","vnMPpx0wC-E&list"));
        videoItemList.add(new VideoItem("30 min UPPER BODY WORKOUT | With Dumbbells | Arms and Abs | Warm Up and Cool Down Included","i-Ci1PxwUpY&list"));

        videoAdapter=new VideoAdapter(videoItemList,this);
        recyclerView.setAdapter(videoAdapter);
    }

}