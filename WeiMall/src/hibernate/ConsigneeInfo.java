package hibernate;

/**
 * ConsigneeInfo entity. @author MyEclipse Persistence Tools
 */

public class ConsigneeInfo implements java.io.Serializable {

	// Fields

	private Integer consigneeId;
	private Buyer buyer;
	private String consigneeInfoName;
	private String consigneePhone;
	private String consigneeAddress;

	// Constructors

	/** default constructor */
	public ConsigneeInfo() {
	}

	/** minimal constructor */
	public ConsigneeInfo(Integer consigneeId) {
		this.consigneeId = consigneeId;
	}

	/** full constructor */
	public ConsigneeInfo(Integer consigneeId, Buyer buyer,
			String consigneeInfoName, String consigneePhone,
			String consigneeAddress) {
		this.consigneeId = consigneeId;
		this.buyer = buyer;
		this.consigneeInfoName = consigneeInfoName;
		this.consigneePhone = consigneePhone;
		this.consigneeAddress = consigneeAddress;
	}

	// Property accessors

	public Integer getConsigneeId() {
		return this.consigneeId;
	}

	public void setConsigneeId(Integer consigneeId) {
		this.consigneeId = consigneeId;
	}

	public Buyer getBuyer() {
		return this.buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public String getConsigneeInfoName() {
		return this.consigneeInfoName;
	}

	public void setConsigneeInfoName(String consigneeInfoName) {
		this.consigneeInfoName = consigneeInfoName;
	}

	public String getConsigneePhone() {
		return this.consigneePhone;
	}

	public void setConsigneePhone(String consigneePhone) {
		this.consigneePhone = consigneePhone;
	}

	public String getConsigneeAddress() {
		return this.consigneeAddress;
	}

	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}

}