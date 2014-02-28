package hibernate;

import java.util.HashSet;
import java.util.Set;

/**
 * Shop entity. @author MyEclipse Persistence Tools
 */

public class Shop implements java.io.Serializable {

	// Fields

	private Integer shopId;
	private Seller seller;
	private String shopHomepageUrl;
	private String shopLogo;
	private String shopQrCode;
	private String shopLatestGoodsLogo;
	private String shopRecommendedGoodsLogo;
	private String shopHottestGoodsLogo;
	private String shopName;
	private String shopArea;
	private String shopAddress;
	private String shopTel;
	private String shopQq;
	private String shopIntroduction;
	private String shopHomepageAdPic;
	private String shopHomepageAdUrl;
	private String shopGoodsTypes;
	private Set goodsInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Shop() {
	}

	/** minimal constructor */
	public Shop(Integer shopId) {
		this.shopId = shopId;
	}

	/** full constructor */
	public Shop(Integer shopId, Seller seller, String shopHomepageUrl,
			String shopLogo, String shopQrCode, String shopLatestGoodsLogo,
			String shopRecommendedGoodsLogo, String shopHottestGoodsLogo,
			String shopName, String shopArea, String shopAddress,
			String shopTel, String shopQq, String shopIntroduction,
			String shopHomepageAdPic, String shopHomepageAdUrl,
			String shopGoodsTypes, Set goodsInfos) {
		this.shopId = shopId;
		this.seller = seller;
		this.shopHomepageUrl = shopHomepageUrl;
		this.shopLogo = shopLogo;
		this.shopQrCode = shopQrCode;
		this.shopLatestGoodsLogo = shopLatestGoodsLogo;
		this.shopRecommendedGoodsLogo = shopRecommendedGoodsLogo;
		this.shopHottestGoodsLogo = shopHottestGoodsLogo;
		this.shopName = shopName;
		this.shopArea = shopArea;
		this.shopAddress = shopAddress;
		this.shopTel = shopTel;
		this.shopQq = shopQq;
		this.shopIntroduction = shopIntroduction;
		this.shopHomepageAdPic = shopHomepageAdPic;
		this.shopHomepageAdUrl = shopHomepageAdUrl;
		this.shopGoodsTypes = shopGoodsTypes;
		this.goodsInfos = goodsInfos;
	}

	// Property accessors

	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Seller getSeller() {
		return this.seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public String getShopHomepageUrl() {
		return this.shopHomepageUrl;
	}

	public void setShopHomepageUrl(String shopHomepageUrl) {
		this.shopHomepageUrl = shopHomepageUrl;
	}

	public String getShopLogo() {
		return this.shopLogo;
	}

	public void setShopLogo(String shopLogo) {
		this.shopLogo = shopLogo;
	}

	public String getShopQrCode() {
		return this.shopQrCode;
	}

	public void setShopQrCode(String shopQrCode) {
		this.shopQrCode = shopQrCode;
	}

	public String getShopLatestGoodsLogo() {
		return this.shopLatestGoodsLogo;
	}

	public void setShopLatestGoodsLogo(String shopLatestGoodsLogo) {
		this.shopLatestGoodsLogo = shopLatestGoodsLogo;
	}

	public String getShopRecommendedGoodsLogo() {
		return this.shopRecommendedGoodsLogo;
	}

	public void setShopRecommendedGoodsLogo(String shopRecommendedGoodsLogo) {
		this.shopRecommendedGoodsLogo = shopRecommendedGoodsLogo;
	}

	public String getShopHottestGoodsLogo() {
		return this.shopHottestGoodsLogo;
	}

	public void setShopHottestGoodsLogo(String shopHottestGoodsLogo) {
		this.shopHottestGoodsLogo = shopHottestGoodsLogo;
	}

	public String getShopName() {
		return this.shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopArea() {
		return this.shopArea;
	}

	public void setShopArea(String shopArea) {
		this.shopArea = shopArea;
	}

	public String getShopAddress() {
		return this.shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public String getShopTel() {
		return this.shopTel;
	}

	public void setShopTel(String shopTel) {
		this.shopTel = shopTel;
	}

	public String getShopQq() {
		return this.shopQq;
	}

	public void setShopQq(String shopQq) {
		this.shopQq = shopQq;
	}

	public String getShopIntroduction() {
		return this.shopIntroduction;
	}

	public void setShopIntroduction(String shopIntroduction) {
		this.shopIntroduction = shopIntroduction;
	}

	public String getShopHomepageAdPic() {
		return this.shopHomepageAdPic;
	}

	public void setShopHomepageAdPic(String shopHomepageAdPic) {
		this.shopHomepageAdPic = shopHomepageAdPic;
	}

	public String getShopHomepageAdUrl() {
		return this.shopHomepageAdUrl;
	}

	public void setShopHomepageAdUrl(String shopHomepageAdUrl) {
		this.shopHomepageAdUrl = shopHomepageAdUrl;
	}

	public String getShopGoodsTypes() {
		return this.shopGoodsTypes;
	}

	public void setShopGoodsTypes(String shopGoodsTypes) {
		this.shopGoodsTypes = shopGoodsTypes;
	}

	public Set getGoodsInfos() {
		return this.goodsInfos;
	}

	public void setGoodsInfos(Set goodsInfos) {
		this.goodsInfos = goodsInfos;
	}

}