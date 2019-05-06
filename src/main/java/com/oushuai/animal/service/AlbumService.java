package com.oushuai.animal.service;

import com.oushuai.animal.bean.Album;
import com.oushuai.animal.dao.AlbumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AlbumService {
    @Autowired
    AlbumMapper albumMapper;


}
