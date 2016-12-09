package struts;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import dao.districtDao;
import dao.streetDao;
import dao.typesDao;
import dao.impl.districtDaoImpl;
import dao.impl.streetDaoImpl;
import dao.impl.typesDaoImpl;
import entity.district;
import entity.street;
import entity.types;
import entity.users;

public class infoAuction implements Action{
	private List<types> listType;
	private List<district> listDis;
	private List<street> listStr;
	private users userLogin;
	@Override
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		userLogin = (users) session.get("loginUsers");
		if(userLogin==null){
			return "login";
		}
		typesDao typeDao = new typesDaoImpl();
		listType = typeDao.selectAll();
		districtDao disDao = new districtDaoImpl();
		listDis = disDao.selectAll();
		streetDao strDao = new streetDaoImpl();
		listStr = strDao.selectAll();
		return "success";
	}
	public List<types> getListType() {
		return listType;
	}
	public void setListType(List<types> listType) {
		this.listType = listType;
	}
	public List<district> getListDis() {
		return listDis;
	}
	public void setListDis(List<district> listDis) {
		this.listDis = listDis;
	}
	public List<street> getListStr() {
		return listStr;
	}
	public void setListStr(List<street> listStr) {
		this.listStr = listStr;
	}
	public users getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(users userLogin) {
		this.userLogin = userLogin;
	}
	
}
