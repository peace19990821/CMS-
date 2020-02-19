package com.wts.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wts.cms.dao.ShowMapper;
import com.wts.cms.domain.Show;
import com.wts.cms.service.ShowService;
import com.wts.common.utils.StringUtil;

@Service
public class ShowServiceImpl implements ShowService{

	@Autowired
	ShowMapper showMapper;
	
	@Override
	public List<Show> selects(Show show) {
		return showMapper.selects(show);
	}

	@Override
	public void del(Integer id) {
		Show show = new Show();
		boolean httpUrl = StringUtil.isHttpUrl(show.getUrl());
		if(httpUrl != true) {
			showMapper.del(id);
		}
	}

	@Override
	public void addShow(Show show) {
		showMapper.addShow(show);
	}
	
}
