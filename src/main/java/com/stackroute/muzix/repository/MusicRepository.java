package com.stackroute.muzix.repository;

import com.stackroute.muzix.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository extends MongoRepository<Track,Integer> {
    @Query(value = "SELECT * FROM track WHERE trackname = ?1", nativeQuery = true)
    public List<Track> getByName(String trackName);
}
