package com.oushuai.animal.service;

import com.oushuai.animal.bean.Photo;
import com.oushuai.animal.bean.Video;
import com.oushuai.animal.dao.PhotoMapper;
import com.oushuai.animal.dao.VideoMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
@Service
public class VideoService {
    @Resource
    VideoMapper videoMapper;
    public List<Video> list(){
        return  videoMapper.selectByExample(null);
    }
}
