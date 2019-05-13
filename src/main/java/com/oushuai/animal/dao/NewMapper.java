package com.oushuai.animal.dao;

import com.oushuai.animal.bean.New;
import com.oushuai.animal.bean.NewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NewMapper {
    int countByExample(NewExample example);

    int deleteByExample(NewExample example);

    int deleteByPrimaryKey(Integer newId);

    int insert(New record);

    int insertSelective(New record);

    List<New> selectByExample(NewExample example);

    New selectByPrimaryKey(Integer newId);

    int updateByExampleSelective(@Param("record") New record, @Param("example") NewExample example);

    int updateByExample(@Param("record") New record, @Param("example") NewExample example);

    int updateByPrimaryKeySelective(New record);

    int updateByPrimaryKey(New record);
}