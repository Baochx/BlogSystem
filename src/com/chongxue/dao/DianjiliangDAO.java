package com.chongxue.dao;

import java.util.Date;
import java.util.List;
import com.chongxue.po.Dianjiliang;

public interface DianjiliangDAO {

	@SuppressWarnings("rawtypes")
	public List queryByAId(int AId, String IP, Date time); //���ظ����£���ip����ʱ��ķ��ʼ�¼
	public void addJilu(Dianjiliang dianjiliang); //��ӷ��ʼ�¼

}

