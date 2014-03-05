/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feu.eac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.digest.DigestUtils;
import org.feu.eac.dto.User;

/**
 *
 * @author makki
 */
public class ServiceLogic {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";
    
//    private int account_id;
//    private String first_name;
//    private String last_name;
//    private String email;
//    private String username;
//    private String password;
    
    public User authenticate(String username, String password) {
       
        User user = new User();
        // Open a connection
        Connection conn = null;

        //Create PreparedStatement object
        PreparedStatement preparedStatement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            String sql = "SELECT * FROM test.accounts WHERE username = ? AND password = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, DigestUtils.md5Hex(password));

            // Execute SQL query
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                //valid = true;
                user.setAccount_id(rs.getInt("account_id"));
                user.setFirst_name(rs.getString("first_name"));
                user.setLast_name(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }

        } catch (SQLException se) {
            System.out.println(se.getMessage());
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceLogic.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceLogic.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return user;
    }

    public boolean checkUsername (String username) {
        boolean valid = true;
        Connection conn = null;

        //Create PreparedStatement object
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            String sql = "SELECT * FROM test.accounts WHERE username = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);

            // Execute SQL query
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                valid = false;
                System.out.println("Username exists.");
            }

        } catch (SQLException se) {
            System.out.println(se.getMessage());
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceLogic.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceLogic.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }

    public void insertInfo (String first_name, String last_name, String email, String phone, String username, String password) {
        Connection conn = null;

        //Create PreparedStatement object
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            String sql = "INSERT INTO test.accounts(first_name, last_name, email, phone, username, password) VALUES (?, ?, ?, ?, ?, ?);";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, first_name);
            preparedStatement.setString(2, last_name);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, phone);
            preparedStatement.setString(5, username);
            preparedStatement.setString(6, DigestUtils.md5Hex(password));

            // Execute SQL insert
            preparedStatement.executeUpdate();

        } catch (SQLException se) {
            System.out.println(se.getMessage());
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceLogic.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceLogic.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
