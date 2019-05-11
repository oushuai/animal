package com.oushuai.animal.service;

import com.oushuai.animal.bean.Album;
import com.oushuai.animal.bean.AlbumExample;
import com.oushuai.animal.dao.AlbumMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {
    @Autowired
    AlbumMapper albumMapper;

    /**
     * 添加相册
     *
     * @param album
     * @return
     */
    public int save(Album album) {
        int insert = albumMapper.insertSelective(album);
        return insert;
    }

    /**
     * 更新相册
     *
     * @param album
     * @return
     */
    public int update(Album album) {
        int update = albumMapper.updateByPrimaryKeySelective(album);
        return update;
    }
    /**
     * 获取相册详情
     *
     * @return
     */
    public void del(int albumId) {
        albumMapper.deleteByPrimaryKey(albumId);
    }

    /**
     * 获取相册详情
     *
     * @return
     */
    public Album getInfo(int albumId) {
        Album album = albumMapper.selectByPrimaryKey(albumId);
        return album;
    }

    /**
     * 获取相册列表
     *
     * @return
     */
    public List<Album> getList(Album album) {
        AlbumExample example = new AlbumExample();
        if (StringUtils.isNotBlank(album.getAlbumName())) {
            example.or().andAlbumNameLike("%" + album.getAlbumName() + "%");
        }
        if (album.getCateId() != null && album.getCateId() > 0) {
            example.or().andCateIdEqualTo(album.getCateId());
        }
        if (album.getUserId() != null && album.getUserId() > 0) {
            example.or().andUserIdEqualTo(album.getUserId());
        }
        List<Album> albums = albumMapper.selectByExample(example);
        return albums;
    }

}
