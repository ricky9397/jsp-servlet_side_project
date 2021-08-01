package comment;

public class CommentDto {
	private int cNum;
	private int cBbsNum;
	private String commentId;
	private String commentDate;
	private String commentContent;

	public CommentDto() {
	}

	public CommentDto(int cNum, int cBbsNum, String commentId, String commentDate, String commentContent) {
		this.cNum = cNum;
		this.cBbsNum = cBbsNum;
		this.commentId = commentId;
		this.commentDate = commentDate;
		this.commentContent = commentContent;
	}

	public int getcNum() {
		return cNum;
	}

	public void setcNum(int cNum) {
		this.cNum = cNum;
	}

	public int getcBbsNum() {
		return cBbsNum;
	}

	public void setcBbsNum(int cBbsNum) {
		this.cBbsNum = cBbsNum;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	@Override
	public String toString() {
		return "CommentDto [cNum=" + cNum + ", cBbsNum=" + cBbsNum + ", commentId=" + commentId + ", commentDate="
				+ commentDate + ", commentContent=" + commentContent + "]";
	}
	
	
}
