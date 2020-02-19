package com.wts.cms.service;

import java.util.List;

import com.wts.cms.domain.Show;

public interface ShowService {

	List<Show> selects(Show show);

	void del(Integer id);

	void addShow(Show show);

}
