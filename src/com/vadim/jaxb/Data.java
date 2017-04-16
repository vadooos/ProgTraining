package com.vadim.jaxb;

import com.vadim.utils.DataBaseManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Created by vadim on 16.04.2017.
 */
public class Data {
    private List<User> users = new LinkedList<>();
    private List<Role> roles = new LinkedList<>();
    private List<Lecture > lectures = new LinkedList<>();
    DataBaseManager dataBaseManager;

    public void fillFromDB(){
        dataBaseManager = new DataBaseManager();
        dataBaseManager.loadDataFromDB();
        roles = fillRoles();
        lectures = fillLectures();
        users = fillUsers();

    }

    public List<Role> fillRoles(){
        List<Role> roles = new LinkedList<>();
        ResultSet rsRoles = dataBaseManager.getRsRoles();
        try {
            while(rsRoles.next()){
                Role role = new Role();
                role.setId(rsRoles.getInt("role_id"));
                role.setName(rsRoles.getString("role_name"));
                roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    public List<Lecture> fillLectures(){
        List<Lecture> lectures = new LinkedList<>();
        ResultSet rsLectures= dataBaseManager.getRsLectures();
        try {
            while(rsLectures.next()){
                Lecture lecture = new Lecture();
                lecture.setId(rsLectures.getInt("lecture_id"));
                lecture.setName(rsLectures.getString("lecture_name"));
                lecture.setText(rsLectures.getBytes("lecture_text"));
                lectures.add(lecture);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lectures;
    }

    public List<User> fillUsers(){
        List<User> users = new LinkedList<>();
        ResultSet rsUser = dataBaseManager.getRsUser();
        try {
            while(rsUser.next()){
                User user = new User();
                user.setId(rsUser.getInt("user_id"));
                int roleId = rsUser.getInt("role_id");
                Role role = roles.stream().filter(r->r.id == roleId).findFirst().get();
                user.setRole(role);
                users.add(user);
                user.setLogin(rsUser.getString("user_login"));
                user.setPassword(rsUser.getString("user_password"));
                user.setFirstName(rsUser.getString("user_first_name"));
                user.setLastName(rsUser.getString("user_last_name"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}
