package com.oushuai.animal.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oushuai.animal.bean.Photo;
import com.oushuai.animal.bean.PhotoExample;
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

    /**
     * 根据相册id查询图片列表
  //   * @param albumId
     * @return
     */

    public List<Photo> list1(){
        return  photoMapper.selectByExample(null);
    }

    public List<Photo> list(Integer albumId) {
        PhotoExample example=new PhotoExample();
        PhotoExample.Criteria criteria=example.createCriteria();
        criteria.andAlbumIdEqualTo(albumId);
      //   PageHelper.startPage(pageIndex,pageSize, true);
        List<Photo> list= photoMapper.selectByExample(example);
        return list;
//        if(list!=null){
//            Page<Photo> page=(Page<Photo>)list;
//            return page;
//        }
//        return null;
    }
}
