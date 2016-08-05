<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.0 Strict//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:p="http://primefaces.org/ui" lang="en" xml:lang="en" >
<head>
<title>个性化设置</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="../css/main.css" media="all" />
<!--[if IE 6]><link type="text/css" rel="stylesheet" href="css/ie6.css" media="all" /><![endif]-->
<script type="text/javascript" src="../js/mootools.js"></script>
<script type="text/javascript" src="../js/site.js"></script>
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
          <div class="comments"><div class="comment"></div>
            <h2>个性化设置</h2>
            <form class="h" action="editBlogInfo.action" method="post">
              <div>
                <label>博客标题:</label>
                <input type="text" name="blogtitle" />
                 
              </div>
              <div>
                <label>个性签名:</label>
                <input type="text" name="idiograph" />
                
              </div>
              <div>
                <label></label>
                <div class="clear"> </div>
              </div>
              <div class="button_wrapper">
                <input name="提交" type="submit" class="button" value="提交" />
              </div>
            </form>
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
      <div class="clear"  style="height:6em;"> </div>
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
