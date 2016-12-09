package dao.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import dao.hibernteUtil;
import dao.houseDao;
import entity.house;
import entity.houseTemp;
import entity.users;

public class houseDaoImpl extends hibernteUtil implements houseDao{

	@SuppressWarnings("unused")
	@Override
	public int insert(house dis) {
		Transaction tx = null;
		Session session = null;
		try {
			//打开session
			session = currentSession();
			//开启事务
			tx = session.beginTransaction();
			session.save(dis);	
			//提交事务
//			tx.commit();
			return 1;
		} catch (Exception e) {
			return -1;
		}finally{
			//关闭session
			//closeSession();
		}
	}

	@Override
	public house selectById(Long id) {
		Session session = null;
		house dis = null;
		try {
			//打开session
			session = currentSession();
			Query query = session.createQuery("from house as hos where hos.id = ?");
			query.setLong(0, id);
			/**
			 * 通过    uniqueResult  获取值
			 */
			dis =(house)query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭session
			//closeSession();
		}
		return dis;
	}

	@Override
	public int deleteById(Long id) {
		Transaction tx = null;
		Session session = null;
		try {
			//打开session
			session = currentSession();
			//开启事务
			tx = session.beginTransaction();
			house dis = (house)session.get(house.class, id);
			session.delete(dis);
			//提交事务
			////////tx.commit();
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
	public int update(house hous) {
		Transaction tx = null;
		Session session = null;
		try {
			//打开session
			session = currentSession();
			//开启事务
			tx = session.beginTransaction();
			session.merge(hous);
			//提交事务
			//////tx.commit();
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
	public List<house> selectAll() {
		Session session = null;
		try {
			//打开session
			session = currentSession();
			Query query = session.createQuery("FROM house");
			List<house> li = query.list();
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
	public List<house> selectMonth() {
		Session session = null;
		try {
			//打开session
			session = currentSession();
			Query query = session.createQuery("FROM house where pubdate between :startDate and sysdate");
			/**
			 * 日期处理
			 */
			Date date = new Date();
			Calendar calender = Calendar.getInstance();
			calender.setTime(date);
			calender.add(Calendar.MONTH, -1);
			date = calender.getTime();
			//赋值
			query.setDate(0, date);
			List<house> li = query.list();
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
	public List<house> selectByUId(users userss) {
		Session session = null;
		try {
			//打开session
			session = currentSession();
			Query query = session.createQuery("FROM house where users.id = ? order by pubdate desc");
			query.setShort(0, userss.getId());
			List<house> li = query.list();
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
	public List<house> selectByLike(houseTemp houses,int pageIndex) {
		Session session = null;
		try {
			//打开session
			session = currentSession();
			Criteria criteria = session.createCriteria(house.class,"h");
			if (houses.getFirstPrice() > 0) {
				criteria.add(Restrictions.gt("h.price", houses.getFirstPrice()));
			}
			if(houses.getLastPrice() > 0){
				criteria.add(Restrictions.lt("h.price", houses.getLastPrice()));
			}
			if (houses.getFirstFloorrage() > 0) {
				criteria.add(Restrictions.gt("h.floorrage", houses.getFirstFloorrage()));
			}
			if(houses.getLastFloorrage() > 0){
				criteria.add(Restrictions.lt("h.floorrage", houses.getLastFloorrage()));
			}
			if(houses.getTitle() != null){
				criteria.add(Restrictions.ilike("title", houses.getTitle(), MatchMode.ANYWHERE));
			}
			if (houses.getStreets() != -1) {
				criteria.createCriteria("street","s");
				criteria.add(Restrictions.eq("s.id", houses.getStreets()));
			}
			if (houses.getTypes() != -1) {
				criteria.createCriteria("types","t");
				criteria.add(Restrictions.eq("t.id", houses.getTypes()));
			}
			criteria.addOrder(Order.desc("pubdate"))
			.setFirstResult((pageIndex-1)*4)
			.setMaxResults(4);
			List<house> list = criteria.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			//关闭session
			//closeSession();
		}
	}

	@Override
	public int pageCount(houseTemp houses) {
		Session session = null;
		try {
			//打开session
			session = currentSession();
			Criteria criteria = session.createCriteria(house.class,"h");
			if (houses.getFirstPrice() > 0) {
				criteria.add(Restrictions.gt("h.price", houses.getFirstPrice()));
			}
			if(houses.getLastPrice() > 0){
				criteria.add(Restrictions.lt("h.price", houses.getLastPrice()));
			}
			if (houses.getFirstFloorrage() > 0) {
				criteria.add(Restrictions.gt("h.floorrage", houses.getFirstFloorrage()));
			}
			if(houses.getLastFloorrage() > 0){
				criteria.add(Restrictions.lt("h.floorrage", houses.getLastFloorrage()));
			}
			if(houses.getTitle() != null){
				criteria.add(Restrictions.ilike("title", houses.getTitle(), MatchMode.ANYWHERE));
			}
			if (houses.getStreets() != -1) {
				criteria.createCriteria("street","s");
				criteria.add(Restrictions.eq("s.id", houses.getStreets()));
			}
			if (houses.getTypes() != -1) {
				criteria.createCriteria("types","t");
				criteria.add(Restrictions.eq("t.id", houses.getTypes()));
			}
			criteria.setProjection(Projections.count("id"));
			Integer count = (Integer)criteria.uniqueResult();
			int pageCount = (count%4==0)?(count/4):(count/4 +1);
			return pageCount;
		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}finally{
			//关闭session
			//closeSession();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<house> selectPage(int pageSize, int pageIndex) {
		Session session = null;
		try {
			//打开session
			session = currentSession();
			Query query = session.createQuery("FROM house order by id");
			//设置最大页码
			query.setMaxResults(pageSize);
			//设置 从第几条开始输出  不包括该条
			query.setFirstResult((pageIndex-1)*pageSize);
			List<house> li = query.list();
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
