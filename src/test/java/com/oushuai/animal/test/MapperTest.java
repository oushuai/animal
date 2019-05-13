package com.oushuai.animal.test;
import com.oushuai.animal.bean.Album;
import com.oushuai.animal.bean.Photo;
import com.oushuai.animal.dao.AlbumMapper;
import com.oushuai.animal.dao.PhotoMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    SqlSession sqlSession;
@Autowired
AlbumMapper albumMapper;
@Autowired
    PhotoMapper photoMapper;
    @Test
    public void testAnimal() throws Exception {
        AlbumMapper mapper = sqlSession.getMapper(AlbumMapper.class);
        PhotoMapper mapper1 = sqlSession.getMapper(PhotoMapper.class);
        //    System.out.println(albumMapper);
        // albumMapper.insertSelective(new Album("小","www.baidu.com"));
        //    albumMapper.insert(new Album("大","www.baidu.com"));
        //  Album album=new Album("fish","");
//    // albumMapper.deleteByPrimaryKey(1);
        // photoMapper.insertSelective(new Photo("1","www.wangyi.com",3,"杨幂照片",new Date(),"1",100));
        //插入一个
        //     photoMapper.insertSelective(new Photo("2",".wangyi.com",3,"杨幂",new Date(),"1",100));
        //多个插入
//        long start = System.currentTimeMillis();
//     for(int i=0;i<10;i++){
//
//            String photoId= UUID.randomUUID().toString().substring(0,5);
//
//      //   mapper.deleteByPrimaryKey(i);
//         mapper1.insertSelective(new Photo(photoId,"www.mangguo.tv",3,"刘诗诗",new Date(),"10",100));
//       }
//        long end = System.currentTimeMillis();
//        System.out.println("---------------" + (start - end) + "---------------");
//
//    }


    }}
