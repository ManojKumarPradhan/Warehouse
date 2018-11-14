package com.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Item {

	@Id
	@GeneratedValue(generator = "item_gen")
	@GenericGenerator(name = "item_gen", strategy = "increment")
	private Integer id;

	@Column(name = "code")
	private String itemCode;
	private Float width;
	private Float height;
	private Float length;

	@Column(name = "price")
	private Double itemCost;
	private String currency;

	@ManyToOne
	@JoinColumn(name = "uidfk")
	private Uom uom;

	@ManyToOne
	@JoinColumn(name = "om_sale_id")
	private OrderMethod saleType;

	@ManyToOne
	@JoinColumn(name = "om_purchase_id")
	private OrderMethod purchaseType;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "item_user_vendor_tab", joinColumns = @JoinColumn(name = "item_id_pk"), inverseJoinColumns = @JoinColumn(name = "whuser_vendor_id_pk"))
	@Fetch(FetchMode.SUBSELECT)
	private List<WhUserType> venderType;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "item_user_customer_tab", joinColumns = @JoinColumn(name = "item_id_pk"), inverseJoinColumns = @JoinColumn(name = "whuser_customer_id_pk"))
	@Fetch(FetchMode.SUBSELECT)
	private List<WhUserType> customerType;

	@Column(name = "item_dsc")
	private String dsc;

	public Item() {
		super();
	}

	public Item(Integer id) {
		super();
		this.id = id;
	}

	public Item(Integer id, String itemCode, Float width, Float height, Float length, Double itemCost, String currency,
			Uom uom, OrderMethod saleType, OrderMethod purchaseType, List<WhUserType> venderType,
			List<WhUserType> customerType, String dsc) {
		super();
		this.id = id;
		this.itemCode = itemCode;
		this.width = width;
		this.height = height;
		this.length = length;
		this.itemCost = itemCost;
		this.currency = currency;
		this.uom = uom;
		this.saleType = saleType;
		this.purchaseType = purchaseType;
		this.venderType = venderType;
		this.customerType = customerType;
		this.dsc = dsc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public Float getWidth() {
		return width;
	}

	public void setWidth(Float width) {
		this.width = width;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public Float getLength() {
		return length;
	}

	public void setLength(Float length) {
		this.length = length;
	}

	public Double getItemCost() {
		return itemCost;
	}

	public void setItemCost(Double itemCost) {
		this.itemCost = itemCost;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Uom getUom() {
		return uom;
	}

	public void setUom(Uom uom) {
		this.uom = uom;
	}

	public OrderMethod getSaleType() {
		return saleType;
	}

	public void setSaleType(OrderMethod saleType) {
		this.saleType = saleType;
	}

	public OrderMethod getPurchaseType() {
		return purchaseType;
	}

	public void setPurchaseType(OrderMethod purchaseType) {
		this.purchaseType = purchaseType;
	}

	public List<WhUserType> getVenderType() {
		return venderType;
	}

	public void setVenderType(List<WhUserType> venderType) {
		this.venderType = venderType;
	}

	public List<WhUserType> getCustomerType() {
		return customerType;
	}

	public void setCustomerType(List<WhUserType> customerType) {
		this.customerType = customerType;
	}

	public String getDsc() {
		return dsc;
	}

	public void setDsc(String dsc) {
		this.dsc = dsc;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", itemCode=" + itemCode + ", width=" + width + ", height=" + height + ", length="
				+ length + ", itemCost=" + itemCost + ", currency=" + currency + ", uom=" + uom + ", saleType="
				+ saleType + ", purchaseType=" + purchaseType + ", venderType=" + venderType + ", customerType="
				+ customerType + ", dsc=" + dsc + "]";
	}

}
