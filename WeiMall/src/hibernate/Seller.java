package hibernate;

import java.util.HashSet;
import java.util.Set;

/**
 * Seller entity. @author MyEclipse Persistence Tools
 */

public class Seller implements java.io.Serializable {

	// Fields

	private Integer sellerId;
	private String sellerName;
	private String sellerEmail;
	private String sellerPwd;
	private String sellerRealName;
	private Integer sellerSex;
	private String sellerBirthday;
	private String sellerQq;
	private String sellerPhoneNum;
	private String sellerLastLoginTime;
	private String sellerLastLoginIp;
	private Integer sellerCredit;
	private Integer sellerGoodEvaluationNum;
	private Integer sellerShopLevel;
	private String sellerValidity;
	private Integer sellerGoodsOnSell;
	private Integer sellerTotalGoodsNum;
	private Set orderForms = new HashSet(0);
	private Set shops = new HashSet(0);

	// Constructors

	/** default constructor */
	public Seller() {
	}

	/** minimal constructor */
	public Seller(Integer sellerId) {
		this.sellerId = sellerId;
	}

	/** full constructor */
	public Seller(Integer sellerId, String sellerName, String sellerEmail,
			String sellerPwd, String sellerRealName, Integer sellerSex,
			String sellerBirthday, String sellerQq, String sellerPhoneNum,
			String sellerLastLoginTime, String sellerLastLoginIp,
			Integer sellerCredit, Integer sellerGoodEvaluationNum,
			Integer sellerShopLevel, String sellerValidity,
			Integer sellerGoodsOnSell, Integer sellerTotalGoodsNum,
			Set orderForms, Set shops) {
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.sellerEmail = sellerEmail;
		this.sellerPwd = sellerPwd;
		this.sellerRealName = sellerRealName;
		this.sellerSex = sellerSex;
		this.sellerBirthday = sellerBirthday;
		this.sellerQq = sellerQq;
		this.sellerPhoneNum = sellerPhoneNum;
		this.sellerLastLoginTime = sellerLastLoginTime;
		this.sellerLastLoginIp = sellerLastLoginIp;
		this.sellerCredit = sellerCredit;
		this.sellerGoodEvaluationNum = sellerGoodEvaluationNum;
		this.sellerShopLevel = sellerShopLevel;
		this.sellerValidity = sellerValidity;
		this.sellerGoodsOnSell = sellerGoodsOnSell;
		this.sellerTotalGoodsNum = sellerTotalGoodsNum;
		this.orderForms = orderForms;
		this.shops = shops;
	}

	// Property accessors

	public Integer getSellerId() {
		return this.sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return this.sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getSellerEmail() {
		return this.sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

	public String getSellerPwd() {
		return this.sellerPwd;
	}

	public void setSellerPwd(String sellerPwd) {
		this.sellerPwd = sellerPwd;
	}

	public String getSellerRealName() {
		return this.sellerRealName;
	}

	public void setSellerRealName(String sellerRealName) {
		this.sellerRealName = sellerRealName;
	}

	public Integer getSellerSex() {
		return this.sellerSex;
	}

	public void setSellerSex(Integer sellerSex) {
		this.sellerSex = sellerSex;
	}

	public String getSellerBirthday() {
		return this.sellerBirthday;
	}

	public void setSellerBirthday(String sellerBirthday) {
		this.sellerBirthday = sellerBirthday;
	}

	public String getSellerQq() {
		return this.sellerQq;
	}

	public void setSellerQq(String sellerQq) {
		this.sellerQq = sellerQq;
	}

	public String getSellerPhoneNum() {
		return this.sellerPhoneNum;
	}

	public void setSellerPhoneNum(String sellerPhoneNum) {
		this.sellerPhoneNum = sellerPhoneNum;
	}

	public String getSellerLastLoginTime() {
		return this.sellerLastLoginTime;
	}

	public void setSellerLastLoginTime(String sellerLastLoginTime) {
		this.sellerLastLoginTime = sellerLastLoginTime;
	}

	public String getSellerLastLoginIp() {
		return this.sellerLastLoginIp;
	}

	public void setSellerLastLoginIp(String sellerLastLoginIp) {
		this.sellerLastLoginIp = sellerLastLoginIp;
	}

	public Integer getSellerCredit() {
		return this.sellerCredit;
	}

	public void setSellerCredit(Integer sellerCredit) {
		this.sellerCredit = sellerCredit;
	}

	public Integer getSellerGoodEvaluationNum() {
		return this.sellerGoodEvaluationNum;
	}

	public void setSellerGoodEvaluationNum(Integer sellerGoodEvaluationNum) {
		this.sellerGoodEvaluationNum = sellerGoodEvaluationNum;
	}

	public Integer getSellerShopLevel() {
		return this.sellerShopLevel;
	}

	public void setSellerShopLevel(Integer sellerShopLevel) {
		this.sellerShopLevel = sellerShopLevel;
	}

	public String getSellerValidity() {
		return this.sellerValidity;
	}

	public void setSellerValidity(String sellerValidity) {
		this.sellerValidity = sellerValidity;
	}

	public Integer getSellerGoodsOnSell() {
		return this.sellerGoodsOnSell;
	}

	public void setSellerGoodsOnSell(Integer sellerGoodsOnSell) {
		this.sellerGoodsOnSell = sellerGoodsOnSell;
	}

	public Integer getSellerTotalGoodsNum() {
		return this.sellerTotalGoodsNum;
	}

	public void setSellerTotalGoodsNum(Integer sellerTotalGoodsNum) {
		this.sellerTotalGoodsNum = sellerTotalGoodsNum;
	}

	public Set getOrderForms() {
		return this.orderForms;
	}

	public void setOrderForms(Set orderForms) {
		this.orderForms = orderForms;
	}

	public Set getShops() {
		return this.shops;
	}

	public void setShops(Set shops) {
		this.shops = shops;
	}

}