package com.chongxue.dao;

import java.util.List;
import com.chongxue.fenye.Page;
import com.chongxue.po.Critique;

public interface CritiqueDAO {
	
	public void addCritique(Critique critique); //�������
	public int queryCritiqueCount(int AId); //���ָ�����µ�������
	public List<Critique> queryByPage(int AId,Page page); //����Page����ѯָ�����µ�����

}

