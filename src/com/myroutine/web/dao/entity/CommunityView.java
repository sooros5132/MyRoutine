package com.myroutine.web.dao.entity;

import java.util.Date;

//json에서 파일 두개만 읽어들여서 바꾸니..나오네..
//public class CommunityView extends Community{
	
public class CommunityView {

	private  int commCount;
	private int id;
	private  int writerId;
    private String writerName;
    private String title;
    private int hit;
    private Date regdate;
    private String contents;
    private int categoryId;
    private String categoryType;
    private String files;
    private String filePath;
    private String fileId;	
	
	public CommunityView() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param commCount
	 * @param id
	 * @param writerId
	 * @param writerName
	 * @param title
	 * @param hit
	 * @param regdate
	 * @param contents
	 * @param categoryId
	 * @param categoryType
	 * @param files
	 * @param filePath
	 * @param fileId
	 */
	public CommunityView(int commCount, int id, int writerId, String writerName, String title, int hit, Date regdate,
			String contents, int categoryId, String categoryType, String files, String filePath, String fileId) {
		super();
		this.commCount = commCount;
		this.id = id;
		this.writerId = writerId;
		this.writerName = writerName;
		this.title = title;
		this.hit = hit;
		this.regdate = regdate;
		this.contents = contents;
		this.categoryId = categoryId;
		this.categoryType = categoryType;
		this.files = files;
		this.filePath = filePath;
		this.fileId = fileId;
	}

	public int getCommCount() {
		return commCount;
	}

	public void setCommCount(int commCount) {
		this.commCount = commCount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWriterId() {
		return writerId;
	}

	public void setWriterId(int writerId) {
		this.writerId = writerId;
	}

	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	@Override
	public String toString() {
		return "CommunityView [commCount=" + commCount + ", id=" + id + ", writerId=" + writerId + ", writerName="
				+ writerName + ", title=" + title + ", hit=" + hit + ", regdate=" + regdate + ", contents=" + contents
				+ ", categoryId=" + categoryId + ", categoryType=" + categoryType + ", files=" + files + ", filePath="
				+ filePath + ", fileId=" + fileId + "]";
	}

}
