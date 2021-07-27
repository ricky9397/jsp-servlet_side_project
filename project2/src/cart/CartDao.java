package cart;

public class CartDao {
	
	private CartDao() {}
	static private CartDao dao = new CartDao();
	public static CartDao getInstance() {
		return dao;
	}
	
}
