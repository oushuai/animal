package com.oushuai.animal.service;

import com.oushuai.animal.bean.SysUser;
import com.oushuai.animal.bean.SysUserExample;
import com.oushuai.animal.dao.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @className: SysUserService
 * @description:
 * @author: murphy.he
 * @date: 2019-05-09 20:09
 **/
@Service
public class SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    public List<SysUser> list() {
        return sysUserMapper.selectByExample(new SysUserExample());
    }
    public SysUser login(String userName,String password){
        SysUserExample example= new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(userName).andPasswordEqualTo(password);
        List<SysUser> sysUsers = sysUserMapper.selectByExample(example);
        if(sysUsers!=null)
        {
            if(sysUsers.size()==1){
                 return sysUsers.get(0);
            }
            return null;
        }
        return null;
    }
    public void register(SysUser sysUser){
        sysUser.setCreateTime(new Date());
        sysUser.setUpdateTime(new Date());
        sysUserMapper.insert(sysUser);
    }
}
