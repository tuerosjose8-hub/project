package interfaces;

import models.User;

public interface UserRepository {
	
	User checkLogin(String username, String password);

}
