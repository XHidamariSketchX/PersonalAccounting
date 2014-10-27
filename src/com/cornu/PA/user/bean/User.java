package com.cornu.PA.user.bean;

public class User {
public static int LOGIN_FAILED=0;
public static int REGIST_SUCCESS=1;
public static int LOGIN_SUCCESS=2;
public static int REGIST_FAILED=3;
public static int REGIST_HAS=4;

private int id;
private String username;
private String password;
private String email;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
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

}
