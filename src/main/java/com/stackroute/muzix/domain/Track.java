package com.stackroute.muzix.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Builder
public class Track {
//    public Track() {
//    }

    @Id
    int trackid;

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

    String trackname;
    String genre;

//    @Override
//    public String toString() {
//        return "Track{" +
//                "trackid=" + trackid +
//                ", trackname=" + trackname +
//                ", genre='" + genre + '\'' +
//                '}';
//    }
}

