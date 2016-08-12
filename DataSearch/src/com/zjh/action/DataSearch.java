package com.zjh.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.acsie.yixi.entity.Point;
import com.opensymphony.xwork2.ActionSupport;
import com.zjh.dao.PointDAO;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


public class DataSearch extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9144179470850301049L;
	
	private String need;
	private PointDAO dao;
	
	public String search(){
		//1.处理请求字符串，返回名字数组
		String[]	nameArray=stringProcess(need);
		
		for(String s:nameArray){	
			if(!s.isEmpty()){
				//2.查询字符串对应数据，返回LIST
				List<Point> list=dao.selectPoint(s);
				//3.将查询的数据按照名字保存在相应的excel表中
				if(list!=null&&!list.isEmpty())writeToExcel(s,list);
				else System.out.println("未成功导出"+s);
			}		
		}
		return SUCCESS;
	}
	
	
	/**将结果写入Excel中
	 * @param s 要写的位号
	 * @param list 查询结果
	 */
	public void writeToExcel(String s,List<Point> list){
		String fname = "D:/"+ s+".xls";
	    try {
			WritableWorkbook wwb=Workbook.createWorkbook(new File(fname));
			WritableSheet ws=wwb.createSheet("sheet1", 0);
			Label firstline=new Label(0,0,"变量名");
			Label secondline=new Label(1,0,"时间");
			Label thirdline=new Label(2,0,"值");
			ws.addCell(firstline);
			ws.addCell(secondline);
			ws.addCell(thirdline);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			int i=0;
			for(Point p:list){
				++i;
				Label first=new Label(0,i,s);
				Label second=new Label(1,i,df.format(p.getDate()));
				Label third=new Label(2,i,String.valueOf(p.getValue()));
				ws.addCell(first);
				ws.addCell(second);
				ws.addCell(third);
			}
			wwb.write();
	        wwb.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("未成功导出"+s);
		}
	}
	
	
	

	/**将字符串处理成查询点位的变量名
	 * @param request 请求字符串
	 * @return 变量名数组
	 */
	public String[]	stringProcess(String request){
		String[] res=request.split(";");
		return res;
	}

	
	//getters and setters 

	public String getNeed() {
		return need;
	}


	public void setNeed(String need) {
		this.need = need;
	}

	@JSON(serialize=false)
	public PointDAO getDao() {
		return dao;
	}


	public void setDao(PointDAO dao) {
		this.dao = dao;
	}

}
