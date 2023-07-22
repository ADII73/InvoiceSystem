package vo;

public class InvoiceVO {
	private int id;
	private String invoiceDate;
	private String dueDate;
	private String invoiceNo;
	public InvoiceVO(int id, String invoiceDate, String dueDate, String invoiceNo, String invoiceStatus, String product,
			String customer, String quantity, String price, String discount, String shippingCost) {
		super();
		this.id = id;
		this.invoiceDate = invoiceDate;
		this.dueDate = dueDate;
		this.invoiceNo = invoiceNo;
		this.invoiceStatus = invoiceStatus;
		this.product = product;
		this.customer = customer;
		this.quantity = quantity;
		this.price = price;
		this.discount = discount;
		this.shippingCost = shippingCost;
	}
	public InvoiceVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String invoiceStatus;
	private String product;
	private String customer;
	private String quantity;
	private String price;
	private String discount;
	private String shippingCost;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getInvoiceStatus() {
		return invoiceStatus;
	}
	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getShippingCost() {
		return shippingCost;
	}
	public void setShippingCost(String shippingCost) {
		this.shippingCost = shippingCost;
	}

}
