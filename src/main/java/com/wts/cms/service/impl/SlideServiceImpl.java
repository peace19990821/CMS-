package com.wts.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wts.cms.dao.SlideMapper;
import com.wts.cms.domain.Slide;
import com.wts.cms.service.SlideService;

@Service
public class SlideServiceImpl implements SlideService {

	@Resource
	private SlideMapper slideMapper;
	
	@Override
	public List<Slide> selects() {
		return slideMapper.selects();
	}

}
