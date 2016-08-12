package com.zjh.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.acsie.yixi.entity.Point;
import com.acsie.yixi.entity.Tag;


	public class PointDAO extends HibernateDaoSupport{
		
		private TagDAO tagDao;
	

	/**根据pointName查询某段时间某位号的数据值，返回list
	 * @param pointName
	 * @param startTime
	 * @param endTime
	 * @return
	 */

	@SuppressWarnings("unchecked")
	public List<Point>	selectPoint(String pointName){
		Tag tag=tagDao.getTag(pointName);
		if(tag.getFileName()==null)return null;
		List<Point>	list=null;
		try{
			int id=tag.getID();
			String tableName=tag.getFileName().replaceFirst("TV", "Point");
			String hql="from "+tableName+" p where p.ID=:id order by p.date";
			String[] names={"id"};
			Object[] values={id};
			list=this.getHibernateTemplate().findByNamedParam(hql, names, values);
		}catch(HibernateException he){
			he.printStackTrace();
		}
		return list;
	}
	
	

	
	//getters and setters 
	public TagDAO getTagDao() {
		return tagDao;
	}

	public void setTagDao(TagDAO tagDao) {
		this.tagDao = tagDao;
	}




}
