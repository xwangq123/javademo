package com.mr.wang.common.impl;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.mr.wang.common.api.KeyvalueitemEndpoint;
import com.mr.wang.domain.model.Keyvalueitem;
import com.mr.wang.domain.utils.PagingBounds;
import com.mr.wang.service.KeyvalueitemService;
import com.mr.wang.utils.Response;

@RestController
public class KeyvalueitemEndpointImpl implements KeyvalueitemEndpoint {
	@Autowired
	private KeyvalueitemService impl;

	@Override
	public Response deleteKeyValueItem() {
		impl.deleteById(5);
		return Response.ok(5);
	}

	@Override
	public Response addKeyValueItem() {
		for (int i = 0; i < 100; i++) {
			Keyvalueitem k = new Keyvalueitem();
			k.setName("Kye" + i);
			k.setCaption("caption" + i);
			k.setKeyid(i);
			k.setValue("value" + i);
			k.setStatus(1);
			impl.add(k);
		}
		return Response.ok();
	}

	@Override
	public Response getAll() {
		return Response.ok(impl.getAll());
	}

	@Override
	public Response getAllPage() {
		PagingBounds page = new PagingBounds(2, 10);
		return Response.ok(impl.getAll(page),page.getTotal());
	}

	@Override
	public Response getAllPageB() {
		RowBounds page = new RowBounds(2, 10);
		return Response.ok(impl.getAll(page));
	}
}
