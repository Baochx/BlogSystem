<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<title>�²���ע��</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="css/main.css" media="all" />
<!--[if IE 6]><link type="text/css" rel="stylesheet" href="css/ie6.css" media="all" /><![endif]-->
<script type="text/javascript" src="js/mootools.js"></script>
<script type="text/javascript" src="js/site.js"></script>
</head>
<body>
<div id="wrapper">
  <div id="container">
    <div id="scene"> <img src="images/scene_1.gif" alt="" />
     <h1>֪�в���
     		<p><span style="font-size:20px">֪���� �б���</span><p>
     	</h1>
      <div id="menu">
        <div class="holder"> <a href="showAllArticle.action">������ҳ</a> </div>
        <div class="holder"> <a href="register.jsp">ע ��</a> </div>
        <div class="holder"> <a href="login.jsp">�� ¼</a> </div>
      </div>
    </div>
    <div id="content">
      <div id="col_left">
        <div class="post">
          <div class="meta"></div>
          <div class="comments"><div class="comment"></div>
            <h2>�²���ע��</h2>
            <form class="h" action="register.action" method="post">
              <div>
                <label>�ʺ�:</label>
                <input type="text" name="username"/><span>*</span>
                <s:fielderror><s:param>username</s:param></s:fielderror>
              </div>
              <div>
                <label>����:</label>
               <input type="password" name="password"/><span>*</span>
               <s:fielderror><s:param>password</s:param></s:fielderror>
              </div>
			   <div>
                <label>ȷ������:</label>
                <input type="password" name="repassword"/><span>*</span>
                <s:fielderror><s:param>repassword</s:param></s:fielderror>
              </div>
			   <div>
                <label>�ǳ�:</label>
                <input type="text" name="nickname"/><span>*</span>
                <s:fielderror><s:param>nickname</s:param></s:fielderror>
              </div>
			   <div>
                <label>���뱣������:</label>
                <input type="text" name="question"/><span>*</span>
				<s:fielderror><s:param>question</s:param></s:fielderror>
              </div>
			   <div>
                <label>���뱣����:</label>
                <input type="text" name="answer"/><span>*</span>
                <s:fielderror><s:param>answer</s:param></s:fielderror>
              </div>
              <div>
                <label></label>
                <div class="clear"> </div>
              </div>
              <div class="button_wrapper">
                <input name="�ύ" type="submit" class="button" value="ע��" />
              </div>
            </form>
          </div>
        </div>
      </div>
      
      <div id="col_right">
      <div id="col_right1"></div>
        <div id="sidebar">
          <h2>ҳ�浼��</h2>
          <ul>
            <li><a href="showAllArticle.action">������ҳ</a></li>
            <li><a href="register.jsp">ע ��</a></li>
            <li><a href="login.jsp">�� ¼</a></li>
          </ul>
        </div>
      </div>
      <div class="clear"> </div>
    </div>
    <div id="footer">
      <div class="clear"> </div>
      <hr />
      <p class="credit">֪�в���</p>
    </div>
  </div>
</div>
</body>
</html>