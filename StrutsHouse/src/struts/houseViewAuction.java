package struts;

import com.opensymphony.xwork2.Action;

import dao.houseDao;
import dao.impl.houseDaoImpl;
import entity.house;

public class houseViewAuction implements Action {
	private Long houseId;
	private house hou;
	@Override
	public String execute() throws Exception {
		houseDao houdao = new houseDaoImpl();
		house hou = houdao.selectById(houseId);
		this.setHou(hou);
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

}
