package struts;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import dao.houseDao;
import dao.streetDao;
import dao.typesDao;
import dao.impl.houseDaoImpl;
import dao.impl.streetDaoImpl;
import dao.impl.typesDaoImpl;
import entity.house;
import entity.houseTemp;
import entity.street;
import entity.types;
import entity.users;

public class listAuction implements Action{
	private List<types> listType;
	private List<street> listStr;
	private String types = "";
	private String streets = "";
	private String Price = "0-0";
	private String Floorrage = "0-0";
	private String title = null;
	private List<house> pagehouse;
	private int totalPageCount;
	private String pageIndex;
	private int pageIndexs = 1;
	private Short tid = -1;
	private Short sid = -1;
	private users users;
	private String isGo = null;
	@Override
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		users = (users)session.get("loginUsers");
		typesDao typeDao = new typesDaoImpl();
		listType = typeDao.selectAll();
		streetDao strDao = new streetDaoImpl();
		listStr = strDao.selectAll();
		try {
		    tid =  Short.parseShort(types);//类型id
			sid = Short.parseShort(streets);//街道id
		} catch (Exception e) {
		}
		
		if(title==null){
			title = "";
		}
		
		String[] price = Price.split("-");
		Double firstPrice = Double.parseDouble(price[0]);
		Double lastPrice = Double.parseDouble(price[1]);
		
		String[] floorrage = Floorrage.split("-");
		Double firstFloorrage = Double.parseDouble(floorrage[0]);
		Double lastFloorrage = Double.parseDouble(floorrage[1]);
		
		houseTemp houseTp = new houseTemp(firstPrice, lastPrice, sid, tid, firstFloorrage, lastFloorrage);
		houseTp.setTitle(title);
		if (pageIndex==null) {
			pageIndexs=1;
		}else{
			pageIndexs = Integer.parseInt(pageIndex);
		}
		houseDao houseDao = new houseDaoImpl();
		totalPageCount = houseDao.pageCount(houseTp);
		pagehouse = houseDao.selectByLike(houseTp, pageIndexs);
		isGo = "yes";
		return "success";
	}
	public List<types> getListType() {
		return listType;
	}
	public void setListType(List<types> listType) {
		this.listType = listType;
	}
	public List<street> getListStr() {
		return listStr;
	}
	public void setListStr(List<street> listStr) {
		this.listStr = listStr;
	}
	public String getTypes() {
		return types;
	}
	public void setTypes(String types) {
		this.types = types;
	}
	public String getStreets() {
		return streets;
	}
	public void setStreets(String streets) {
		this.streets = streets;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getFloorrage() {
		return Floorrage;
	}
	public void setFloorrage(String floorrage) {
		Floorrage = floorrage;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<house> getPagehouse() {
		return pagehouse;
	}
	public void setPagehouse(List<house> pagehouse) {
		this.pagehouse = pagehouse;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public String getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(String pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Short getTid() {
		return tid;
	}
	public void setTid(Short tid) {
		this.tid = tid;
	}
	public Short getSid() {
		return sid;
	}
	public void setSid(Short sid) {
		this.sid = sid;
	}
	public users getUsers() {
		return users;
	}
	public void setUsers(users users) {
		this.users = users;
	}
	public int getPageIndexs() {
		return pageIndexs;
	}
	public void setPageIndexs(int pageIndexs) {
		this.pageIndexs = pageIndexs;
	}
	public String getIsGo() {
		return isGo;
	}
	public void setIsGo(String isGo) {
		this.isGo = isGo;
	}
	
}
