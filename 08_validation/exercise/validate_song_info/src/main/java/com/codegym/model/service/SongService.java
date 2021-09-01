package com.codegym.model.service;

import com.codegym.model.entity.Song;

import java.util.List;

public interface SongService {
    public List<Song> findAll();

    public Song save(Song song);

}