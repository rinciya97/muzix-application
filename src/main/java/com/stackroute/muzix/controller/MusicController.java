package com.stackroute.muzix.controller;
import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackDoesntExistException;
import com.stackroute.muzix.service.MusicService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value="api/v1")
//@Api(value = "musicDB", description = "Operations Pertaining to Music")
public class MusicController {
    MusicService musicService;
    public MusicController(MusicService musicService)
    {
        this.musicService = musicService;
    }
    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) {
        ResponseEntity responseEntity;
        try
        {
            musicService.saveTrack(track);
            responseEntity=new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        }
        catch (TrackAlreadyExistsException ex)
        {

            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);

        }
        return responseEntity;
    }

    @PutMapping("track")
    public ResponseEntity<?> updateTrack(@RequestBody Track track) throws TrackDoesntExistException{
        ResponseEntity responseEntity;
        musicService.updateTrack(track);
        responseEntity=new ResponseEntity<String>("Successfully updated", HttpStatus.CREATED);
        return responseEntity;
    }

    @DeleteMapping("/track/{trackid}")
    public ResponseEntity<?> deleteTrack(@PathVariable("trackid") int trackid) throws TrackDoesntExistException{
        ResponseEntity responseEntity;
        try
        {
            musicService.deleteTrack(trackid);
            responseEntity=new ResponseEntity<String>("Successfully deleted", HttpStatus.CREATED);
        }
        catch (TrackDoesntExistException ex)
        {
            //responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
              throw ex;
        }

        return responseEntity;
    }

    @GetMapping("track")
    public ResponseEntity<?> getAllTrack(){
        return new ResponseEntity<List<Track>>(musicService.getAllTrack(),HttpStatus.OK);
    }
//    @GetMapping("/track/{trackname}")
//    public ResponseEntity<List<Track>> getByName (@PathVariable String trackname) {
//        ResponseEntity responseEntity;
//        try {
//            return new ResponseEntity<List<Track>>( musicService.getByName(trackname) , HttpStatus.OK);
//        }
//        catch (Exception e) {
//            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
//        }
//        return responseEntity;
//    }
}
