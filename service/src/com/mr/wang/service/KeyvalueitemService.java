package com.mr.wang.service;

import java.util.List;

import com.mr.wang.domain.model.KeyValueItem;
import com.mr.wang.domain.utils.PagingBounds;

public interface KeyValueItemService {
	void deleteById(int id);


	List<KeyValueItem> getAll(PagingBounds pagingBound);


	List<KeyValueItem> getAll();
}
