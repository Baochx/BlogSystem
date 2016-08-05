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
		Map session = ServletActionContext.getContext().getSession(); //获得session;
		String username = (String) session.get("username"); //获得username;
		if(myFile == null) {
			HttpServletRequest request = ServletActionContext.getRequest(); //获得request
			request.setAttribute("url", "showPhoto.action"); //登录失败则需要重新登录
			request.setAttribute("info", "上传失败"); //这里只是为空文件的情况;
			return ERROR;
		}
		InputStream is = new FileInputStream(myFile); //创建一个输入流
		String photoPath = ServletActionContext.getServletContext().getRealPath("/user/photo/" + username); //设置文件保存目录,得到是绝对路径
		File filePhotoPath = new File(photoPath);
		if(!filePhotoPath.isDirectory()) { 
			filePhotoPath.mkdir(); //第一次时，创建保存路径目录;
		}
		String extension = FilenameUtils.getExtension(this.getMyFileFileName()); //得到文件后缀;
		String filename = UUID.randomUUID().toString() + "."+ extension; ////解决中文文件名问题，不直接用原来的文件名而是生成一个独一无二的序号作为文件的唯一标识;
		File tofile = new File(photoPath,filename); //设置目标文件
		OutputStream os = new FileOutputStream(tofile); //使用输出流来包装目标文件
		byte[] buffer = new byte[1024];
		int length = 0;
		while((length = is.read(buffer)) > 0) {
			os.write(buffer, 0, length);
		}
		is.close(); //关闭输入流
		os.close(); //关闭输出流
		return this.SUCCESS;
	}

}

