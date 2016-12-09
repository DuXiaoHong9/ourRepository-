package struts;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import dao.houseDao;
import dao.impl.houseDaoImpl;
import entity.house;
import entity.users;

public class guanliAuction implements Action {
	private List<house> listUhouse;
	private String yesorno = null;
	private users userLogin;
	@Override
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		userLogin = (users) session.get("loginUsers");
		session.remove("isup");
		houseDao houseDao = new houseDaoImpl();
		users userLogin = (users) session.get("loginUsers");
		if (userLogin != null) {
			List<house> listUhouse = houseDao.selectByUId(userLogin);
			this.setListUhouse(listUhouse);
			this.setYesorno("yes");
			return "success";
		} else {
			return "input";
		}
	}
	public List<house> getListUhouse() {
		return listUhouse;
	}
	public void setListUhouse(List<house> listUhouse) {
		this.listUhouse = listUhouse;
	}
	public String getYesorno() {
		return yesorno;
	}
	public void setYesorno(String yesorno) {
		this.yesorno = yesorno;
	}
	public users getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(users userLogin) {
		this.userLogin = userLogin;
	}
	
	
}
