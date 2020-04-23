package com.ocp.pgdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ocp.pgdemo.model.RspModel;

@RestController
public class HelloOcp {
	
	@Value("${hello}")
	private String hello;

	@GetMapping("/api/v2/hello")
	public ResponseEntity<RspModel> addCourse() {

		RspModel rsp = new RspModel();

		rsp.setCode(200);
		rsp.setMsg(hello);

		return new ResponseEntity<RspModel>(rsp, HttpStatus.OK);
	}

}
