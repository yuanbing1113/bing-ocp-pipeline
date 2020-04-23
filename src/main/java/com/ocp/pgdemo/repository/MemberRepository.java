package com.ocp.pgdemo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ocp.pgdemo.model.Member;

public interface MemberRepository extends CrudRepository<Member, Long> {

	List<Member> findByOcpgroup(String group);

}
