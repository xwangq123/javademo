package com.mr.wang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mr.wang.domain.mapping.KeyValueItemMapper;
import com.mr.wang.domain.model.KeyValueItem;
import com.mr.wang.domain.utils.PagingBounds;
import com.mr.wang.service.KeyValueItemService;

@Service
public class KeyValueItemServiceImpl implements KeyValueItemService {
	@Autowired
	private KeyValueItemMapper mapper;

	@Override
	public void deleteById(int id) {
		mapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<KeyValueItem> getAll() {
		return  mapper.getAll();
	}

	@Override
	public List<KeyValueItem> getAll(PagingBounds pagingBound) {
		return  mapper.getAll(pagingBound);
	}

}
