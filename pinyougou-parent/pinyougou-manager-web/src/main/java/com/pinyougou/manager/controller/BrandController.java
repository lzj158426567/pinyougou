package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONArray;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Reference
    private BrandService brandService;

    @RequestMapping("/findAll")
    public List<TbBrand> findAll() {
        return brandService.findAll();
    }

    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows) {
        return brandService.findPage(page, rows);
    }

    @RequestMapping("/addTbBrand")
    public Result addTbBrand(@RequestBody TbBrand tbBrand) {
        try {
            Object o = JSONArray.toJSON(tbBrand);
            String s = o.toString();
            System.out.println(s);
            brandService.addTbBrand(tbBrand);
            return new Result(true, "success");
        } catch (Exception e) {
            return new Result(false, "false");
        }
    }

    @RequestMapping("/updateTbBrand")
    public Result updateTbBrand(@RequestBody TbBrand tbBrand) {
        try {
            brandService.updateTbBrand(tbBrand);
            return new Result(true, "success");
        } catch (Exception e) {
            return new Result(false, "false");
        }
    }

    @RequestMapping("/findTbBrandById")
    public TbBrand findTbBrandById(Long id) {
        return brandService.findTbBrandById(id);
    }

    @RequestMapping("/deleteTbBrand")
    public Result deleteTbBrand(Long[] ids) {
        try {
            brandService.deleteTbBrand(ids);
            return new Result(true, "success");
        } catch (Exception e) {
            return new Result(false, "false");
        }
    }

    @RequestMapping("/SerchPage")
    public PageResult SerchPage(@RequestBody TbBrand tbBrand, int page, int rows  ) {
        return brandService.SerchPage(tbBrand, page, rows);
    }

    @RequestMapping("/selectOptionList")
    public List<Map> selectOptionList(){
        return brandService.selectOptionList();
    }

}
