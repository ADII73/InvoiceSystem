package vo;

public class ProductVO {
	public ProductVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ProductVO(int id, String pname, String price, String pdescription) {
		super();
		this.id = id;
		this.pname = pname;
		this.price = price;
		this.pdescription = pdescription;
	}


	private int id;
	private String pname;
	private String price;
	private String pdescription;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getProductname() {
		return pname;
	}


	public void setProductname(String pname) {
		this.pname = pname;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getPdescription() {
		return pdescription;
	}


	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}

}
