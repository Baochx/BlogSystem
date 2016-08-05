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

	private int id; //����һ��ҳ�洫�ݽ����Ĳ��������ڻ�ȡ��������
	private String username; //����һ��ҳ�洫�ݽ����Ĳ�������session����Ĳ���
	private int currentPage; //����һ��ҳ�洫�ݽ���
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
		Article article = articleService.showArticle(id); //��ȡ����
		String IP = request.getRemoteAddr();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //��ȷ����,�������жϽ��ո�IP�����Ƿ������ˣ�һ��һ��ֻ�ܵ��һ��
		String stime = sdf.format(new Date());
		Date time = sdf.parse(stime);
		if (!dianjiliangService.isVistor(id, IP, time)) {
			article.setHasread(article.getHasread() + 1); //�������û��visit�����������µĵ����
		}
		//Ϊ�˸��¸����µĵ��������Ҳ��ΪʲôarticleDAO�����õ���saveOrUpdate()��ԭ����Ϊ�еĵط���Ҫ���淢��������¶��еĵط�����Ҫ���¾����µĵ������
		articleService.addArticle(article);
		Page page = new Page();
		page.setCurrentPage(this.getCurrentPage());
		page.setEveryPage(5); //ÿҳ��ʾ5������
		Result result = critiqueService.showCritiqueByPage(id, page); 
		request.setAttribute("page", result.getPage()); //page�����������õ�ǰ�ǵڼ�ҳ���ж��Ƿ�����һҳ������һҳ
		request.setAttribute("allCri", result.getList()); //list����������(��Ҫ��������username������content)����֮ǰ��ȡ������һ�����߼�
		request.setAttribute("article", article); //�������������
		
		if(username != null || !"".equals(username)) { //��һҳ�����ٴ���username,�������ߵĸ��Ի������Ѿ�������session������
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

