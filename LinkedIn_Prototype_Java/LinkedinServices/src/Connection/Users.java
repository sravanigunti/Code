package Connection;
//import java.io.Serializable;
public class Users {
private int user_id;
private String username;
private String email_id;
private String password;
private String summary;
private String loginFlag;
private String lastLoginDate;
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getEmail_id() {
	return email_id;
}
public void setEmail_id(String email_id) {
	this.email_id = email_id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getSummary() {
	return summary;
}
public void setSummary(String summary) {
	this.summary = summary;
}
public String getLoginFlag() {
	return loginFlag;
}
public void setLoginFlag(String loginFlag) {
	this.loginFlag = loginFlag;
}
public String getLastLoginDate() {
	return lastLoginDate;
}
public void setLastLoginDate(String lastLoginDate) {
	this.lastLoginDate = lastLoginDate;
}


}
