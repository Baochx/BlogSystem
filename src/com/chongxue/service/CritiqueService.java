package com.chongxue.service;

import com.chongxue.fenye.Page;
import com.chongxue.fenye.Result;
import com.chongxue.po.Critique;

public interface CritiqueService {
	
	public void addCritique(Critique critique); //�������
	public Result showCritiqueByPage(int AId,Page page); //��ҳ��ʾ����
	public int getCritiqueCount(int AId); //���ָ�����µ�������

}

