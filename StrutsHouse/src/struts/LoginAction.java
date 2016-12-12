package struts;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.usersDao;
import dao.impl.usersDaoImpl;

import entity.users;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport implements Action{
	private users user;
	private String  message = "";
	private users userLogin;
	public void validate(){
		if(user==null){
			addFieldError("logins", "�������¼��Ϣ��");
		}else{
			if(this.getUser().getName().trim().length()==0 
					|| this.getUser().getPassword().trim().length()==0){
				addFieldError("all", "�������¼��Ϣ��");
			}
		}
	}
	@Override
	public String execute() throws Exception {
		usersDao userBiz=new usersDaoImpl();
		this.setUserLogin(userBiz.selectByLogin(user));
		if(this.getUserLogin()==null){
			this.setMessage("�û������������");
			return "input";
		}else{
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("loginUsers", userLogin);
			return "success";
		}
	}
	public users getUser() {
		return user;
	}
	public void setUser(users user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public users getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(users userLogin) {
		this.userLogin = userLogin;
	}
	
	
}
