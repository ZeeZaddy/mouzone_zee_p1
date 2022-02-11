package com.revature.models;

/**
 * This concrete Reimbursement class can include additional fields that can be used for
 * extended functionality of the ERS application.
 *
 * Example fields:
 * <ul>
 *     <li>Description</li>
 *     <li>Creation Date</li>
 *     <li>Resolution Date</li>
 *     <li>Receipt Image</li>
 * </ul>
 *
 */
public class Reimbursement extends EmployeeReimbursement {

    public Reimbursement() {
        super();
    }

    /**
     * This includes the minimum parameters needed for the {@link EmployeeReimbursement} class.
     * If other fields are needed, please create additional constructors.
     */
    public Reimbursement(int id, Status status, EmployeeUser author, EmployeeUser resolver, int amount, String description, String courseType, String letterGrade) {
        super(id, status, author, resolver, amount, description, courseType, letterGrade);
    }
}
