package com.vadim.utils;

import com.vadim.jaxb.Lecture;
import com.vadim.jaxb.Role;
import com.vadim.jaxb.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by vadim on 15.04.2017.
 */
public class DataBaseManager {

    private final String URL = "jdbc:mysql://localhost/prog_training";
    private final String USER = "root";
    private final String PASSWORD = "1234";

    public ResultSet getRsRoles() {
        return rsRoles;
    }

    public ResultSet getRsUser() {
        return rsUser;
    }

    public ResultSet getRsLectures() {
        return rsLectures;
    }

    public ResultSet getRsUserLecture() {
        return rsUserLecture;
    }

    private ResultSet rsRoles;
    private ResultSet rsUser;
    private ResultSet rsLectures;
    private ResultSet rsUserLecture;

    private Connection connection = null;

    public DataBaseManager() {
        connection = initConnection();
    }

    public Connection initConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Драйвер подключен");
            System.out.println("Подключение к базе...");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("успешно");
        } catch (SQLException e) {
            e.printStackTrace();
        }
         catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void loadDataFromDB(){
        try {
            //Statement statement = connection.createStatement();

            rsRoles = connection.createStatement().executeQuery("SELECT * FROM role");
            rsLectures = connection.createStatement().executeQuery("SELECT * FROM lecture");
            rsUser = connection.createStatement().executeQuery("SELECT * FROM user ");
            rsUserLecture = connection.createStatement().executeQuery("select * from user_lecture");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





































    public void userIns(int roleId, String userLogin, String userPassword, String userFirstName, String userLastName){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO USER (role_id, user_login, user_password, user_first_name, user_last_name) VALUES (?, ?, ?, ?, ?)");

            preparedStatement.setInt(1, roleId);
            preparedStatement.setString(2, userLogin);
            preparedStatement.setString(3, userPassword);
            preparedStatement.setString(4, userFirstName);
            preparedStatement.setString(5, userLastName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public void lectureIns(String lectureName, byte[] lectureText){
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO lecture (lecture_name, lecture_text) VALUES (?, ?)");
            preparedStatement.setString(1, lectureName);
            preparedStatement.setBytes(2, lectureText);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public void userLectureIns(int userId, int lectureId){
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user_lecture (user_id, lecture_id) VALUES (?, ?)");
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, lectureId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ResultSet roleSel(){
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT role_id, role_name FROM role");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet userSel(){
        ResultSet resultSet = null;
        try (Statement statement = connection.createStatement()){
            resultSet = statement.executeQuery("SELECT * FROM user");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet lectureSel(){
        ResultSet resultSet = null;
        try (Statement statement = connection.createStatement()){
            resultSet = statement.executeQuery("SELECT * FROM lecture");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }



}
