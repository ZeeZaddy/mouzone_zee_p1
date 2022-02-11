package com.revature.repositories;

import com.revature.models.EmployeeReimbursement;
import com.revature.models.Role;
import com.revature.models.Status;
import com.revature.util.ConnectionFactory;
import com.revature.models.EmployeeUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeUserReimbursementDAO implements GenericDAO<EmployeeReimbursement> {

    ConnectionFactory cu = ConnectionFactory.getInstance();
    List<EmployeeReimbursement> eurd = new ArrayList<EmployeeReimbursement>();
    EmployeeUserDAO employeeUserDAO = new EmployeeUserDAO();

    public EmployeeReimbursement create(EmployeeReimbursement eurd) {
        String sql = "insert into reim (id, status, author, amount, description, courseType, letterGrade) values (default, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, String.valueOf(Status.PENDING));
            ps.setString(2, eurd.getAuthor().getUsername());
            ps.setInt(3, eurd.getAmount());
            ps.setString(4, eurd.getDescription());
            ps.setString(5, eurd.getCourseType());
            ps.setString(6, eurd.getLetterGrade());

            ResultSet rs = ps.executeQuery();
            return null;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public EmployeeReimbursement getById(Integer id) {
String sql = "select * from reim where id = ?";
        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                EmployeeReimbursement er = new EmployeeReimbursement(
                        rs.getInt("id"),
                        Status.valueOf(rs.getString("status")),
                        employeeUserDAO.getByUsername(rs.getString("author")),
                        employeeUserDAO.getByUsername(rs.getString("resolver")),
                        rs.getInt("amount"),
                        rs.getString("description"),
                        rs.getString("courseType"),
                        rs.getString("letterGrade")
                );

                return er;

            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }


    public List<EmployeeReimbursement> getAll () {

        List<EmployeeReimbursement> eurd = new ArrayList<>();

        String sql = "select * from reim";

        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EmployeeReimbursement er = new EmployeeReimbursement(
                        rs.getInt("id"),
                        Status.valueOf(rs.getString("status")),
                        employeeUserDAO.getByUsername(rs.getString("author")),
                        employeeUserDAO.getByUsername(rs.getString("resolver")),
                        rs.getInt("amount"),
                        rs.getString("description"),
                        rs.getString("courseType"),
                        rs.getString("letterGrade")
                );

                eurd.add(er);
            }
            return eurd;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void update(EmployeeReimbursement eurd) {

    }



    @Override
    public void delete(Integer id) {
        String sql = "delete from reim where id = ?";
        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();

    }
}



}
