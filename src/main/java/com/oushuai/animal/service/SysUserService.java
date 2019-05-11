package com.oushuai.animal.service;

import com.oushuai.animal.bean.SysUser;
import com.oushuai.animal.bean.SysUserExample;
import com.oushuai.animal.dao.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
