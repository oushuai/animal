package com.oushuai.animal.service;

import com.oushuai.animal.bean.Photo;
import com.oushuai.animal.dao.PhotoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PhotoService {
    @Autowired
    PhotoMapper photoMapper;

    public List<Photo> list(){
        return  photoMapper.selectByExampleWithAlbum(null);
    }
}
