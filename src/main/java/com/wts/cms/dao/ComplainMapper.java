package com.wts.cms.dao;

import java.util.List;

import com.wts.cms.domain.Complain;
import com.wts.cms.vo.ComplainVO;

public interface ComplainMapper {
	
	int insert(Complain complain);
	
	//查询举报
	List<Complain> selects(ComplainVO complainVO);

}
