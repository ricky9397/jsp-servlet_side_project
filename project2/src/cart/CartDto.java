package cart;

public class CartDto {
	
	private int cartNum;
	private int cartCode;
	private String id;
	private int count;
	public CartDto() {
	}
	public CartDto(int cartNum, int cartCode, String id, int count) {
		super();
		this.cartNum = cartNum;
		this.cartCode = cartCode;
		this.id = id;
		this.count = count;
	}
	public int getCartNum() {
		return cartNum;
	}
	public void setCartNum(int cartNum) {
		this.cartNum = cartNum;
	}
	public int getCartCode() {
		return cartCode;
	}
	public void setCartCode(int cartCode) {
		this.cartCode = cartCode;
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
		return "CartDto [cartNum=" + cartNum + ", cartCode=" + cartCode + ", id=" + id + ", count=" + count + "]";
	}
	
	
	
}
