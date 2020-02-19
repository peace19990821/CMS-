package com.bawei.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bawei.entity.Goods;
import com.bawei.service.GoodsService;
import com.github.pagehelper.PageInfo;

@Controller
public class GoodsController {

	@Resource
	private GoodsService goodsService;

	/**
	 * 分页获取数据
	 * @param pageNum
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping("getList")
	public String getList(@RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "10") Integer pageSize,Model model) {
		
		//根据分页条件获取数据
		PageInfo<Goods> pageInfo = goodsService.getList(pageNum , pageSize);
		
		model.addAttribute("pageInfo", pageInfo);

		return "list";
	}
	/**
	 * 分页获取已售百分比数据
	 * @param pageNum
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping("getSellList")
	public String getSellList(@RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "10") Integer pageSize,Model model) {
		
		//根据分页条件获取数据
		PageInfo<Goods> pageInfo = goodsService.getSellList(pageNum , pageSize);
		
		model.addAttribute("pageInfo", pageInfo);
		
		return "sell_list";
	}

}
