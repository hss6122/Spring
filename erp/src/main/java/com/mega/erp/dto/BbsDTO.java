package com.mega.erp.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class BbsDTO {
	int bId;
	String bName;
	String bTitle;
	String bContent;
	Date bDate;
	int bHit;
	int bGroup;
	int bStep;
	int bIndent;
	private String bFileName;
	private MultipartFile uploadFile;
	

	public String getbFileName() {
		return bFileName;
	}
	public void setbFileName(String bFileName) {
		this.bFileName = bFileName;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public Date getbDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	public int getbHit() {
		return bHit;
	}
	public void setbHit(int bHit) {
		this.bHit = bHit;
	}
	public int getbGroup() {
		return bGroup;
	}
	public void setbGroup(int bGroup) {
		this.bGroup = bGroup;
	}
	public int getbStep() {
		return bStep;
	}
	public void setbStep(int bStep) {
		this.bStep = bStep;
	}
	public int getbIndent() {
		return bIndent;
	}
	public void setbIndent(int bIndent) {
		this.bIndent = bIndent;
	}
	@Override
	public String toString() {
		return "BbsDTO [bId=" + bId + ", bName=" + bName + ", bTitle=" + bTitle + ", bContent=" + bContent + ", bDate="
				+ bDate + ", bHit=" + bHit + ", bGroup=" + bGroup + ", bStep=" + bStep + ", bIndent=" + bIndent
				+ ", bFileName=" + bFileName + ", uploadFile=" + uploadFile + "]";
	}



}
