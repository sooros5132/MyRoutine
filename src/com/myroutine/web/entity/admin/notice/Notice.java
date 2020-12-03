package com.myroutine.web.entity.admin.notice;

import java.util.Date;

public class Notice {
	   private int id;
	   private String title;
	   private String content;
	   private Date regdate;
	   private String files;
	   private String open;
	   private String hits;
	   private String writerId;
	   
	   public Notice() {
		// TODO Auto-generated constructor stub
	}

	public Notice(int id, String title, String content, Date regdate, String files, String open, String hits,
			String writer_id) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.files = files;
		this.open = open;
		this.hits = hits;
		this.writerId = writer_id;
	}

	public Notice(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getHits() {
		return hits;
	}

	public void setHits(String hits) {
		this.hits = hits;
	}

	public String getWriter_id() {
		return writerId;
	}

	public void setWriter_id(String writer_id) {
		this.writerId = writer_id;
	}

	@Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", content=" + content + ", regdate=" + regdate + ", files="
				+ files + ", open=" + open + ", hits=" + hits + ", writer_id=" + writerId + "]";
	}
	   
	   
}
