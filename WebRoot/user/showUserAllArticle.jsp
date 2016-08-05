<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<title>�ҵ�ȫ������</title>
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
       <h1>${empty sessionScope.blogtitle ? "֪�в���":sessionScope.blogtitle} 
     		<p><span style="font-size:20px">${empty sessionScope.idiograph ? "֪���� �б���":sessionScope.idiograph}</span><p>
     	</h1>
      
      <div id="menu">
         <div class="holder"> <a href="../showAllArticle.action">������ҳ</a> </div>
        <div class="holder"> <a href="showUserAllArticle.action">�û���ҳ</a> </div>
        <div class="holder"> <a href="editbloginfo.jsp">���Ի�����</a> </div>
        <div class="holder"> <a href="addArticle.jsp">д��־</a> </div>
        <div class="holder"> <a href="showPhoto.action">���</a> </div>
        <div class="holder"> <a href="exit.action">�˳�</a></div>
      </div>
    </div>
    <div id="content">
      <div id="col_left">
        <div class="post">
          <div class="meta"><a class="title" href="">�ҵ�ȫ������</a>
            <div class="clear"></div>
          </div>
        <!-- ѭ����� ����status������ǰʵ�� -->
		<s:iterator value="#request.all" id="art" status="sta">
          <div class="comments">
            <div class="comment">
            <!-- ��ȡ������Ҳ�ͼ�ӻ�ȡ�����ߣ�����username,id��Ϊ�˻�ȡ���Ի���Ϣ������  -->
              <div class="meta"> <span><a href="showArticle.action?username=<s:property value='#art.username'/>&id=<s:property value='#art.id'/>"><s:property value="#art.title"/></a> <small>:</small></span>
                <div class="clear"> </div>
              </div>
            </div>
            <div class="comment alt">
              <div class="meta"><span class="datetime">
              	<!-- ����ʱ�� -->
														������:
														<s:date name="#art.date"/>
														<!-- ���������� -->
														|����(<s:property value="#request.critiqueCounts[#sta.index]"/>)|���(<s:property value="#art.hasread"/>)
              </span>
                <div class="clear"> </div>
              </div>
            </div>
          </div>
		 </s:iterator>
		  <div class="comment1" align="center">
		  	<span>��ǰ��  ${page.currentPage} ҳ����  ${page.totalPage} ҳ��ÿҳ��ʾ ${page.everyPage} ����¼</span>
			<s:if test="#request.page.hasPrePage">
				<a href="showUserAllArticle.action?currentPage=1">��ҳ</a>
				<a href="showUserAllArticle.action?currentPage=${page.currentPage -1 }">��һҳ</a>
			</s:if>
			<s:else>
				<span>��ҳ</span>
				<span>��һҳ</span>
			</s:else>
			
			<s:if test="#request.page.hasNextPage">
				<a href="showUserAllArticle.action?currentPage=${page.currentPage + 1 }">��һҳ</a>
				<a href="showUserAllArticle.action?currentPage=${page.totalPage }">βҳ</a>			
			</s:if>
			<s:else>
				<span>��һҳ</span>
				<span>βҳ</span>
			</s:else>
		  </div>
        </div>
      </div>
      <div id="col_right">
        <div id="col_right1"></div>
        <div id="sidebar">
          <h2>ҳ�浼��</h2>
          <ul>
             <li><a href="../showAllArticle.action">������ҳ</a></li>
        	<li><a href="showUserAllArticle.action">�û���ҳ</a></li>
        	<li><a href="editbloginfo.jsp">���Ի�����</a></li>
        	<li><a href="addArticle.jsp">д��־</a></li>
       		<li><a href="showPhoto.action">���</a></li>
          </ul>
        </div>
      </div>
      <div class="clear"> </div>
    <div id="footer">
      <div class="clear"> </div>
      <hr />
      <p class="credit">֪�в���</p>
    </div>
  </div>
</div>
</body>
</html>