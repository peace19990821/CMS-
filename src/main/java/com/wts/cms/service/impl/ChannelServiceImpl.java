package com.wts.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wts.cms.dao.CategoryMapper;
import com.wts.cms.dao.ChannelMapper;
import com.wts.cms.domain.Category;
import com.wts.cms.domain.Channel;
import com.wts.cms.service.ChannelService;

@Service
public class ChannelServiceImpl implements ChannelService {

	@Resource
	private ChannelMapper channelMapper;
	@Resource
	private CategoryMapper categoryMapper;
	
	@Override
	public List<Channel> selects() {
		return channelMapper.selects();
	}

	@Override
	public List<Category> selectsByChannelId(Integer channerId) {
		return categoryMapper.selectsByChannelId(channerId);
	}

}
