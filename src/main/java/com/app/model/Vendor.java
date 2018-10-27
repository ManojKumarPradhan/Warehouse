package com.app.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "vendortab")
public class Vendor {

	@Id
	@GeneratedValue
	@Column(name = "vid")
	private Integer id;

	@Column(name = "vname")
	private String venName;

	@Column(name = "code")
	private String venCode;

	@Column(name = "ven_desg")
	private String venDesg;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "ven_preserv", joinColumns = @JoinColumn(name = "vid"))
	@OrderColumn(name = "pos")
	@Column(name = "ven_preserv")
	private List<String> venPreserve;

	public Vendor() {
		super();
	}

	public Vendor(Integer id) {
		super();
		this.id = id;
	}

	public Vendor(Integer id, String venName, String venCode, String venDesg, List<String> venPreserve) {
		super();
		this.id = id;
		this.venName = venName;
		this.venCode = venCode;
		this.venDesg = venDesg;
		this.venPreserve = venPreserve;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVenName() {
		return venName;
	}

	public void setVenName(String venName) {
		this.venName = venName;
	}

	public String getVenCode() {
		return venCode;
	}

	public void setVenCode(String venCode) {
		this.venCode = venCode;
	}

	public String getVenDesg() {
		return venDesg;
	}

	public void setVenDesg(String venDesg) {
		this.venDesg = venDesg;
	}

	public List<String> getVenPreserve() {
		return venPreserve;
	}

	public void setVenPreserve(List<String> venPreserve) {
		this.venPreserve = venPreserve;
	}

	@Override
	public String toString() {
		return "Vendor [id=" + id + ", venName=" + venName + ", venCode=" + venCode + ", venDesg=" + venDesg
				+ ", venPreserve=" + venPreserve + "]";
	}

}
