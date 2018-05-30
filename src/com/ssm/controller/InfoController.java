package com.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.entity.Info;
import com.ssm.entity.Reply;
import com.ssm.service.InfoService;
import com.ssm.service.ReplyService;

	@Controller
public class InfoController {
	
	@Autowired
	private InfoService iService;
	
	@Autowired
	private ReplyService rService;
	
	@RequestMapping("/infoList.do")
	public ModelAndView getList(){
		List<Info> ilist=iService.getList();
		return new ModelAndView("list","list",ilist);
	}
	
	@RequestMapping("/iDetail.do")
	public ModelAndView selectById(Integer id){
		Info info=iService.selectById(id);
		info.setViewCount(info.getViewCount()+1);
		int count=iService.update(info);
		if(count>0){
			List<Reply> rlist=rService.getList(id);
			ModelAndView mv=new ModelAndView();
			mv.addObject("i",info);
			mv.addObject("rlist",rlist);
			mv.setViewName("detail");
			return mv;
		}else{
			return null;
		}
	}
}
