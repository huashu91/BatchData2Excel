package com.zjh.dao;

import java.util.List;

import org.hibernate.HibernateException;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.acsie.yixi.entity.Tag;

public class TagDAO extends HibernateDaoSupport {
	
	/**通过变量名查询Tag
	 * @param tagName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Tag getTag(String tagName){
		Tag	tag=new Tag();
		tag.setTagName(tagName);
		try{
			String hql="from Tag t where t.name=:name";
			List<Tag> list=this.getHibernateTemplate().findByNamedParam(hql,"name", tag.getName());
			if(!list.isEmpty())
			tag=list.get(0);
		}catch(HibernateException he){
			he.printStackTrace();
		}
		return tag;
	}


	/**通过一组变量名查询Tag
	 * @param pointNames 要查询的一组变量名
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Tag> getSomeTag(String[] pointNames){
		Tag	tag=new Tag();
		List<Tag> list=null;
		String[] names=new String[pointNames.length];
		for(int i=0;i<pointNames.length;i++){
			names[i]=tag.TagName2Name(pointNames[i]);
		}
		try{
			String hql="from Tag	t where t.name in (:name)";
			Object name=names;
			String key="name";
			list=this.getHibernateTemplate().findByNamedParam(hql,key, name);
		}catch(HibernateException he){
			he.printStackTrace();
		}finally{
		}
		return list;
	}
}
