package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.districtDao;
import dao.hibernteUtil;
import entity.district;

public class districtDaoImpl extends hibernteUtil implements districtDao {

	@SuppressWarnings("unused")
	@Override
	public int insert(district dis) {
		Transaction tx = null;
		Session session = null;
		try {
			//打开session
			session = currentSession();
			//开启事务
			tx = session.beginTransaction();
			session.save(dis);	
			//提交事务
			//tx.commit();
			return 1;
		} catch (Exception e) {
			return -1;
		}finally{
			//关闭session
			//closeSession();
		}
	}
	@Override
	public district selectById(Short id) {
		Session session = null;
		district dis = null;
		try {
			//打开session
			session = currentSession();
			Query query = session.createQuery("from district as dis where dis.id = ?");
			//query.setParameter(0, id);          //传递任何类型的参数
			query.setShort(0, id);
			
			//Query query = session.createQuery("from district as dis where dis.id = :id");
			//query.setShort("id", id);           //参数名称绑定
			//query.setParameter("id", id);          //传递任何类型的参数
			
			/**
			 * 通过迭代获取值
			 */
//			Iterator<district> it = query.iterate();
//			while (it.hasNext()) {
//				dis = it.next();
//			}
			
			/**
			 * 通过    uniqueResult  获取值
			 */
			dis =(district)query.uniqueResult();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭session
			//closeSession();
		}
		return dis;
	
	}
	@Override
	public int deleteById(Short id) {
		Transaction tx = null;
		Session session = null;
		try {
			//打开session
			session = currentSession();
			//开启事务
			tx = session.beginTransaction();
			district dis = (district)session.get(district.class, id);
			session.delete(dis);
			//提交事务
			//tx.commit();
			return 1;
		} catch (Exception e) {
			tx.rollback();
			return -1;
		}finally{
			//关闭session
			//closeSession();
		}
	}

	@Override
	public int update(district dis) {
		Transaction tx = null;
		Session session = null;
		try {
			//打开session
			session = currentSession();
			//开启事务
			tx = session.beginTransaction();
			session.merge(dis);
			//提交事务
			//tx.commit();
			return 1;
		} catch (Exception e) {
			tx.rollback();
			return -1;
		}finally{
			//关闭session
			//closeSession();
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<district> selectAll() {
		Session session = null;
		try {
			//打开session
			session = currentSession();
			Query query = session.createQuery("FROM district");

			List<district> li = query.list();
			return li;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			//关闭session
			//closeSession();
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<district> selectPage(int pageSize,int pageIndex) {
		Session session = null;
		try {
			//打开session
			session = currentSession();
			Query query = session.createQuery("FROM district order by id");
			//设置最大页码
			query.setMaxResults(pageSize);
			//设置 从第几条开始输出  不包括该条
			query.setFirstResult((pageIndex-1)*pageSize);
			List<district> li = query.list();
			return li;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			//关闭session
			//closeSession();
		}
	}
	
}
