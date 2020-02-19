package com.bawei.service;

import com.bawei.entity.Goods;
import com.github.pagehelper.PageInfo;

public interface GoodsService {

	PageInfo<Goods> getList(Integer pageNum, Integer pageSize);

	PageInfo<Goods> getSellList(Integer pageNum, Integer pageSize);

}
