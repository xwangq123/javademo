package com.mr.wang.common.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.mr.wang.common.api.KeyValueItemEndpoint;
import com.mr.wang.domain.utils.PagingBounds;
import com.mr.wang.service.KeyValueItemService;
import com.mr.wang.utils.Response;

@RestController
public class KeyValueItemEndpointImpl implements KeyValueItemEndpoint {
	@Autowired
	private KeyValueItemService impl;

	@Override
	public Response deleteKeyValueItem() {
		impl.deleteById(5);
		return Response.ok(5);
	}


	@Override
	public Response getAll() {
		return Response.ok(impl.getAll());
	}

	@Override
	public Response getAllPage() {
		PagingBounds page = new PagingBounds(5, 1);
		return Response.ok(impl.getAll(page),page.getTotal());
	}

}
