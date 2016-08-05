package com.chongxue.action;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.chongxue.fenye.Page;
import com.chongxue.fenye.Result;
import com.chongxue.po.Article;
import com.chongxue.service.ArticleService;
import com.opensymphony.xwork2.ActionSupport;

public class ShowAllArticle extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private ArticleService articleService;
	private int currentPage;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	@SuppressWarnings({ "rawtypes", "unchecked"})
	public String execute() throws Exception {
		//根据需要展示的页面来取出文章以及相应的评论;因为服务器每次返回一个html界面;
		Page page = new Page();
		page.setCurrentPage(this.getCurrentPage()); //此时currentPage==0,不过pageUtil的方法会使它变为1
		page.setEveryPage(10); //设置每页显示10篇文章
		Result result = articleService.showArticleByPage(page);
		page = result.getPage();
		List<Article> all = result.getList();
		//用于显示文章摘要，但没有解决html解析问题;
		/*List<String> summery = new ArrayList<String>();
		for(Article article : all) {
			int length = article.getContent().length();
			if (length < 200) {
				summery.add(article.getContent().substring(0, length-1));
			} else {
				summery.add(article.getContent().substring(0, 200));
			}
			System.out.println(summery);
		}*/
		List critiqueCounts = new ArrayList();
		for(Article article : all) {
			critiqueCounts.add(articleService.getCritiqueCount(article.getId())); //得到评论数集合
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("all", all);
		request.setAttribute("page", page);
		request.setAttribute("critiqueCounts",critiqueCounts);
		//request.setAttribute("summery", summery);
		return SUCCESS;
	}

}

