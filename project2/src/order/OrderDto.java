package order;

public class OrderDto {
	private int oidx;
	private int icode;
	private String id;
	private String oname;
	private int oprice;
	private String ophoto;
	private String odate;
	private int count;

	public OrderDto() {
	}

	public OrderDto(int oidx, int icode, String id, String oname, int oprice, String ophoto, String odate, int count) {
		this.oidx = oidx;
		this.icode = icode;
		this.id = id;
		this.oname = oname;
		this.oprice = oprice;
		this.ophoto = ophoto;
		this.odate = odate;
		this.count = count;
	}

	public int getOidx() {
		return oidx;
	}

	public void setOidx(int oidx) {
		this.oidx = oidx;
	}

	public int getIcode() {
		return icode;
	}

	public void setIcode(int icode) {
		this.icode = icode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOname() {
		return oname;
	}

	public void setOname(String oname) {
		this.oname = oname;
	}

	public int getOprice() {
		return oprice;
	}

	public void setOprice(int oprice) {
		this.oprice = oprice;
	}

	public String getOphoto() {
		return ophoto;
	}

	public void setOphoto(String ophoto) {
		this.ophoto = ophoto;
	}

	public String getOdate() {
		return odate;
	}

	public void setOdate(String odate) {
		this.odate = odate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	// 가격 함수
	public int getSumPrice() {
		return this.oprice * this.count;
	}

	@Override
	public String toString() {
		return "orderDto [oidx=" + oidx + ", icode=" + icode + ", id=" + id + ", oname=" + oname + ", oprice=" + oprice
				+ ", ophoto=" + ophoto + ", odate=" + odate + ", count=" + count + "]";
	}

}
