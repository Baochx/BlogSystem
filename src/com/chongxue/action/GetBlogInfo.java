package com.chongxue.action;

import java.util.Map;





import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.chongxue.po.BlogInfo;
import com.chongxue.service.BlogInfoService;

public class GetBlogInfo extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private BlogInfoService blogInfoService;

	public BlogInfoService getBlogInfoService() {
		return blogInfoService;
	}
	
	public void setBlogInfoService(BlogInfoService blogInfoService) {
		this.blogInfoService = blogInfoService;
	}
	
	@SuppressWarnings({ "unchecked", "static-access", "rawtypes"})
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		String username = (String)session.get("username");
		BlogInfo bloginfo  = blogInfoService.getBlogInfo(username); //从session中取出username,再根据username得到个性化信息
		if(bloginfo != null) {
			session.put("blogtitle", bloginfo.getBlogtitle());
			session.put("idiograph", bloginfo.getIdiograph());
		}
		return this.SUCCESS;
	}

}

