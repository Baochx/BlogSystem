package com.chongxue.dao;

import java.util.List;
import com.chongxue.fenye.Page;
import com.chongxue.po.Critique;

public interface CritiqueDAO {
	
	public void addCritique(Critique critique); //添加评论
	public int queryCritiqueCount(int AId); //获得指定文章的评论数
	public List<Critique> queryByPage(int AId,Page page); //根据Page来查询指定文章的评论

}

