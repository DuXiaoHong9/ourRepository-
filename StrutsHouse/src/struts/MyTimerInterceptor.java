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
		//执行Action之前的工作；获取开始执行的时间
		long starttime = System.currentTimeMillis();
		System.out.println("执行Action之前的工作，开始时间："+starttime);
		//执行后续拦截器或Action
		String result = invocation.invoke();
		//执行Action之后的工作
		long endtime = System.currentTimeMillis();
		long exectime = endtime - starttime;
		System.out.println("执行Action之后的，结束时间："+endtime);
		System.out.println("总共用时间："+exectime);
		//返回结果字符串
		return result;
	}

}
