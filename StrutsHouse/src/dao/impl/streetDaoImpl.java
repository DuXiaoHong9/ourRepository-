package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.hibernteUtil;
import dao.streetDao;
import entity.street;

public class streetDaoImpl extends hibernteUtil implements streetDao {

	@SuppressWarnings("unused")
	@Override
	public int insert(street dis) {
		Transaction tx = null;
		Session session = null;
		try {
			//��session
			session = currentSession();
			//��������
			tx = session.beginTransaction();
			session.save(dis);	
			//�ύ����
			//tx.commit();
			return 1;
		} catch (Exception e) {
			return -1;
		}finally{
			//�ر�session
			//closeSession();
		}
	}

	@Override
	public street selectById(Short id) {
		Session session = null;
		street dis = null;
		try {
			//��session
			session = currentSession();
			Query query = session.createQuery("from street as str where str.id = ?");
			query.setShort(0, id);
			/**
			 * ͨ��    uniqueResult  ��ȡֵ
			 */
			dis =(street)query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//�ر�session
			//closeSession();
		}
		return dis;
	
		
		
//		Session session = null;
//		try {
//			//��session
//			session = currentSession();
//			street dis = (street)session.get(street.class, id);
//			return dis;
//		} catch (Exception e) {
//			return null;
//		}finally{
//			//�ر�session
//			//closeSession();
//		}
	}

	@Override
	public int deleteById(Short id) {
		Transaction tx = null;
		Session session = null;
		try {
			//��session
			session = currentSession();
			//��������
			tx = session.beginTransaction();
			street dis = (street)session.get(street.class, id);
			session.delete(dis);
			//�ύ����
			tx.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return -1;
		}finally{
			//�ر�session
			//closeSession();
		}
	}

	@Override
	public int update(street str) {
		Transaction tx = null;
		Session session = null;
		try {
			//��session
			session = currentSession();
			//��������
			tx = session.beginTransaction();
			session.merge(str);
			//�ύ����
			//tx.commit();
			return 1;
		} catch (Exception e) {
			tx.rollback();
			return -1;
		}finally{
			//�ر�session
			//closeSession();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<street> selectAll() {
		Session session = null;
		try {
			//��session
			session = currentSession();
			Query query = session.createQuery("FROM street");
			List<street> li = query.list();
			return li;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			//�ر�session
			//closeSession();
		}
	}
}
