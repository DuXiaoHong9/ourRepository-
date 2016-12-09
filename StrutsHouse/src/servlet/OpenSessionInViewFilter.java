package servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.hibernteUtil;

public class OpenSessionInViewFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		Session session = null;
		Transaction tx = null;
		try {
			// ���󵽴�ʱ����Session����������
			session = hibernteUtil.currentSession();
			tx = session.beginTransaction();
			// ִ����������
			chain.doFilter(request, response);
			// ������Ӧʱ���ύ����
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			// �ر�session
			hibernteUtil.closeSession();
		}}
	@Override
	public void destroy() {}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

}
