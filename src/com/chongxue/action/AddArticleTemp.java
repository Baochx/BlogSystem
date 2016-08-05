package com.chongxue.action;

import java.util.Map;

import com.chongxue.po.BlogInfo;
import com.chongxue.service.BlogInfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddArticleTemp extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private BlogInfoService blogInfoService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String excute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		String username = (String)session.get("username");
		System.out.println("hello I am from addArticleTeml Action!");
		if (username != null || "".equals(username)) {
			BlogInfo bloginfo  = blogInfoService.getBlogInfo(username);
			session.put("blogtile", bloginfo.getBlogtitle());
			session.put("idiograph", bloginfo.getIdiograph());
		}
		return SUCCESS;
	}
	
}
