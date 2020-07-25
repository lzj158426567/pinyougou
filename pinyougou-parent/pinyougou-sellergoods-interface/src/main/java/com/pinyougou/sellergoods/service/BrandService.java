package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;

import entity.PageResult;

import java.util.List;
import java.util.Map;

public interface BrandService {
	/**
	 * 查找全部
	 *
	 * @return
	 */
	public List<TbBrand> findAll();

	/**
	 * 分页查询
	 */
	public PageResult findPage(int pageNum, int pageSize);

	/**
	 * 添加品牌
	 */
	public void addTbBrand(TbBrand tbBrand);

	/**
	 * 修改品牌
	 *
	 * @param tbBrand
	 */
	public void updateTbBrand(TbBrand tbBrand);

	/**
	 * 通过ID 获取当前实体 然后回填到修改的框中
	 *
	 * @param id
	 * @return
	 */
	public TbBrand findTbBrandById(Long id);

	/**
	 * 删除品牌
	 *
	 * @param ids
	 */
	public void deleteTbBrand(Long[] ids);


	/**
	 * @param tbBrand
	 * @param pageNums
	 * @param pageSize
	 * @return
	 */
	public PageResult SerchPage(TbBrand tbBrand, int pageNums, int pageSize);


	/**
	 * 品牌下拉框数据
	 */
	List<Map> selectOptionList();

}
