package struts;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import dao.usersDao;
import dao.impl.usersDaoImpl;
import entity.users;

public class regsCheckName extends ActionSupport implements Action{
	private static final long serialVersionUID = 1L;
	private String name;
	@Override
	public String execute() throws Exception {
		List<String> list=new ArrayList<String>();
		list.add("��");
		list.add("�û�");
		list.add("�Ѿ�");
		list.add("����");
		List<users> listuser=new ArrayList<users>();
		users us4 = new users("���û��Ѿ�����", "123456", "654321", "asdqwe");
		users us1 = new users("���û�", "123456", "654321", "asdqwe");
		users us2 = new users("�Ѿ�����", "123456", "123456", "qwezxc");
		usersDao userDao = new usersDaoImpl();
		users us = userDao.selectByName(this.getName());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(us!=null){
			
			//ajax1
//			response.getWriter().write("[\"���û�\",\"�Ѿ�\",\"����\"]");
			JSONArray jsonArray=JSONArray.fromObject(list);
			out.write(jsonArray.toString());
			
			//ajax2
////		response.getWriter().write("[{\"flag\":true,\"name\":\"���û�\"},{\"flag\":true,\"name\":\"�Ѿ�\"},{\"flag\":true,\"name\":\"����\"}]");
//			listuser.add(us1);
//			listuser.add(us2);
//			JSONArray jsonArray=JSONArray.fromObject(listuser);
//			out.write(jsonArray.toString());
			
			//ajax3  or  5
//			out.write("���û��Ѿ�����");
			
			//ajax4
////		response.getWriter().write("{\"flag\":true,\"name\":\"���û��Ѿ�����\"}");
//			JSONObject jsonObject=JSONObject.fromObject(us4);
//			out.write(jsonObject.toString());
		}else{
			//ajax1
			List<String> lists=new ArrayList<String>();
			JSONArray jsonArray=JSONArray.fromObject(lists);
			out.write(jsonArray.toString());
			
			//ajax2
//			JSONArray jsonArray=JSONArray.fromObject(listuser);
//			out.write(jsonArray.toString());
			
			//ajax3  or  5
//			out.write("");
			
//			//ajax4
//			users us3 = new users();
//			JSONObject jsonObject=JSONObject.fromObject(us3);
//			out.write(jsonObject.toString());
			
		}
		out.flush();
		out.close();
		return null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
