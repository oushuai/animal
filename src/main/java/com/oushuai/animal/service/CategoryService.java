package com.oushuai.animal.service;

import com.oushuai.animal.bean.Category;
import com.oushuai.animal.bean.CategoryExample;
import com.oushuai.animal.dao.CategoryMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryService {
    @Resource
    private CategoryMapper categoryMapper;
    public List<Category> list(){
        return categoryMapper.selectByExample(null);
    }
    public int update(int cateId,String cateName){
        Category category=new Category();
        category.setCateId(cateId);
        category.setCateName(cateName);
        CategoryExample example=new CategoryExample();
        CategoryExample.Criteria criteria=example.createCriteria();
        criteria.andCateIdEqualTo(cateId);
       return categoryMapper.updateByExample(category,example);
    }
    public int add(String cateName){
        Category category=new Category();
        category.setCateName(cateName);
        return categoryMapper.insertSelective(category);
    }
    public int delete(int cateId){
        CategoryExample example=new CategoryExample();
        CategoryExample.Criteria criteria=example.createCriteria();
        criteria.andCateIdEqualTo(cateId);
        return categoryMapper.deleteByExample(example);
    }
    public Category getInfoById(int cateId) {
        CategoryExample example = new CategoryExample();
        CategoryExample.Criteria criteria = example.createCriteria();
        criteria.andCateIdEqualTo(cateId);
        List<Category> categories = categoryMapper.selectByExample(example);
        if (categories.size() > 0) {
            return categories.get(0);
        }
        return null;
    }
}
