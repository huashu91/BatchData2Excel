package com.acsie.yixi.entity;

import java.io.Serializable;
import java.sql.Timestamp;




public class Point implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ID; //位号	
	private double value ; //值
	private Timestamp date;//时间
	private Tag tag;
	
	

	public Point(){
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}


	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public String toString() {
		return "Point [id=" + ID + ", clock=" + date + ", value=" + value+",	Tag:{id="+tag.getID()+",name"+tag.getName()+"}]";
	}
	
	  @Override
	    public int hashCode()
	    {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + ID;
	        result = prime * result + ((date == null) ? 0 : date.hashCode());
	        return result;
	    }
	
	  @Override
	  public boolean equals(Object obj){
		  if (this == obj)  
	            return true;  
	        if (obj == null)  
	            return false;  
	        if (getClass() != obj.getClass())  
	            return false;  
	        final Point other = (Point) obj;  
	        if (ID != other.ID)  
	            return false;  
	        if (date == null) {  
	            if (other.date != null)  
	                return false;  
	        } else if (!date.equals(other.date))  
	            return false;  
	        return true; 
	  }
}
