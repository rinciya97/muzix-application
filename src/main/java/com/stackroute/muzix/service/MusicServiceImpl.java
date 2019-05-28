package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackDoesntExistException;
import com.stackroute.muzix.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicServiceImpl implements MusicService {
    MusicRepository musicRepository;

    @Autowired
    public MusicServiceImpl(MusicRepository musicRepository)
    {
        this.musicRepository=musicRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if(musicRepository.existsById(track.getTrackid()))
        {
            throw new TrackAlreadyExistsException("track already exists exception");
        }

        Track savedTrack =musicRepository.save(track);
        if(savedTrack ==null)
        {
            throw new TrackAlreadyExistsException("track already exist exception");
        }
        return savedTrack;
    }

    @Override
    public List<Track> getAllTrack() {
        return musicRepository.findAll();
    }

    @Override
    public boolean deleteTrack(int trackid) throws TrackDoesntExistException {
        boolean status=false;
        if(musicRepository.existsById(trackid))
        {
            musicRepository.deleteById(trackid);
            status=true;
            return status;
        }
        else{
            throw new TrackDoesntExistException("Track id not found");
        }

    }

    @Override
    public Track updateTrack(Track track) throws TrackDoesntExistException
    {
        if(musicRepository.existsById(track.getTrackid()))
        {
            Track updateTrack =musicRepository.save(track);
        }
        else
        {
            try {
                throw new TrackDoesntExistException("Track id not found");
            } catch (TrackDoesntExistException e) {
                e.printStackTrace();
            }
        }
        return track;
    }

//    @Override
//    public List<Track> getByName(String trackname) throws TrackDoesntExistException {
//        List<Track> track = musicRepository.getByName(trackname);
//        if (track.isEmpty()) {
//            throw new TrackDoesntExistException("Track not found");
//        }
//        return track;
//    }
}
