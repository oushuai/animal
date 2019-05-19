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
        VideoExample example = new VideoExample();
        example.setOrderByClause("video_date desc");
        return videoMapper.selectByExample(example);
    }


    public List<Video> list(Integer albumId) {
        VideoExample example = new VideoExample();
        example.setOrderByClause("video_date desc");
        VideoExample.Criteria criteria = example.createCriteria();

        criteria.andAlbumIdEqualTo(albumId);
        //   PageHelper.startPage(pageIndex,pageSize, true);
        List<Video> list = videoMapper.selectByExample(example);
        return list;

    }

    public void insert(Video video) {
        videoMapper.insert(video);
    }
    public  Video getVideo(Integer videoId){
        return videoMapper.selectByPrimaryKey(videoId);
    }

    public boolean delete(Integer videoId) {
        int result = videoMapper.deleteByPrimaryKey(videoId);
        return result <= 0 ? true : false;
    }
    public boolean delete(Video video){
        return delete(video.getVideoId());
    }
    public boolean delete (List<Video> videos){
        if(videos==null||videos.size()==0)return true;
        try {
            videos.forEach(v->{
                delete(v);
            });
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Video video) {
        int result  = videoMapper.updateByPrimaryKeySelective(video);
        return result<=0?true:false;
    }
}
