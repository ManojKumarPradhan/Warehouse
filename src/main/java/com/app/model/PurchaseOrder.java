package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "purchase_order_tab")
public class PurchaseOrder {

	@Id
	@GeneratedValue(generator = "purchase_order_gen")
	@GenericGenerator(name = "purchase_order_gen", strategy = "increment")
	private Integer id;

	private String code;

	@ManyToOne
	@JoinColumn(name = "ship_id_fk")
	private ShipmentType shipmentType;

	@ManyToOne
	@JoinColumn(name = "user_vender_fk")
	private WhUserType whUserType;

	@Column(name = "ref_num")
	private String refNum;

	@Column(name = "quality_ckeck")
	private String qualityCheck;

	private String status;

	private String dsc;

	public PurchaseOrder() {
		super();
	}

	public PurchaseOrder(Integer id) {
		super();
		this.id = id;
	}

	public PurchaseOrder(Integer id, String code, ShipmentType shipmentType, WhUserType whUserType, String refNum,
			String qualityCheck, String status, String dsc) {
		super();
		this.id = id;
		this.code = code;
		this.shipmentType = shipmentType;
		this.whUserType = whUserType;
		this.refNum = refNum;
		this.qualityCheck = qualityCheck;
		this.status = status;
		this.dsc = dsc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ShipmentType getShipmentType() {
		return shipmentType;
	}

	public void setShipmentType(ShipmentType shipmentType) {
		this.shipmentType = shipmentType;
	}

	public WhUserType getWhUserType() {
		return whUserType;
	}

	public void setWhUserType(WhUserType whUserType) {
		this.whUserType = whUserType;
	}

	public String getRefNum() {
		return refNum;
	}

	public void setRefNum(String refNum) {
		this.refNum = refNum;
	}

	public String getQualityCheck() {
		return qualityCheck;
	}

	public void setQualityCheck(String qualityCheck) {
		this.qualityCheck = qualityCheck;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDsc() {
		return dsc;
	}

	public void setDsc(String dsc) {
		this.dsc = dsc;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [id=" + id + ", code=" + code + ", shipmentType=" + shipmentType + ", whUserType="
				+ whUserType + ", refNum=" + refNum + ", qualityCheck=" + qualityCheck + ", status=" + status + ", dsc="
				+ dsc + "]";
	}

}
