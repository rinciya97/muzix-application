package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackDoesntExistException;

import java.util.List;

public interface MusicService {
    public Track saveTrack(Track track) throws TrackAlreadyExistsException;
    public List<Track> getAllTrack();
    public boolean deleteTrack(int trackid) throws TrackDoesntExistException;
    public Track updateTrack(Track track) throws TrackDoesntExistException;

    List<Track> getByName(String trackName) throws TrackDoesntExistException;
}
