<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
  $(function(){
	  $('.base:odd').css("background","green");
  });
</script>
</head>
<body>
 <div align="center">
      <h2>手机资讯</h2>
      <table width="50%">
	       <tr bgcolor="blue">
	        <th>序号</th>
	        <th>标题</th>
	        <th>回复|查看</th>
	        <th>发表时间</th>
	        <th>最新回复</th>
	       </tr>
	      <c:forEach items="${list}" var="i">
	       <tr class="base">
		        <th>${i.id}</th>
		        <th><a href="iDetail.do?id=${i.id}">${i.title}</a></th>
		        <th>${i.replyCount}|${i.viewCount}</th>
		        <th><fmt:formatDate pattern='yyyy-MM-dd HH:mm:ss' value="${i.reportTime}"/></th>
		        <th><fmt:formatDate pattern='yyyy-MM-dd HH:mm:ss' value="${i.lastPostTime}"/></th>
	       </tr>
	       </c:forEach> 
      </table>
  </div>
</body>
</html>