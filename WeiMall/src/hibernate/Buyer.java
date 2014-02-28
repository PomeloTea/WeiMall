package hibernate;

import java.util.HashSet;
import java.util.Set;

/**
 * Buyer entity. @author MyEclipse Persistence Tools
 */

public class Buyer implements java.io.Serializable {

	// Fields

	private Integer buyerId;
	private String buyerUsername;
	private String buyerEmail;
	private String buyerPwd;
	private String buyerRealName;
	private Integer buyerSex;
	private String buyerBirthday;
	private String buyerQq;
	private String buyerPhoneNum;
	private Integer buyerCredit;
	private Set orderForms = new HashSet(0);
	private Set consigneeInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Buyer() {
	}

	/** minimal constructor */
	public Buyer(Integer buyerId) {
		this.buyerId = buyerId;
	}

	/** full constructor */
	public Buyer(Integer buyerId, String buyerUsername, String buyerEmail,
			String buyerPwd, String buyerRealName, Integer buyerSex,
			String buyerBirthday, String buyerQq, String buyerPhoneNum,
			Integer buyerCredit, Set orderForms, Set consigneeInfos) {
		this.buyerId = buyerId;
		this.buyerUsername = buyerUsername;
		this.buyerEmail = buyerEmail;
		this.buyerPwd = buyerPwd;
		this.buyerRealName = buyerRealName;
		this.buyerSex = buyerSex;
		this.buyerBirthday = buyerBirthday;
		this.buyerQq = buyerQq;
		this.buyerPhoneNum = buyerPhoneNum;
		this.buyerCredit = buyerCredit;
		this.orderForms = orderForms;
		this.consigneeInfos = consigneeInfos;
	}

	// Property accessors

	public Integer getBuyerId() {
		return this.buyerId;
	}

	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}

	public String getBuyerUsername() {
		return this.buyerUsername;
	}

	public void setBuyerUsername(String buyerUsername) {
		this.buyerUsername = buyerUsername;
	}

	public String getBuyerEmail() {
		return this.buyerEmail;
	}

	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}

	public String getBuyerPwd() {
		return this.buyerPwd;
	}

	public void setBuyerPwd(String buyerPwd) {
		this.buyerPwd = buyerPwd;
	}

	public String getBuyerRealName() {
		return this.buyerRealName;
	}

	public void setBuyerRealName(String buyerRealName) {
		this.buyerRealName = buyerRealName;
	}

	public Integer getBuyerSex() {
		return this.buyerSex;
	}

	public void setBuyerSex(Integer buyerSex) {
		this.buyerSex = buyerSex;
	}

	public String getBuyerBirthday() {
		return this.buyerBirthday;
	}

	public void setBuyerBirthday(String buyerBirthday) {
		this.buyerBirthday = buyerBirthday;
	}

	public String getBuyerQq() {
		return this.buyerQq;
	}

	public void setBuyerQq(String buyerQq) {
		this.buyerQq = buyerQq;
	}

	public String getBuyerPhoneNum() {
		return this.buyerPhoneNum;
	}

	public void setBuyerPhoneNum(String buyerPhoneNum) {
		this.buyerPhoneNum = buyerPhoneNum;
	}

	public Integer getBuyerCredit() {
		return this.buyerCredit;
	}

	public void setBuyerCredit(Integer buyerCredit) {
		this.buyerCredit = buyerCredit;
	}

	public Set getOrderForms() {
		return this.orderForms;
	}

	public void setOrderForms(Set orderForms) {
		this.orderForms = orderForms;
	}

	public Set getConsigneeInfos() {
		return this.consigneeInfos;
	}

	public void setConsigneeInfos(Set consigneeInfos) {
		this.consigneeInfos = consigneeInfos;
	}

}