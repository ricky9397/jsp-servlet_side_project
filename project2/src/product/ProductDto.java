package product;

public class ProductDto {
	private int iCode;
	private String iname;
	private int iPrice;
	private int count;
	public ProductDto() {
	}
	public ProductDto(int iCode, String iname, int iPrice, int count) {
		this.iCode = iCode;
		this.iname = iname;
		this.iPrice = iPrice;
		this.count = count;
	}
	public int getiCode() {
		return iCode;
	}
	public void setiCode(int iCode) {
		this.iCode = iCode;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public int getiPrice() {
		return iPrice;
	}
	public void setiPrice(int iPrice) {
		this.iPrice = iPrice;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
