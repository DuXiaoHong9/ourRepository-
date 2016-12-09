package struts;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class exitAuction implements Action {

	@Override
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("loginUsers");
		session.remove("uphouse");
		return "success";
	}

}
