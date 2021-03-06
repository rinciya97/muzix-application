package com.stackroute.muzix.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Collection;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Track {
//    public Track() {
//    }

    @Id
    int trackid;
    String trackname;
    String genre;

//    public Track(int trackid, String trackname, String genre) {
//        this.trackid = trackid;
//        this.trackname = trackname;
//        this.genre = genre;
//    }
//
//    public int getTrackid() {
//        return trackid;
//    }
//
//    public void setTrackid(int trackid) {
//        this.trackid = trackid;
//    }
//
//    public String getTrackname() {
//        return trackname;
//    }
//
//    public void setTrackname(String trackname) {
//        this.trackname = trackname;
//    }
//
//    public String getGenre() {
//        return genre;
//    }
//
//    public void setGenre(String genre) {
//        this.genre = genre;
//    }


//    @Override
//    public String toString() {
//        return "Track{" +
//                "trackid=" + trackid +
//                ", trackname=" + trackname +
//                ", genre='" + genre + '\'' +
//                '}';
//    }
}

