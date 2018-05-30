package com.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ssm.entity.Info;

public interface InfoMapper {
	@Select("select * from info order by lastPostTime desc")
	List<Info> getList(); //查询所有资讯
	
	@Select("select * from info where id=#{id}")
	Info selectById(Integer id);
	
	@Update("update info set viewCount=#{viewCount},replyCount=#{replyCount},lastPostTime=#{lastPostTime} where id=#{id}")
    int update(Info info);
}
