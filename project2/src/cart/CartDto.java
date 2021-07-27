package cart;

public class CartDto {
	
	private int cartNum;
	private int iCode;
	private String id;
	private int count;
	
	public CartDto() {
	}
	public CartDto(int cartNum, int iCode, String id, int count) {
		super();
		this.cartNum = cartNum;
		this.iCode = iCode;
		this.id = id;
		this.count = count;
	}
	public int getCartNum() {
		return cartNum;
	}
	public void setCartNum(int cartNum) {
		this.cartNum = cartNum;
	}
	public int getiCode() {
		return iCode;
	}
	public void setiCode(int iCode) {
		this.iCode = iCode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "CartDto [cartNum=" + cartNum + ", iCode=" + iCode + ", id=" + id + ", count=" + count + "]";
	}
	
}
