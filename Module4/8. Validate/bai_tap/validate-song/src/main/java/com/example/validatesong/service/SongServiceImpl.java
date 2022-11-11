package com.example.validatesong.service;

import com.example.validatesong.model.Song;
import com.example.validatesong.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongServiceImpl implements SongService{
    @Autowired
    private SongRepository repository;
    @Override
    public void save(Song song) {
        repository.save(song);
    }

    @Override
    public Iterable<Song> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Song> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void remove(int id) {
        repository.deleteById(id);
    }
}
