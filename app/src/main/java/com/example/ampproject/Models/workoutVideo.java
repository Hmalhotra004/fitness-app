package com.example.ampproject.Models;

public class workoutVideo {
  public String title,header,duration;

  public workoutVideo() {}

  public workoutVideo(String title, String header, String duration) {
    this.title = title;
    this.header = header;
    this.duration = duration;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getHeader() {
    return header;
  }

  public void setHeader(String header) {
    this.header = header;
  }

  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

//  public String getImageUrl() {
//    return imageUrl;
//  }
//
//  public void setImageUrl(String imageUrl) {
//    this.imageUrl = imageUrl;
//  }
}
