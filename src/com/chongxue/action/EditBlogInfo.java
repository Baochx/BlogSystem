package com.chongxue.action;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.chongxue.po.BlogInfo;
import com.chongxue.service.BlogInfoService;

public class EditBlogInfo extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String blogtitle;
	private String idiograph;
	private BlogInfoService blogInfoService;

	public BlogInfoService getBlogInfoService() {
		return blogInfoService;
	}
	
	public void setBlogInfoService(BlogInfoService blogInfoService) {
		this.blogInfoService = blogInfoService;
	}

	public String getBlogtitle() {
		return blogtitle;
	}

	public void setBlogtitle(String blogtitle) {
		this.blogtitle = blogtitle;
	}

	public String getIdiograph() {
		return idiograph;
	}

	public void setIdiograph(String idiograph) {
		this.idiograph = idiograph;
	}

	@SuppressWarnings("static-access")
	public String execute() throws Exception {
		//HttpServletRequest request = ServletActionContext.getRequest();
		//HttpSession session =request.getSession();
		//String username = (String) session.getAttribute("username");
		@SuppressWarnings("rawtypes")
		Map session = ActionContext.getContext().getSession();
		String username = (String)session.get("username");
		//ע�͵���if else���������������������;
		/*if (username == null || "".equals(username)) {
			return LOGIN;
		} else {*/
			BlogInfo blogInfo = new BlogInfo(); //��װ���Ի���Ϣ
			blogInfo.setUsername(username);
			blogInfo.setBlogtitle(blogtitle);
			blogInfo.setIdiograph(idiograph);
			blogInfoService.setBlogInfo(blogInfo); //����ҵ���߼�������������
			return this.SUCCESS;
		//}
	}

}

