package com.revature.models;

/**
 * This concrete User class can include additional fields that can be used for
 * extended functionality of the ERS application.
 *
 * Example fields:
 * <ul>
 *     <li>First Name</li>
 *     <li>Last Name</li>
 *     <li>Email</li>
 *     <li>Phone Number</li>
 *     <li>Address</li>
 * </ul>
 *
 */
public class Employee extends EmployeeUser {

    public Employee() {
        super();
    }

    /**
     * This includes the minimum parameters needed for the {@link EmployeeUser} class.
     * If other fields are needed, please create additional constructors.
     */
    public Employee(int id, String firstName, String lastName, String username, String password, Role role) {
        super(id, firstName, lastName, username, password, role);
    }
}
