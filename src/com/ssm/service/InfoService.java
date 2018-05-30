package com.ssm.service;

import java.util.List;

import com.ssm.entity.Info;

public interface InfoService {
	List<Info> getList(); 
	Info selectById(Integer id);
	int update(Info info);
}
