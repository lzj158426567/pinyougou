package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private TbBrandMapper brandMapper;

    @Override
    public List<TbBrand> findAll() {
        return brandMapper.selectByExample(null);
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(null);
        long total = page.getTotal();
        List<TbBrand> result = page.getResult();
        Object resultobj = JSONArray.toJSON(result);
        String tbBrandList = resultobj.toString();
        System.out.println(tbBrandList);
        return new PageResult(total, result);
    }

    @Override
    public void addTbBrand(TbBrand tbBrand) {
        brandMapper.insert(tbBrand);
    }

    @Override
    public void updateTbBrand(TbBrand tbBrand) {
        brandMapper.updateByPrimaryKey(tbBrand);
    }

    @Override
    public TbBrand findTbBrandById(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteTbBrand(Long[] ids) {
        for (Long id : ids) {
            brandMapper.deleteByPrimaryKey(id);
        }

    }

    @Override
    public PageResult SerchPage(TbBrand tbBrand, int pageNums, int pageSize) {
        PageHelper.startPage(pageNums, pageSize);
        TbBrandExample example = new TbBrandExample();
        TbBrandExample.Criteria criteria = example.createCriteria();
        if (tbBrand != null) {
            if (tbBrand.getName() != null && tbBrand.getName().length() > 0) {
                criteria.andNameLike("%" + tbBrand.getName() + "%");
            }
        }
        if (tbBrand.getFirstChar() != null && tbBrand.getFirstChar().length() > 0) {
            criteria.andFirstCharEqualTo(tbBrand.getFirstChar());
        }
        Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 列表数据
     */
    @Override
    public List<Map> selectOptionList() {
        return brandMapper.selectOptionList();
    }

}
