package bbs;

public class BbsDto {
	
	private int bbsNum;
	private String bbsTitle;
	private String id;
	private String bbsDate;
	private int bbsHit;
	private String bbsContent;
//	private int bbsGroup;
//	private int bbsStep;
//	private int bbsIndent;
	public BbsDto(int bbsNum, String bbsTitle, String id, String bbsDate, int bbsHit, String bbsContent) {
		this.bbsNum = bbsNum;
		this.bbsTitle = bbsTitle;
		this.id = id;
		this.bbsDate = bbsDate;
		this.bbsHit = bbsHit;
		this.bbsContent = bbsContent;
	}
	public BbsDto(int bbsNum, String bbsTitle, String id, String bbsDate, int bbsHit) {
		this.bbsNum = bbsNum;
		this.bbsTitle = bbsTitle;
		this.id = id;
		this.bbsDate = bbsDate;
		this.bbsHit = bbsHit;
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
	public int getBbsHit() {
		return bbsHit;
	}
	public void setBbsHit(int bbsHit) {
		this.bbsHit = bbsHit;
	}
	public String getBbsContent() {
		return bbsContent;
	}
	public void setBbsContent(String bbsContent) {
		this.bbsContent = bbsContent;
	}
	
}