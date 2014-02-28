package hibernate;

/**
 * OrderForm entity. @author MyEclipse Persistence Tools
 */

public class OrderForm implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private Seller seller;
	private Buyer buyer;
	private String buyerUsername;
	private String sellerUsername;
	private Integer orderState;
	private Integer consigneeInfoId;
	private Integer orderPaymentMode;
	private Double orderTotalPrice;
	private String orderTime;
	private String goodsIdList;
	private String goodsNumList;
	private String orderSaleInfo;
	private String orderGoodsStandard1;
	private String orderGoodsStandard2;

	// Constructors

	/** default constructor */
	public OrderForm() {
	}

	/** minimal constructor */
	public OrderForm(Integer orderId) {
		this.orderId = orderId;
	}

	/** full constructor */
	public OrderForm(Integer orderId, Seller seller, Buyer buyer,
			String buyerUsername, String sellerUsername, Integer orderState,
			Integer consigneeInfoId, Integer orderPaymentMode,
			Double orderTotalPrice, String orderTime, String goodsIdList,
			String goodsNumList, String orderSaleInfo,
			String orderGoodsStandard1, String orderGoodsStandard2) {
		this.orderId = orderId;
		this.seller = seller;
		this.buyer = buyer;
		this.buyerUsername = buyerUsername;
		this.sellerUsername = sellerUsername;
		this.orderState = orderState;
		this.consigneeInfoId = consigneeInfoId;
		this.orderPaymentMode = orderPaymentMode;
		this.orderTotalPrice = orderTotalPrice;
		this.orderTime = orderTime;
		this.goodsIdList = goodsIdList;
		this.goodsNumList = goodsNumList;
		this.orderSaleInfo = orderSaleInfo;
		this.orderGoodsStandard1 = orderGoodsStandard1;
		this.orderGoodsStandard2 = orderGoodsStandard2;
	}

	// Property accessors

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Seller getSeller() {
		return this.seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public Buyer getBuyer() {
		return this.buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public String getBuyerUsername() {
		return this.buyerUsername;
	}

	public void setBuyerUsername(String buyerUsername) {
		this.buyerUsername = buyerUsername;
	}

	public String getSellerUsername() {
		return this.sellerUsername;
	}

	public void setSellerUsername(String sellerUsername) {
		this.sellerUsername = sellerUsername;
	}

	public Integer getOrderState() {
		return this.orderState;
	}

	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}

	public Integer getConsigneeInfoId() {
		return this.consigneeInfoId;
	}

	public void setConsigneeInfoId(Integer consigneeInfoId) {
		this.consigneeInfoId = consigneeInfoId;
	}

	public Integer getOrderPaymentMode() {
		return this.orderPaymentMode;
	}

	public void setOrderPaymentMode(Integer orderPaymentMode) {
		this.orderPaymentMode = orderPaymentMode;
	}

	public Double getOrderTotalPrice() {
		return this.orderTotalPrice;
	}

	public void setOrderTotalPrice(Double orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}

	public String getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getGoodsIdList() {
		return this.goodsIdList;
	}

	public void setGoodsIdList(String goodsIdList) {
		this.goodsIdList = goodsIdList;
	}

	public String getGoodsNumList() {
		return this.goodsNumList;
	}

	public void setGoodsNumList(String goodsNumList) {
		this.goodsNumList = goodsNumList;
	}

	public String getOrderSaleInfo() {
		return this.orderSaleInfo;
	}

	public void setOrderSaleInfo(String orderSaleInfo) {
		this.orderSaleInfo = orderSaleInfo;
	}

	public String getOrderGoodsStandard1() {
		return this.orderGoodsStandard1;
	}

	public void setOrderGoodsStandard1(String orderGoodsStandard1) {
		this.orderGoodsStandard1 = orderGoodsStandard1;
	}

	public String getOrderGoodsStandard2() {
		return this.orderGoodsStandard2;
	}

	public void setOrderGoodsStandard2(String orderGoodsStandard2) {
		this.orderGoodsStandard2 = orderGoodsStandard2;
	}

}