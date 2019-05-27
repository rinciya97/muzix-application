package com.stackroute.muzix.repository;

import com.stackroute.muzix.domain.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.bind.SchemaOutputResolver;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest
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
    public void testGetAllTrack(){
        Track track1 = new Track(1,"safari","peppy");
        Track track2 = new Track(2,"Jenny","Harry12");
        musicRepository.save(track1);
        musicRepository.save(track2);

        List<Track> list = musicRepository.findAll();
        Assert.assertEquals("orasatha",list.get(0).getTrackname());
    }
}