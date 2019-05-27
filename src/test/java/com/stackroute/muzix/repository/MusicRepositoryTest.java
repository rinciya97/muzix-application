package com.stackroute.muzix.repository;

import com.stackroute.muzix.domain.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@DataJpaTest
public class MusicRepositoryTest {
    @Autowired
    private MusicRepository musicRepository;
    private Track track;

    @Before
    public void setUp()
    {
        track = new Track();
        track.setTrackid(101);
        track.setTrackname("safari");
        track.setGenre("peppy");
    }

    @After
    public void tearDown(){

        musicRepository.deleteAll();
    }


    @Test
    public void testSaveTrack(){
        musicRepository.save(track);
        Track fetchTrack = musicRepository.findById(track.getTrackid()).get();
        Assert.assertEquals(101,fetchTrack.getTrackid());

    }
    @Test
    public void getByName() {
    }
    @Test
    public void testGetAllUser(){
        Track track = new Track(10,"beleiver","peppy");
        Track track1 = new Track(11,"Jenny","Harry12");
        musicRepository.save(track);
        musicRepository.save(track1);

        List<Track> list = musicRepository.findAll();
        Assert.assertEquals("beleiver",list.get(0).getTrackname());
    }
}