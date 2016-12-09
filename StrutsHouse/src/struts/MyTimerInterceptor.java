package struts;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyTimerInterceptor extends AbstractInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//ִ��Action֮ǰ�Ĺ�������ȡ��ʼִ�е�ʱ��
		long starttime = System.currentTimeMillis();
		System.out.println("ִ��Action֮ǰ�Ĺ�������ʼʱ�䣺"+starttime);
		//ִ�к�����������Action
		String result = invocation.invoke();
		//ִ��Action֮��Ĺ���
		long endtime = System.currentTimeMillis();
		long exectime = endtime - starttime;
		System.out.println("ִ��Action֮��ģ�����ʱ�䣺"+endtime);
		System.out.println("�ܹ���ʱ�䣺"+exectime);
		//���ؽ���ַ���
		return result;
	}

}
