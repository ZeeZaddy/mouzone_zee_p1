package com.revature.services;

import java.util.Optional;

import com.revature.models.EmployeeUser;
import com.revature.models.Role;
import com.revature.repositories.EmployeeUserDAO;
import com.revature.models.Employee;

/**
 * The UserService should handle the processing and retrieval of Users for the ERS application.
 *
 * {@code getByUsername} is the only method required;
 * however, additional methods can be added.
 *
 * Examples:
 * <ul>
 *     <li>Create User</li>
 *     <li>Update User Information</li>
 *     <li>Get Users by ID</li>
 *     <li>Get Users by Email</li>
 *     <li>Get All Users</li>
 * </ul>
 */
public class LoginService {


	public static EmployeeUserDAO employeeUserDAO = new EmployeeUserDAO();

	public EmployeeUser login(String username, String password) {
		EmployeeUser e = employeeUserDAO.getByUsername(username);

		if (e != null) {
			System.out.println(e.getUsername());
			System.out.println(e.getPassword());

			if (username.equals(e.getUsername()) && password.equals(e.getPassword())) {
				return e;
			}
		}else {
			System.out.println("Incorrect username/password");
		}
		return null;

}

//	public EmployeeUser register(EmployeeUser userToBeRegistered) {
//		EmployeeUser employeeUser = new EmployeeUser();
//		String username = userToBeRegistered.getUsername()
//	}
}
//	public Optional<Employee> getByUsername(String username) {
//		return Optional.empty();
//	}




