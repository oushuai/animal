package com.oushuai.animal.service;

import com.oushuai.animal.bean.Photo;
import com.oushuai.animal.bean.PhotoExample;
import com.oushuai.animal.bean.Video;
import com.oushuai.animal.bean.VideoExample;
import com.oushuai.animal.dao.PhotoMapper;
import com.oushuai.animal.dao.VideoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VideoService {
    @Resource
    VideoMapper videoMapper;

    public List<Video> list() {
        return videoMapper.selectByExample(null);
    }


    public List<Video> list(Integer albumId) {
        VideoExample example = new VideoExample();
        VideoExample.Criteria criteria = example.createCriteria();
        criteria.andAlbumIdEqualTo(albumId);
        //   PageHelper.startPage(pageIndex,pageSize, true);
        List<Video> list = videoMapper.selectByExample(example);
        return list;

    }

    public void insert(Video video) {
        videoMapper.insert(video);
    }


    public boolean delete(Integer videoId) {
        int result = videoMapper.deleteByPrimaryKey(videoId);
        return result <= 0 ? true : false;
    }
}
