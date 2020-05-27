package useradminservice.dao;

import useradminservice.dto.User;
import useradminservice.util.IDGenerator;

public class UserDAO {

	public User create(User user) {
		int id = IDGenerator.generateId();
		user.setId(id);
		return user;
	}

}
