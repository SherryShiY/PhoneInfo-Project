package com.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.ssm.entity.Reply;

public interface ReplyMapper {
	
	@Select("select * from replies where infoid=#{infoid} order by replyTime desc")
	List<Reply> getList(Integer infoid); //查询回复
	
	@Insert("insert into replies(content,replyTime,infoId) values(#{content},#{replyTime},#{infoId})")
	int save(Reply re);
}
