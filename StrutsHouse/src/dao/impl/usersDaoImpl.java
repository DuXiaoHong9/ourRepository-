package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.hibernteUtil;
import dao.usersDao;
import entity.users;

public class usersDaoImpl extends hibernteUtil implements usersDao {

	@SuppressWarnings("unused")
	@Override
	public int insert(users user) {
		Transaction tx = null;
		Session session = null;
		try {
			//锟斤拷session
			session = currentSession();
			//锟斤拷锟斤拷锟斤拷锟斤拷
			tx = session.beginTransaction();
			session.save(user);	
			//锟结交锟斤拷锟斤拷
//			tx.commit();
			return 1;
		} catch (Exception e) {
			return -1;
		}finally{
			//锟截憋拷session
			//closeSession();
		}
	}

	@Override
	public users selectById(Short id) {
		Session session = null;
		users dis = null;
		try {
			//锟斤拷session
			session = currentSession();
			Query query = session.createQuery("from users as user where user.id = ?");
			query.setShort(0, id);
			/**
			 * 通锟斤拷    uniqueResult  锟斤拷取值
			 */
			dis =(users)query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//锟截憋拷session
			//closeSession();
		}
		return dis;
	}

	@Override
	public int deleteById(Short id) {
		Transaction tx = null;
		Session session = null;
		try {
			//锟斤拷session
			session = currentSession();
			//锟斤拷锟斤拷锟斤拷锟斤拷
			tx = session.beginTransaction();
			users dis = (users)session.get(users.class, id);
			session.delete(dis);
			//锟结交锟斤拷锟斤拷
			//tx.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return -1;
		}finally{
			//锟截憋拷session
			//closeSession();
		}
	}

	@Override
	public int update(users user) {
		Transaction tx = null;
		Session session = null;
		try {
			//锟斤拷session
			session = currentSession();
			//锟斤拷锟斤拷锟斤拷锟斤拷
			tx = session.beginTransaction();
			session.merge(user);
			//锟结交锟斤拷锟斤拷
			//tx.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return -1;
		}finally{
			//锟截憋拷session
			//closeSession();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<users> selectAll() {
		Session session = null;
		try {
			//锟斤拷session
			session = currentSession();
			Query query = session.createQuery("FROM users");
			List<users> li = query.list();
			return li;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			//锟截憋拷session
			//closeSession();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<users> selectPage(int pageSize, int pageIndex) {
		Session session = null;
		try {
			//锟斤拷session
			session = currentSession();
			Query query = session.createQuery("FROM district order by id");
			//锟斤拷锟斤拷锟斤拷锟揭筹拷锟�
			query.setMaxResults(pageSize);
			//锟斤拷锟斤拷 锟接第硷拷锟斤拷锟斤拷始锟斤拷锟� 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
			query.setFirstResult((pageIndex-1)*pageSize);
			List<users> li = query.list();
			return li;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			//锟截憋拷session
			//closeSession();
		}
	}

	@Override
	public users selectByLogin(users user) {
		Session session = null;
		users dis = null;
		try {
			//锟斤拷session
			session = currentSession();
			Query query = session.getNamedQuery("HQLUserLogin");
			query.setString(0, user.getName());
			query.setString(1, user.getPassword());
			/**
			 * 通锟斤拷    uniqueResult  锟斤拷取值
			 */
			dis =(users)query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//锟截憋拷session
//			closeSession();
		}
		return dis;
	}

	@Override
	public users selectByName(String name) {
		Session session = null;
		users dis = null;
		try {
			//锟斤拷session
			session = currentSession();
			Query query = session.createQuery("from users as user where user.name = ?");
			query.setParameter(0, name);
			/**
			 * 通锟斤拷    uniqueResult  锟斤拷取值
			 */
			dis =(users)query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//锟截憋拷session
			//closeSession();
		}
		return dis;
	}

}
