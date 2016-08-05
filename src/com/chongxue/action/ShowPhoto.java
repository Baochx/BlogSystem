package com.chongxue.action;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.chongxue.po.BlogInfo;
import com.chongxue.service.BlogInfoService;
import com.opensymphony.xwork2.ActionSupport;

public class ShowPhoto  extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private BlogInfoService blogInfoService;
	
	public void setBlogInfoService(BlogInfoService blogInfoService) {
		this.blogInfoService = blogInfoService;
	}
	
	public BlogInfoService getBlogInfoServive() {
		return this.blogInfoService;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String execute() throws Exception {
		
		Map session = ServletActionContext.getContext().getSession(); 
		String username = (String) session.get("username"); //���username
		if(username != null || !"".equals(username)) {
			BlogInfo bloginfo  = blogInfoService.getBlogInfo(username);
			if(bloginfo != null) {
				session.put("blogtitle", bloginfo.getBlogtitle());
				session.put("idiograph", bloginfo.getIdiograph());
			}
		}
		String photoPath = ServletActionContext.getServletContext().getRealPath("/user/photo/" + username); //�����ļ�Ŀ¼
		File fphotoPath = new File(photoPath); //ʹ��File��װ
		String[] photoList = fphotoPath.list(); //������Ŀ¼������ͼƬ�ļ�
		HttpServletRequest request = ServletActionContext.getRequest(); //��ͼƬ�б����õ�request��Χ
		request.setAttribute("photoList", photoList);
		return super.execute();
	}

}

