package hibernate;

/**
 * GoodsInfo entity. @author MyEclipse Persistence Tools
 */

public class GoodsInfo implements java.io.Serializable {

	// Fields

	private Integer goodsId;
	private Shop shop;
	private String goodsName;
	private Double goodsPrice;
	private String goodsStandard1;
	private String goodsStandard2;
	private Integer goodsAmount;
	private String goodsArtNo;
	private Integer goodsOnSell;
	private String goodsPic;
	private String goodsInfo;
	private String goodsTypes;
	private String shopGoodsTypes;

	// Constructors

	/** default constructor */
	public GoodsInfo() {
	}

	/** minimal constructor */
	public GoodsInfo(Integer goodsId) {
		this.goodsId = goodsId;
	}

	/** full constructor */
	public GoodsInfo(Integer goodsId, Shop shop, String goodsName,
			Double goodsPrice, String goodsStandard1, String goodsStandard2,
			Integer goodsAmount, String goodsArtNo, Integer goodsOnSell,
			String goodsPic, String goodsInfo, String goodsTypes,
			String shopGoodsTypes) {
		this.goodsId = goodsId;
		this.shop = shop;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsStandard1 = goodsStandard1;
		this.goodsStandard2 = goodsStandard2;
		this.goodsAmount = goodsAmount;
		this.goodsArtNo = goodsArtNo;
		this.goodsOnSell = goodsOnSell;
		this.goodsPic = goodsPic;
		this.goodsInfo = goodsInfo;
		this.goodsTypes = goodsTypes;
		this.shopGoodsTypes = shopGoodsTypes;
	}

	// Property accessors

	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Shop getShop() {
		return this.shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Double getGoodsPrice() {
		return this.goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodsStandard1() {
		return this.goodsStandard1;
	}

	public void setGoodsStandard1(String goodsStandard1) {
		this.goodsStandard1 = goodsStandard1;
	}

	public String getGoodsStandard2() {
		return this.goodsStandard2;
	}

	public void setGoodsStandard2(String goodsStandard2) {
		this.goodsStandard2 = goodsStandard2;
	}

	public Integer getGoodsAmount() {
		return this.goodsAmount;
	}

	public void setGoodsAmount(Integer goodsAmount) {
		this.goodsAmount = goodsAmount;
	}

	public String getGoodsArtNo() {
		return this.goodsArtNo;
	}

	public void setGoodsArtNo(String goodsArtNo) {
		this.goodsArtNo = goodsArtNo;
	}

	public Integer getGoodsOnSell() {
		return this.goodsOnSell;
	}

	public void setGoodsOnSell(Integer goodsOnSell) {
		this.goodsOnSell = goodsOnSell;
	}

	public String getGoodsPic() {
		return this.goodsPic;
	}

	public void setGoodsPic(String goodsPic) {
		this.goodsPic = goodsPic;
	}

	public String getGoodsInfo() {
		return this.goodsInfo;
	}

	public void setGoodsInfo(String goodsInfo) {
		this.goodsInfo = goodsInfo;
	}

	public String getGoodsTypes() {
		return this.goodsTypes;
	}

	public void setGoodsTypes(String goodsTypes) {
		this.goodsTypes = goodsTypes;
	}

	public String getShopGoodsTypes() {
		return this.shopGoodsTypes;
	}

	public void setShopGoodsTypes(String shopGoodsTypes) {
		this.shopGoodsTypes = shopGoodsTypes;
	}

}