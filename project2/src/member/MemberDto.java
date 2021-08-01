package member;

public class MemberDto {
	private String id;
	private String pw;
	private String name;
	private int post;
	private String address;
	private String addresss;
	private String phoneNum;
	private String email;
	public MemberDto() {
	}
	public MemberDto(String id, String pw, String name, int post, String address, String addresss, String phoneNum,
			String email) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.post = post;
		this.address = address;
		this.addresss = addresss;
		this.phoneNum = phoneNum;
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPost() {
		return post;
	}
	public void setPost(int post) {
		this.post = post;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddresss() {
		return addresss;
	}
	public void setAddresss(String addresss) {
		this.addresss = addresss;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
		
}
