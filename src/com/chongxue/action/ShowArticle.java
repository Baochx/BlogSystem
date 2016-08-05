package com.chongxue.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.chongxue.fenye.Page;
import com.chongxue.fenye.Result;
import com.chongxue.po.Article;
import com.chongxue.po.BlogInfo;
import com.chongxue.service.ArticleService;
import com.chongxue.service.BlogInfoService;
import com.chongxue.service.CritiqueService;
import com.chongxue.service.DianjiliangService;

public class ShowArticle extends ActionSupport {

	private int id; //从上一个页面传递进来的参数，用于获取文章评论
	private String username; //从上一个页面传递进来的参数不是session里面的参数
	private int currentPage; //从上一个页面传递进来
	private static final long serialVersionUID = 1L;
	private ArticleService articleService;
	private DianjiliangService dianjiliangService;
	private CritiqueService critiqueService;
	private BlogInfoService blogInfoService;
	
	public BlogInfoService getBlogInfoService() {
		return blogInfoService;
	}

	public void setBlogInfoService(BlogInfoService blogInfoService) {
		this.blogInfoService = blogInfoService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public CritiqueService getCritiqueService() {
		return critiqueService;
	}
	
	public void setCritiqueService(CritiqueService critiqueService) {
		this.critiqueService = critiqueService;
	}

	public DianjiliangService getDianjiliangService() {
		return dianjiliangService;
	}

	public void setDianjiliangService(DianjiliangService dianjiliangService) {
		this.dianjiliangService = dianjiliangService;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	@SuppressWarnings({ "unchecked", "static-access", "rawtypes"})
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		Article article = articleService.showArticle(id); //获取文章
		String IP = request.getRemoteAddr();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //精确到日,所以能判断今日该IP今日是否点击过了，一人一天只能点击一次
		String stime = sdf.format(new Date());
		Date time = sdf.parse(stime);
		if (!dianjiliangService.isVistor(id, IP, time)) {
			article.setHasread(article.getHasread() + 1); //如果当天没有visit过就增加文章的点击量
		}
		//为了更新该文章的点击量，这也是为什么articleDAO里面用的是saveOrUpdate()的原因。因为有的地方需要保存发表的新文章而有的地方则需要更新旧文章的点击量。
		articleService.addArticle(article);
		Page page = new Page();
		page.setCurrentPage(this.getCurrentPage());
		page.setEveryPage(5); //每页显示5条评论
		Result result = critiqueService.showCritiqueByPage(id, page); 
		request.setAttribute("page", result.getPage()); //page的作用是设置当前是第几页，判断是否还有上一页或者下一页
		request.setAttribute("allCri", result.getList()); //list里面是评论(主要是评论者username和内容content)，跟之前获取文章是一样的逻辑
		request.setAttribute("article", article); //具体的文章内容
		
		if(username != null || !"".equals(username)) { //下一页不会再传递username,但是作者的个性化内容已经保存在session里面了
			Map session = ActionContext.getContext().getSession();
			BlogInfo bloginfo  = blogInfoService.getBlogInfo(username);
			if(bloginfo != null) {
				session.put("blogtitle", bloginfo.getBlogtitle());
				session.put("idiograph", bloginfo.getIdiograph());
			}
		}
		return this.SUCCESS;
	}
	
}

