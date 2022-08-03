import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="user")
public class UserBean {
	
	private String login;
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	
	public String checkLogin() {
		
		UserBean user1= new UserBean();
		UserBean user2 = new UserBean();
		UserBean user3 = new UserBean();
		
		user1.setLogin("Damian");
		user2.setLogin("qwerty");
		user3.setLogin("RoyalBlood");
		
		List<UserBean> userList = Arrays.asList(user1, user2, user3);
		for(UserBean user: userList) {
			
			
			
			if(this.login.equals(user.getLogin())) {
				return "myresponse.xhtml";
			}
		}
		return "wrong-login";	
	}
		
}

