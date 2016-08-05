<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<title>相册</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="../css/main.css" media="all" />
<!--[if IE 6]><link type="text/css" rel="stylesheet" href="css/ie6.css" media="all" /><![endif]-->
<script type="text/javascript">
		    var GB_ROOT_DIR = "./greybox/";
</script>
<script type="text/javascript" src="greybox/AJS.js"></script>
<script type="text/javascript" src="greybox/AJS_fx.js"></script>
<script type="text/javascript" src="greybox/gb_scripts.js"></script>
<link href="greybox/gb_styles.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="wrapper">
  <div id="container">
    <div id="scene"> <img src="../images/scene_1.gif" alt="" />
      <h1>${empty sessionScope.blogtitle ? "知行博客":sessionScope.blogtitle} 
     		<p><span style="font-size:20px">${empty sessionScope.idiograph ? "知而行 行必至":sessionScope.idiograph}</span><p>
     	</h1>
     
      <div id="menu">
        <div class="holder"> <a href="../showAllArticle.action">博客首页</a> </div>
        <div class="holder"> <a href="showUserAllArticle.action">用户首页</a> </div>
        <div class="holder"> <a href="editbloginfo.jsp">个性化设置</a> </div>
        <div class="holder"> <a href="addArticle.jsp">写日志</a> </div>
        <div class="holder"> <a href="showPhoto.action">相册</a> </div>
        <div class="holder"> <a href="exit.action">退出</a></div>
      </div>
    </div>
    <div id="content">
      <div id="col_left">
        <div class="post">
          <div class="meta"></div>
          <div class="comments">
            <h2>上传图片</h2>
            <form action="photoUpload.action" method="post" enctype="multipart/form-data">
              <div>
                <label>选择要上传的图片：</label>
                <input type="file" name="myFile"/>
              </div>
              <div>
                <label></label>
                <div class="clear"> </div>
              </div>
              <div class="button_wrapper">
                <input name="提交" type="submit" class="button" value="上传" />
              </div>
            </form>
          </div>
          
          <div class="comments">
            <h2><a href="showPhoto.action" style="text-decoration:none;">显示相册图片</a></h2>
            <table cellspacing="5" align="center" border="1">
           	<tr>
           	<s:iterator value="#request.photoList" id="photo" status="stu">
				<td>
					<a href='photo/${sessionScope.username}/<s:property value="photo"/>' title="我的相册" rel="gb_imageset[photos]">
						<img src='photo/${sessionScope.username}/<s:property value="photo"/>' width="105" height="130">
					</a>	
				</td>
				<s:if test="(#stu.index + 1) % 5 == 0">
					</tr>
					<tr>
				</s:if>
			</s:iterator>
			</table>
          </div>
        </div>
      </div>
      <div id="col_right">
        <div id="col_right1"></div>
        <div id="sidebar">
          <h2>页面导航</h2>
          <ul>
            <li><a href="../showAllArticle.action">博客首页</a></li>
        	<li><a href="showUserAllArticle.action">用户首页</a></li>
        	<li><a href="editbloginfo.jsp">个性化设置</a></li>
        	<li><a href="addArticle.jsp">写日志</a></li>
       		<li><a href="showPhoto.action">相册</a></li>
          </ul>
        </div>
      </div>
      <div class="clear"> </div>
    </div>
    <div id="footer">
      <div class="clear"> </div>
      <hr />
      <p class="credit">知行博客</p>
    </div>
  </div>
</div>
</body>
</html>
