package com.ssm.service;

import java.util.List;

import com.ssm.entity.Reply;

public interface ReplyService {
	
	List<Reply> getList(Integer qid); //查询所有回答

	int save(Reply re);
}
