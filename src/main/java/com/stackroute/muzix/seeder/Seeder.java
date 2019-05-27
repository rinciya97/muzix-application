package com.stackroute.muzix.seeder;
import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class Seeder implements ApplicationListener<ContextRefreshedEvent>, CommandLineRunner {
    @Autowired
    MusicService musicService;

    public Seeder(MusicService musicService) {
        this.musicService = musicService;
    }

    public MusicService getMusicService() {
        return musicService;
    }

    public void setMusicService(MusicService musicService) {
        this.musicService = musicService;
    }

    @Value("${trackid}")
    int trackid;

    @Value("${trackname}")
    String trackname;

    @Value("${genre}")
    String genre;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Track track= new Track(trackid, trackname, genre);
        try {
            musicService.saveTrack(track);
        } catch (TrackAlreadyExistsException e) {
            e.printStackTrace();
        }
    }

    @Value("${trackid1}")
    int trackid1;

    @Value("${trackname1}")
    String trackname1;

    @Value("${genre1}")
    String genre1;


    @Override
    public void run(String... args) throws Exception {
        Track track= new Track(trackid1, trackname1, genre1);
        try {
            musicService.saveTrack(track);
        } catch (TrackAlreadyExistsException e) {
            e.printStackTrace();
        }
    }
}
