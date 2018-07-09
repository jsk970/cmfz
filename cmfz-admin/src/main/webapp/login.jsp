<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>持名法州后台管理中心</title>
			
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
	<link rel="icon" href="${pageContext.request.contextPath }/img/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css" type="text/css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/login.css" type="text/css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath }/script/jquery.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/script/common.js"></script>
	<script type="text/javascript">
	
		$(function(){
		    $.ajax({
                type:"POST",
                url:"${pageContext.request.contextPath}/getCookie.do",
                success:function(result){
                    $("input[name='name']").val(result);
                }
			});
            //  form 表单提交
            $("#loginForm").bind("submit",function(){
                $.ajax({
                    type:"POST",
                    url:"<c:url context='${pageContext.request.contextPath}' value='/login.do'/>",
					dataType:"text",
					data:$("#loginForm").serialize(),
                    success:function(result){
						alert(result);
						//var result = JSON.parse(message);
                       if(result == "success"){
                           window.confirm("登陆成功！");
						   window.location.href = "main.jsp";
                       }else if(result == "errorCode"){
                           window.confirm("验证码错误");
					   }else{
                           window.confirm("用户名或密码错误！");
                       }
                    },
                });
                return false;
            });


		});
	</script>
</head>
<body>
<div class="login">

	<form id="loginForm" method="post">

		<table>
			<tbody>
			<tr>
				<td width="190" rowspan="2" align="center" valign="bottom">
					<img src="img/header_logo.gif" />
				</td>
				<th>
					用户名:
				</th>
				<td>
					<input type="text"  name="name" class="text" value="" maxlength="20" required/>
				</td>
			</tr>
			<tr>
				<th>
					密&nbsp;&nbsp;&nbsp;码:
				</th>
				<td>
					<input type="password" name="password" class="text" value="" maxlength="20" autocomplete="off" required/>
				</td>
			</tr>

			<tr>
				<td>&nbsp;</td>
				<th>验证码:</th>
				<td>
					<input type="text" id="enCode" name="enCode" class="text captcha" maxlength="4" autocomplete="off" required/>
					<img src="<c:url context='${pageContext.request.contextPath}' value='/code.do'/>"
						 style="cursor:pointer; width: 80px;height: 20px ;line-height:30px;"
						 title="看不清可单击图片刷新"
						 onclick="this.src='<c:url value="/code.do" />?q='+Math.random();" />
				</td>
			</tr>
			<tr>
				<td>
					&nbsp;
				</td>
				<th>
					&nbsp;
				</th>
				<td>
					<label>
						<input type="checkbox" id="isRememberUsername" name="RememberUsername" value="true"/> 记住用户名
					</label>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<th>&nbsp;</th>
				<td>
					<input type="button" class="homeButton" value="" ><input type="submit" class="loginButton" value="登录">
				</td>
			</tr>
			</tbody></table>
		<div class="powered">COPYRIGHT © 2008-2017.</div>
		<div class="link">
			<a href="http://www.chimingfowang.com/">持名佛网首页</a> |
			<a href="http://www.chimingbbs.com/">交流论坛</a> |
			<a href="">关于我们</a> |
			<a href="">联系我们</a> |
			<a href="">授权查询</a>
		</div>
	</form>
</div>
</body>
</html>