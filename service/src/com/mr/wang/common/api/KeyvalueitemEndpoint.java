package com.mr.wang.common.api;

import org.springframework.web.bind.annotation.RequestMapping;

import com.mr.wang.utils.Response;


@RequestMapping("/keyvalueitem")
public interface KeyvalueitemEndpoint {
	
	@RequestMapping("/delete")
	Response deleteKeyValueItem();

	@RequestMapping("/addTest")
	Response addKeyValueItem();

	@RequestMapping("/get")
	Response getAllPage();
	
	@RequestMapping("/getb")
	Response getAllPageB();
	
	@RequestMapping("/getAll")
	Response getAll();
}

