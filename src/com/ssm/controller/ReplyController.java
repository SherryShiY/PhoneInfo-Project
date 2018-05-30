package com.ssm.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.entity.Info;
import com.ssm.entity.Reply;
import com.ssm.service.InfoService;
import com.ssm.service.ReplyService;

@Controller
public class ReplyController {
	
	@Autowired
	private ReplyService rService;
	@Autowired
	private InfoService iService;
	
	@RequestMapping("/rsave.do")
	@ResponseBody
	public String save(Reply re){
		re.setReplyTime(new Date());
		int count=rService.save(re);
		if(count>0){
			Info info=iService.selectById(re.getInfoId());
			info.setReplyCount(info.getReplyCount()+1);
			info.setLastPostTime(re.getReplyTime());
			iService.update(info);
			return "success";
		}else{
			return "fail";
		}  
	}
}
