package com.mr.wang.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mr.wang.domain.mapping.KeyvalueitemMapper;
import com.mr.wang.domain.model.Keyvalueitem;
import com.mr.wang.domain.utils.PagingBounds;
import com.mr.wang.service.KeyvalueitemService;

@Service
public class KeyvalueitemServiceImpl implements KeyvalueitemService {
	@Autowired
	private KeyvalueitemMapper mapper;

	@Override
	public void deleteById(int id) {
		mapper.deleteByPrimaryKey(id);
	}

	@Override
	public void add(Keyvalueitem Keyvalueitem) {
		mapper.insert(Keyvalueitem);
	}

	@Override
	public List<Keyvalueitem> getAll() {
		return  mapper.getAll();
	}

	@Override
	public List<Keyvalueitem> getAll(PagingBounds pagingBound) {
		return  mapper.getAll(pagingBound);
	}

	@Override
	public List<Keyvalueitem> getAll(RowBounds pagingBound) {
		return  mapper.getAll(pagingBound);
	}
}
