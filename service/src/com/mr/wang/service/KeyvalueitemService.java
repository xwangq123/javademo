package com.mr.wang.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.mr.wang.domain.model.Keyvalueitem;
import com.mr.wang.domain.utils.PagingBounds;

public interface KeyvalueitemService {
	void deleteById(int id);

	void add(Keyvalueitem Keyvalueitem);

	List<Keyvalueitem> getAll(PagingBounds pagingBound);

	List<Keyvalueitem> getAll(RowBounds pagingBound);

	List<Keyvalueitem> getAll();
}
