package com.mr.wang.common.api;

import org.springframework.web.bind.annotation.RequestMapping;

import com.mr.wang.utils.Response;


@RequestMapping("/keyvalueitem")
public interface KeyValueItemEndpoint {
	
	@RequestMapping("/delete")
	Response deleteKeyValueItem();

	@RequestMapping("/get")
	Response getAllPage();
	
	
	@RequestMapping("/getAll")
	Response getAll();
}

