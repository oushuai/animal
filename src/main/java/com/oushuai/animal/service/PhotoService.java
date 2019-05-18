package com.oushuai.animal.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oushuai.animal.bean.Photo;
import com.oushuai.animal.bean.PhotoExample;
import com.oushuai.animal.dao.AlbumMapper;
import com.oushuai.animal.dao.PhotoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class PhotoService {
    @Resource
    PhotoMapper photoMapper;
    @Resource
    AlbumMapper albumMapper;

    /**
     * 根据相册id查询图片列表
  //   * @param albumId
     * @return
     */

    public List<Photo> list1(){
        return  photoMapper.selectByExample(null);
    }
    public  Photo getPhoto(Integer photoId){
        return photoMapper.selectByPrimaryKey(photoId);
    }
    public List<Photo> list(Integer albumId) {
        PhotoExample example=new PhotoExample();
        PhotoExample.Criteria criteria=example.createCriteria();
        criteria.andAlbumIdEqualTo(albumId);
      //   PageHelper.startPage(pageIndex,pageSize, true);
        List<Photo> list= photoMapper.selectByExample(example);
        return list;

    }
    public void insert(Photo photo){
        photoMapper.insert(photo);
    }
    public boolean delete(Integer photoId,Integer albumId){
        int result=  photoMapper.deleteByPrimaryKey(photoId);
        return result<=0?true:false;
    }
    public boolean update(Photo photo){
        int result  = photoMapper.updateByPrimaryKeySelective(photo);
        return result<=0?true:false;
    }
}
