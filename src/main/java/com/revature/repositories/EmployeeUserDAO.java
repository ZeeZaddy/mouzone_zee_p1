package com.revature.repositories;

import com.revature.models.EmployeeUser;
import com.revature.models.Role;
import com.revature.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeUserDAO implements GenericDAO<EmployeeUser> {
    ConnectionFactory cu = ConnectionFactory.getInstance();
    List<EmployeeUser> employeeUser = new ArrayList<EmployeeUser>();

    @Override
    public EmployeeUser create(EmployeeUser employeeUser) {
        String sql = "insert into employeeuser values (default, ?, ?, ?, ?, ?) returning *";
        try (Connection conn = cu.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, employeeUser.getFirstName());
            ps.setString(2, employeeUser.getLastName());
            ps.setString(3, employeeUser.getUsername());
            ps.setString(4, employeeUser.getPassword());
            ps.setString(5, String.valueOf(employeeUser.getRole()));

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                EmployeeUser e = new EmployeeUser(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("username"),
                        rs.getString("password"),
                        Role.valueOf(rs.getString("role").replace("_", " " ).toUpperCase())
                );
                return employeeUser;

            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public EmployeeUser getById (Integer id){
        String sql = "select * from employeeuser where id = ?";

        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                EmployeeUser e = new EmployeeUser(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("username"),
                        rs.getString("password"),
                        Role.valueOf(rs.getString("role").replace("_", " " ).toUpperCase())
                );

                return e;

            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public EmployeeUser getByUsername(String username) {
        String sql = "select * from employeeuser where username = ?";

        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();


            if (rs.next()) {
                EmployeeUser e = new EmployeeUser(
                        rs.getString("username"),
                        rs.getString("password"),
                Role.valueOf(rs.getString("role").replace(" ", "_" ).toUpperCase())
                );

                return e;
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
                 return null;
    }

    @Override
    public List<EmployeeUser> getAll () {
        List<EmployeeUser> employeeUser = new ArrayList<EmployeeUser>();
        String sql = "select * from employeeuser";

        try(Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                EmployeeUser e = new EmployeeUser(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("username"),
                        rs.getString("password"),
                        Role.valueOf(rs.getString("role").replace("_", " " ).toUpperCase())
                );
                employeeUser.add(e);
            }
            return employeeUser;
        }catch (SQLException e){
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public void update (EmployeeUser employeeUser) {
        String sql = "update users set first_name = ?, last_name = ?, username = ?, password = ? where id = ?";
        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, employeeUser.getFirstName());
            ps.setString(2, employeeUser.getLastName());
            ps.setString(3, employeeUser.getUsername());
            ps.setString(4, employeeUser.getPassword());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete (Integer id){
        String sql = "delete from employeeuser where id = ?";
        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
