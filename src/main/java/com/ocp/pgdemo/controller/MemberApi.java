package com.ocp.pgdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ocp.pgdemo.model.Member;
import com.ocp.pgdemo.model.RspModel;
import com.ocp.pgdemo.repository.MemberRepository;

@RestController
@RequestMapping("/api/v1/member")
public class MemberApi {

	@Autowired
	private MemberRepository repository;

	@RequestMapping(value = "/addmember", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<RspModel> addMember(@RequestBody Member member) {

		try {
			repository.save(member);

			RspModel rsp = new RspModel();
			rsp.setCode(200);
			rsp.setMsg("Member created");
			rsp.setData(member);
			return new ResponseEntity<RspModel>(rsp, HttpStatus.CREATED);

		} catch (Exception ex) {
			RspModel rsp = new RspModel();
			rsp.setCode(500);
			rsp.setMsg(ex.getMessage());
			return new ResponseEntity<RspModel>(rsp, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
}
