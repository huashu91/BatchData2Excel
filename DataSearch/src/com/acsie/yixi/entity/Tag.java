package com.acsie.yixi.entity;

import java.io.Serializable;

public class Tag implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4616081136980335128L;
	private int ID;
	private String name; //带有前缀的名字，与数据库相同
	private String tagName;//不带前缀的名字，用于前台显示
	private	 String fileName;
	
	public Tag(){
		
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		this.tagName=Name2TagName(name);
	}
	
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName =tagName;
		this.name=TagName2Name(tagName);
	}
	
	/**
	 * name属性转化pointName属性方法
	 */
	public String Name2TagName(String name){
		return name.substring(5);
	}
	
	/**
	 * pointName属性转化name属性方法
	 */
	public String TagName2Name(String tagName){
		return "ETU1_".concat(tagName);
	}
	@Override
	public String toString(){
		return "Tag [id="+ID+",name="+name+",tagName="+tagName+"]";
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	
}
