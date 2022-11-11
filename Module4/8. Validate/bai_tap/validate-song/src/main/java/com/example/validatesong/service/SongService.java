package com.example.validatesong.service;

import com.example.validatesong.model.Song;

import java.util.Optional;


public interface SongService {
    void save(Song song);
    Iterable<Song> findAll();
    Optional<Song> findById(int id);

    void remove(int id);
}
