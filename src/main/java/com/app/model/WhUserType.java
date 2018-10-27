package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wh_user_tab")
public class WhUserType {

	@Id
	@GeneratedValue
	@Column(name = "uid")
	private Integer id;

	@Column(name = "utype")
	private String type;

	@Column(name = "ucode")
	private String code;

	@Column(name = "forType")
	private String forType;

	@Column(name = "umail")
	private String email;

	@Column(name = "contact")
	private String contact;

	@Column(name = "uid_type")
	private String idType;

	@Column(name = "uid_other")
	private String ifOther;

	@Column(name = "uid_Num")
	private String idNum;

	public WhUserType() {
		super();
	}

	public WhUserType(Integer id) {
		super();
		this.id = id;
	}

	public WhUserType(Integer id, String type, String code, String forType, String email, String contact, String idType,
			String ifOther, String idNum) {
		super();
		this.id = id;
		this.type = type;
		this.code = code;
		this.forType = forType;
		this.email = email;
		this.contact = contact;
		this.idType = idType;
		this.ifOther = ifOther;
		this.idNum = idNum;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getForType() {
		return forType;
	}

	public void setForType(String forType) {
		this.forType = forType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIfOther() {
		return ifOther;
	}

	public void setIfOther(String ifOther) {
		this.ifOther = ifOther;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	@Override
	public String toString() {
		return "WhUserType [id=" + id + ", type=" + type + ", code=" + code + ", forType=" + forType + ", email="
				+ email + ", contact=" + contact + ", idType=" + idType + ", ifOther=" + ifOther + ", idNum=" + idNum
				+ "]";
	}

}
