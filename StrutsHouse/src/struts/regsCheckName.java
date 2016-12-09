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
		list.add("该");
		list.add("用户");
		list.add("已经");
		list.add("存在");
		List<users> listuser=new ArrayList<users>();
		users us4 = new users("该用户已经存在", "123456", "654321", "asdqwe");
		users us1 = new users("该用户", "123456", "654321", "asdqwe");
		users us2 = new users("已经存在", "123456", "123456", "qwezxc");
		usersDao userDao = new usersDaoImpl();
		users us = userDao.selectByName(this.getName());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(us!=null){
			
			//ajax1
//			response.getWriter().write("[\"该用户\",\"已经\",\"存在\"]");
			JSONArray jsonArray=JSONArray.fromObject(list);
			out.write(jsonArray.toString());
			
			//ajax2
////		response.getWriter().write("[{\"flag\":true,\"name\":\"该用户\"},{\"flag\":true,\"name\":\"已经\"},{\"flag\":true,\"name\":\"存在\"}]");
//			listuser.add(us1);
//			listuser.add(us2);
//			JSONArray jsonArray=JSONArray.fromObject(listuser);
//			out.write(jsonArray.toString());
			
			//ajax3  or  5
//			out.write("该用户已经存在");
			
			//ajax4
////		response.getWriter().write("{\"flag\":true,\"name\":\"该用户已经存在\"}");
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
