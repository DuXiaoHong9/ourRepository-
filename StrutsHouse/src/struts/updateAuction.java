package struts;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import dao.districtDao;
import dao.houseDao;
import dao.streetDao;
import dao.typesDao;
import dao.impl.districtDaoImpl;
import dao.impl.houseDaoImpl;
import dao.impl.streetDaoImpl;
import dao.impl.typesDaoImpl;
import entity.district;
import entity.house;
import entity.street;
import entity.types;
import entity.users;

public class updateAuction implements Action {
	private List<types> listType;
	private List<district> listDis;
	private List<street> listStr;
	private Long houseId;
	private house hou;
	private String isup = null;
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
		houseDao houdao = new houseDaoImpl();
		this.setHou(houdao.selectById(houseId));
		session.put("uphouse", this.getHou());
		this.setIsup("yes");
		session.put("isup", this.getIsup());
		return "success";
	}

	public Long getHouseId() {
		return houseId;
	}

	public void setHouseId(Long houseId) {
		this.houseId = houseId;
	}

	public house getHou() {
		return hou;
	}

	public void setHou(house hou) {
		this.hou = hou;
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

	public String getIsup() {
		return isup;
	}

	public void setIsup(String isup) {
		this.isup = isup;
	}

	public users getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(users userLogin) {
		this.userLogin = userLogin;
	}
	
}
