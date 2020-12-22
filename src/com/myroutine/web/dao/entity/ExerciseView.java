package com.myroutine.web.dao.entity;

import java.util.Date;
import java.util.List;

import com.myroutine.web.entity.admin.exercise.Exercise;

public class ExerciseView extends Exercise{
	private List<String> bodyPartIdList;
	private List<String> fileNameList;
	private String fileName;
	private String fileRoute;
	
	public ExerciseView() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExerciseView(int id, String name, String contents, Date regDate, String engName, String recommend,
			int categoryId, int memberId) {
		super(id, name, contents, regDate, engName,  recommend,categoryId, memberId);
		// TODO Auto-generated constructor stub
	}
	//getView(int id) 에서 부위, 파일이름을 List로 가져와서 jsp에서 foreach로 풀어낼때 쓰는 생성자
	public ExerciseView(int id, String name, String contents, Date regDate, String engName,String recommend, 
			int categoryId, int memberId, List<String> bodyPartIdList, List<String> fileNameList, String fileRoute) {
		super(id, name, contents,  regDate, engName, recommend,categoryId, memberId);
		this.bodyPartIdList=bodyPartIdList;
		this.fileNameList=fileNameList;
		this.fileRoute=fileRoute;
	}
	//getView(String[] bodyPart)에서 쓰는 생성자 파일이름을 리스트로 받지 않는다.
	//파일을 첫번째꺼만 받아서 이미지를 출력한다.
	public ExerciseView(int id, String name, String contents, Date regDate, String engName,String recommend, 
			int categoryId, int memberId, List<String> bodyPartIdList, String fileName, String fileRoute) {
		super(id, name, contents,  regDate, engName, recommend,categoryId, memberId);
		this.bodyPartIdList=bodyPartIdList;
		this.fileName=fileName;
		this.fileRoute=fileRoute;
	}
	
	
	public List<String> getBodyPartIdList() {
		return bodyPartIdList;
	}
	public void setBodyPartIdList(List<String> bodyPartIdList) {
		this.bodyPartIdList = bodyPartIdList;
	}
	public List<String> getFileNameList() {
		return fileNameList;
	}
	public void setFileNameList(List<String> fileNameList) {
		this.fileNameList = fileNameList;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileRoute() {
		return fileRoute;
	}
	public void setFileRoute(String fileRoute) {
		this.fileRoute = fileRoute;
	}
	@Override
	public String toString() {
		return "ExerciseView [bodyPartIdList=" + bodyPartIdList + ", fileNameList=" + fileNameList + ", fileName="
				+ fileName + ", fileRoute=" + fileRoute + "]";
	}
	
	
	
}
