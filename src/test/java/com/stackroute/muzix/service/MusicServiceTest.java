package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.repository.MusicRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MusicServiceTest {
    private Track track;

    //Create a mock for UserRepository
    @Mock
    private MusicRepository musicRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    private MusicServiceImpl musicService;
    List<Track> list= null;


    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        track = new Track();
        track.setTrackid(101);
        track.setTrackname("safari");
        track.setGenre("peppy");
        list = new ArrayList<>();
        list.add(track);


    }
    @Test
    public void saveTrackTestSuccess() throws TrackAlreadyExistsException {

        when(musicRepository.save((Track) any())).thenReturn(track);
        Track savedTrack = musicService.saveTrack(track);
        Assert.assertEquals(track,savedTrack);

        //verify here verifies that userRepository save method is only called once
        verify(musicRepository,times(1)).save(track);

    }


@Test(expected = TrackAlreadyExistsException.class)
public void saveUserTestFailure() throws TrackAlreadyExistsException {
    when(musicRepository.save((Track) any())).thenReturn(null);
    Track savedTrack = musicService.saveTrack(track);
    System.out.println("savedUser" + savedTrack);
    Assert.assertEquals(track,savedTrack);


    }

    @Test
    public void getAllUser(){

        musicRepository.save(track);
        //stubbing the mock to return specific data
        when(musicRepository.findAll()).thenReturn(list);
        List<Track> userlist = musicService.getAllTrack();
        Assert.assertEquals(list,userlist);
    }
}