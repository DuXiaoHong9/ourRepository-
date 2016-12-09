package struts;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import dao.houseDao;
import dao.impl.houseDaoImpl;
import entity.users;

public class deleteAuction implements Action {
	private Long houseId;
	@Override
	public String execute() throws Exception {
		houseDao houdao = new houseDaoImpl();
		Map<String, Object> session = ActionContext.getContext().getSession();
		users userLogin = (users)session.get("loginUsers");
		if(userLogin==null){
			return "login";
		}else{
			int result = houdao.deleteById(houseId);
			if (result > 0) {
				return "success";
			} else {
				return "input";
			}
		}
	}

	public Long getHouseId() {
		return houseId;
	}

	public void setHouseId(Long houseId) {
		this.houseId = houseId;
	}

}
