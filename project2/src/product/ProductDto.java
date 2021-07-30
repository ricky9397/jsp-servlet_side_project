package product;

public class ProductDto {
	private int iCode;
	private String iName;
	private int iPrice;
	private int count;
	private String iPhoto;
	private String content1;
	private String content2;
	private String content3;
	public ProductDto() {
	}
	public ProductDto(int iCode, String iName, int iPrice, int count, String iPhoto, String content1, String content2,
			String content3) {
		this.iCode = iCode;
		this.iName = iName;
		this.iPrice = iPrice;
		this.count = count;
		this.iPhoto = iPhoto;
		this.content1 = content1;
		this.content2 = content2;
		this.content3 = content3;
	}
	public int getiCode() {
		return iCode;
	}
	public void setiCode(int iCode) {
		this.iCode = iCode;
	}
	public String getiName() {
		return iName;
	}
	public void setiName(String iName) {
		this.iName = iName;
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
	public String getiPhoto() {
		return iPhoto;
	}
	public void setiPhoto(String iPhoto) {
		this.iPhoto = iPhoto;
	}
	public String getContent1() {
		return content1;
	}
	public void setContent1(String content1) {
		this.content1 = content1;
	}
	public String getContent2() {
		return content2;
	}
	public void setContent2(String content2) {
		this.content2 = content2;
	}
	public String getContent3() {
		return content3;
	}
	public void setContent3(String content3) {
		this.content3 = content3;
	}
	@Override
	public String toString() {
		return "ProductDto [iCode=" + iCode + ", iName=" + iName + ", iPrice=" + iPrice + ", count=" + count
				+ ", iPhoto=" + iPhoto + ", content1=" + content1 + ", content2=" + content2 + ", content3=" + content3
				+ "]";
	}
	
}
