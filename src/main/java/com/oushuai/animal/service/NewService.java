package com.oushuai.animal.service;

import com.oushuai.animal.bean.New;
import com.oushuai.animal.bean.NewExample;
import com.oushuai.animal.dao.NewMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NewService {

    @Autowired
    NewMapper newMapper;

    /**
     * 添加相册
     *
     * @param news
     * @return
     */
    public int save(New news) {
        int insert = newMapper.insertSelective(news);
        return insert;
    }
    /**
     * 更新相册
     *
     * @return
     */
    public int update(New news) {
        int update = newMapper.updateByPrimaryKeySelective(news);
        return update;
    }
    /**
     * 获取相册详情
     *
     * @return
     */
    public void del(int albumId) {
        newMapper.deleteByPrimaryKey(albumId);
    }

    /**
     * 获取资讯详情
     *
     * @return
     */
    public New getInfo(int newId) {
        New new1= newMapper.selectByPrimaryKey(newId);
        return new1;
    }

    /**
     * 获取资讯列表
     *
     * @return
     */
    public List<New> getList(New news) {
        NewExample example = new NewExample();
        if (StringUtils.isNotBlank(news.getNewTitle())) {
            example.or().andNewTitleLike("%" + news.getNewTitle() + "%");
        }
        List<New> newList = newMapper.selectByExample(example);
        return newList;
    }

}
