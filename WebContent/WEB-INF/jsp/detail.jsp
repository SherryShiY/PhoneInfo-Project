<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
  $(function(){
	  $('#bu').click(function(){
	     var content=$('[name=content]').val();
	     var infoId=$('[name=infoId]').val();
		 if(content==""||content.length<6 ||content.length>200){
			 $('#msg').html('回复内容不能为空且6-200字以内');
		 }else{
			 $('#msg').html('');
			 $.ajax({
				  type:'post',
				  url:'rsave.do',
				  data:{"content":content,"infoId":infoId},
				  dateType:"text",
				  success:function(result){
					  if(result=="success"){
					    var content=$('[name=content]').val();
		                var $p=$("<p></p>");
		                var $span1=$("<span>发表于:"+new Date()+"</span><br>");
		                var $span2=$("<span>"+content+"</span>");
		                $($p).append($span1);
		                $($p).append($span2);
		                $('h3[id=base]').after($p);
		                $('[name=content]').val('');
					  }
				  }
				}); 
		   } 
		});
  });
</script>
</head>
<body>
 <div align="left">
    <h3>${i.title}</h3>
    <span>发表于:<fmt:formatDate value="${i.reportTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
    <h3 id="base">读者回应</h3>
    <c:forEach items="${rlist}" var="r">
      <p>
	    <span>发表于:<fmt:formatDate value="${r.replyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span><br>
	    <span>${r.content}</span>
	  <p>
    </c:forEach>
    <h3>快速回复(200字以内)</h3>
    <form action="" id="form">
        <input type="hidden" value="${i.id}" name="infoId"/>
	    <textarea rows="5" cols="20" name="content"></textarea><div id="msg" style="color:red"></div><br>
	    <input type="button" id="bu" value="提交"/>&nbsp;<a href="infoList.do">返回首页</a>
    </form>
   </div>
</body>
</html>