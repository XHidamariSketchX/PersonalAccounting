package com.cornu.PA.user.action;

import java.math.BigDecimal;
import java.util.Map;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.cornu.PA.bean.Account;
import com.cornu.PA.business.AccountBis;
import com.cornu.PA.business.AccountBisImpl;
import com.cornu.PA.user.bean.User;
import com.cornu.PA.user.business.UserBis;
import com.cornu.PA.user.business.UserBisImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
private static final int BUFFER_SIZE = 16 * 1024 ;
private String id;
private String username;
private String password;
private String email;
private String newPassword;

private File myPhoto;
private String contentType;
private String fileName;

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

	public String getNewPassword() {
	return newPassword;
}

public void setNewPassword(String newPassword) {
	this.newPassword = newPassword;
}

	public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public File getMyPhoto() {
	return myPhoto;
}

public void setMyPhoto(File myPhoto) {
	this.myPhoto = myPhoto;
}

public String getMyPhotoContentType() {
	return contentType;
}

public void setMyPhotoContentType(String contentType) {
	this.contentType = contentType;
}

public String getMyPhotoFileName() {
	return fileName;
}

public void setMyPhotoFileName(String fileName) {
	this.fileName = fileName;
}

	public String regist() throws Exception {
		
		User user=new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setUsername(username);
		UserBis userbis=new UserBisImpl();
		int result=userbis.regist(user);
		ActionContext ctx=ActionContext.getContext();
		Map request=(Map) ctx.get("request");
		if(result==User.REGIST_FAILED){
			request.put("registMsg", " 注册错误");
			return ERROR;
		}
		else if(result==User.REGIST_SUCCESS){
			request.put("loginMsg", " 注册成功");
			return SUCCESS;
		}
		else if(result==User.REGIST_HAS){
			request.put("registMsg", " 用户"+user.getUsername()+"已存在");
			return ERROR;
		}
		else{
			request.put("registMsg", " 注册错误");
			return ERROR;
		}
			
		
		
	}
	public String login() throws Exception{
		User user=new User();//实例化同于保存要登录用户信息
		user.setEmail(email);
		user.setPassword(password);
		user.setUsername(username);
		UserBis userbis=new UserBisImpl();//实例化用户业务层	
		User loginuser=userbis.login(user);
		if(loginuser==null){
			ActionContext ctx=ActionContext.getContext();
			Map request=(Map) ctx.get("request");
			request.put("loginMsg", " 用户名或密码错误");
			return ERROR;
		}
		else{
			ActionContext ctx=ActionContext.getContext();
			ctx.getSession().put("loginuser", loginuser);
			return SUCCESS;
		}
		
	}
	public String logout(){
		ActionContext ctx=ActionContext.getContext();
		ctx.getSession().clear();
		return SUCCESS;
	}
	public String modifyPassword(){
		ActionContext ctx=ActionContext.getContext();
		User user=(User)ctx.getSession().get("loginuser");
		Map request=(Map) ctx.get("request");
		if(user==null){
			request.put("loginMsg", " 修改密码前需登录！");
			return "need_login";
		}
		
		if(!this.getPassword().equals(user.getPassword())){
			request.put("modifyPasswordMsg", " 密码错误");
			return ERROR;
		}
		user.setPassword(this.getNewPassword());
		UserBis userbis=new UserBisImpl();//实例化用户业务层
		userbis.modifyPassword(user);
		ctx.getSession().put("loginuser", user);
		request.put("loginMsg", " 密码修改成功，请重新登录");
		return SUCCESS;
	}
	 private static void copy(File src, File dst) {
         try {
            InputStream in = null ;
            OutputStream out = null ;
             try {                
                in = new BufferedInputStream( new FileInputStream(src), BUFFER_SIZE);
                out = new BufferedOutputStream( new FileOutputStream(dst), BUFFER_SIZE);
                 byte [] buffer = new byte [BUFFER_SIZE];
                 while (in.read(buffer) > 0 ) {
                    out.write(buffer);
                } 
            } finally {
                 if ( null != in) {
                    in.close();
                } 
                 if ( null != out) {
                    out.close();
                } 
            } 
        } catch (Exception e) {
            e.printStackTrace();
        } 
    } 
	 private static String getExtention(String fileName) {
         int pos = fileName.lastIndexOf(".");
         return fileName.substring(pos);
    } 
	public String photoUpload(){
		ActionContext ctx=ActionContext.getContext();
		User user=(User)ctx.getSession().get("loginuser");
		String photoFileName = user.getId()+getExtention(this.getMyPhotoFileName());
	    File imageFile = new File(ServletActionContext.getServletContext().getRealPath( "user/UploadPhotos" ) + "/"+photoFileName);
	    copy(myPhoto, imageFile);
		return SUCCESS;
	}
}
