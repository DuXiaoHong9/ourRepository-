package struts;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.usersDao;
import dao.impl.usersDaoImpl;
import entity.users;

@SuppressWarnings("serial")
public class registerAuction extends ActionSupport implements Action {
	private users user;
	private String  message = "";
	private String repassword="";
	public void validate(){
		if(user==null||repassword==""||repassword==null){
			addFieldError("registers", getText("user.all"));
		}else{
			if(this.getUser().getName().trim().length()==0 
					|| this.getUser().getPassword().trim().length()==0 
					|| this.getUser().getTelephone().trim().length()==0 
					|| this.getUser().getUsername().trim().length()==0){
				addFieldError("all", getText("user.all"));
			}
			if(this.getUser().getPassword()!=this.getRepassword()){
				addFieldError("rpwd", getText("tetrepassword.same"));
			}
		}
	}
	@Override
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		usersDao userDao = new usersDaoImpl();
		users us = userDao.selectByName(this.getUser().getName());
		if (us != null) {
			this.setMessage("改用户名已经存在！");
			return "input";
		} else {
			int result = userDao.insert(this.getUser());
			if (result == 1) {
				session.put("loginUsers", user);
				return "success";
			} else {
				this.setMessage("注册失败！");
				return "input";
			}
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
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	

}
