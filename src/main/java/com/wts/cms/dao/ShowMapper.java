package com.wts.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wts.cms.domain.Show;

public interface ShowMapper {

	List<Show> selects(Show show);

	void del(@Param("id")Integer id);

	void addShow(Show show);

}
