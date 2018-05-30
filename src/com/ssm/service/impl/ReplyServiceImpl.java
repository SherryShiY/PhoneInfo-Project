package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.dao.ReplyMapper;
import com.ssm.entity.Reply;
import com.ssm.service.ReplyService;

@Service("aService")
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyMapper aMapper;

	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Reply> getList(Integer infoid) {
		return aMapper.getList(infoid);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int save(Reply re) {
		return aMapper.save(re);
	}
}
