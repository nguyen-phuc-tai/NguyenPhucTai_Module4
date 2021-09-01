package com.codegym.model.service;

import com.codegym.model.entity.Song;
import com.codegym.model.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    @Autowired
    private SongRepository songRepository;

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Song save(Song song) {
        return songRepository.save(song);
    }

}