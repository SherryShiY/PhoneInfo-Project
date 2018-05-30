package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.dao.InfoMapper;
import com.ssm.entity.Info;
import com.ssm.service.InfoService;

@Service("iService")
public class InfoServiceImpl implements InfoService {
	
	@Autowired
	private InfoMapper iMapper;

	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Info> getList() {
		return iMapper.getList();
	}
	
	@Override
	public Info selectById(Integer id) {
		return iMapper.selectById(id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int update(Info info) {
		return iMapper.update(info);
	}
}
