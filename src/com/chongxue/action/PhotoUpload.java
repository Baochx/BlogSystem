package com.chongxue.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class PhotoUpload  extends ActionSupport {

	private File myFile;
	private String myFileContentType;
	private String myFileFileName;

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}



	@SuppressWarnings({"static-access", "rawtypes"})
	public String execute() throws Exception {
		Map session = ServletActionContext.getContext().getSession(); //���session;
		String username = (String) session.get("username"); //���username;
		if(myFile == null) {
			HttpServletRequest request = ServletActionContext.getRequest(); //���request
			request.setAttribute("url", "showPhoto.action"); //��¼ʧ������Ҫ���µ�¼
			request.setAttribute("info", "�ϴ�ʧ��"); //����ֻ��Ϊ���ļ������;
			return ERROR;
		}
		InputStream is = new FileInputStream(myFile); //����һ��������
		String photoPath = ServletActionContext.getServletContext().getRealPath("/user/photo/" + username); //�����ļ�����Ŀ¼,�õ��Ǿ���·��
		File filePhotoPath = new File(photoPath);
		if(!filePhotoPath.isDirectory()) { 
			filePhotoPath.mkdir(); //��һ��ʱ����������·��Ŀ¼;
		}
		String extension = FilenameUtils.getExtension(this.getMyFileFileName()); //�õ��ļ���׺;
		String filename = UUID.randomUUID().toString() + "."+ extension; ////��������ļ������⣬��ֱ����ԭ�����ļ�����������һ����һ�޶��������Ϊ�ļ���Ψһ��ʶ;
		File tofile = new File(photoPath,filename); //����Ŀ���ļ�
		OutputStream os = new FileOutputStream(tofile); //ʹ�����������װĿ���ļ�
		byte[] buffer = new byte[1024];
		int length = 0;
		while((length = is.read(buffer)) > 0) {
			os.write(buffer, 0, length);
		}
		is.close(); //�ر�������
		os.close(); //�ر������
		return this.SUCCESS;
	}

}

