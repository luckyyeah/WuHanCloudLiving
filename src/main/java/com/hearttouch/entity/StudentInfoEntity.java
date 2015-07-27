package com.hearttouch.entity;

/**
 * @author admin
 *
 */
public class StudentInfoEntity {
	String	 open_id;

	String   school;
	String   school_name;
	String   nickname;
	String   headimgurl;	
	String   name;
	String   tel;
	String   id_card;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getId_card() {
		return id_card;
	}
	public void setId_card(String id_card) {
		this.id_card = id_card;
	}	
public String getNickname() {
	return nickname;
}
public void setNickname(String nickname) {
	this.nickname = nickname;
}
public String getHeadimgurl() {
	return headimgurl;
}
public void setHeadimgurl(String headimgurl) {
	this.headimgurl = headimgurl;
}


public String getSchool_name() {
	return school_name;
}
public void setSchool_name(String school_name) {
	this.school_name = school_name;
}


public String getOpen_id() {
	return open_id;
}
public void setOpen_id(String open_id) {
	this.open_id = open_id;
}
public String getSchool() {
	return school;
}
public void setSchool(String school) {
	this.school = school;
}


}
