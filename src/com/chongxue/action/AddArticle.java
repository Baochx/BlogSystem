package com.chongxue.action;

import java.util.Date;
import java.util.Map;





import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.chongxue.po.Article;
import com.chongxue.service.ArticleService;

public class AddArticle extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private String title;
	private String content;
	private ArticleService articleService;

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@SuppressWarnings("static-access")
	public String execute() throws Exception {
		@SuppressWarnings("rawtypes")
		Map session = ActionContext.getContext().getSession();
		String username = (String) session.get("username");
		Article article = new Article(); //封装一个文章对象
		article.setTitle(title);
		article.setContent(content);
		article.setUsername(username);
		article.setDate(new Date());
		article.setHasread(0);
		articleService.addArticle(article); //调用逻辑层组件保存文章;
		return this.SUCCESS;
	}

}

