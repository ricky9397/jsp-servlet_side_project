package bbs;

public class BbsDto {
	
	private int bbsNum;
	private String bbsTitle;
	private String id;
	private String bbsDate;
	private String bbsHit;
	private String bbsContent;
	public BbsDto(int bbsNum, String bbsTitle, String id, String bbsDate, String bbsHit, String bbsContent) {
		super();
		this.bbsNum = bbsNum;
		this.bbsTitle = bbsTitle;
		this.id = id;
		this.bbsDate = bbsDate;
		this.bbsHit = bbsHit;
		this.bbsContent = bbsContent;
	}
	public int getBbsNum() {
		return bbsNum;
	}
	public void setBbsNum(int bbsNum) {
		this.bbsNum = bbsNum;
	}
	public String getBbsTitle() {
		return bbsTitle;
	}
	public void setBbsTitle(String bbsTitle) {
		this.bbsTitle = bbsTitle;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBbsDate() {
		return bbsDate;
	}
	public void setBbsDate(String bbsDate) {
		this.bbsDate = bbsDate;
	}
	public String getBbsHit() {
		return bbsHit;
	}
	public void setBbsHit(String bbsHit) {
		this.bbsHit = bbsHit;
	}
	public String getBbsContent() {
		return bbsContent;
	}
	public void setBbsContent(String bbsContent) {
		this.bbsContent = bbsContent;
	}

}
