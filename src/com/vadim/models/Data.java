package com.vadim.models;


import com.vadim.utils.DataBaseManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Data {
    private HashSet<User> users = new HashSet<>();
    private HashSet<Role> roles = new HashSet<>();
    private HashSet<Lecture> lectures = new HashSet<>();
    private HashSet<Course> courses = new HashSet<>();
    private HashSet<UserLecture> userLectures = new HashSet<>();
    DataBaseManager dataBaseManager;

    public void fillFromDB(){
        dataBaseManager = new DataBaseManager();
        dataBaseManager.loadDataFromDB();
        roles = fillRoles();
        lectures = fillLectures();
        users = fillUsers();
        userLectures = fillUserLectures();
    }

    public HashSet<Role> fillRoles(){
        HashSet<Role> roles = new HashSet<>();
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

    public HashSet<Lecture> fillLectures(){
        HashSet<Lecture> lectures = new HashSet<>();
        ResultSet rsLectures= dataBaseManager.getRsLectures();
        try {
            while(rsLectures.next()){
                Lecture lecture = new Lecture();
                lecture.setId(rsLectures.getInt("lecture_id"));
                lecture.setName(rsLectures.getString("lecture_name"));
                lecture.setText(rsLectures.getBytes("lecture_text"));
                int courseId = rsLectures.getInt("course_id");
                Course course = courses.stream().filter(c->c.getId() == courseId).findFirst().get();
                lecture.setCource(course);

                lectures.add(lecture);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lectures;
    }

    public HashSet<UserLecture> fillUserLectures(){
        HashSet<UserLecture> userLectures = new HashSet<>();
        ResultSet rsUserLectures = dataBaseManager.getRsCouses();
        ResultSet rsUser = dataBaseManager.getRsUser();
        ResultSet rsLectures= dataBaseManager.getRsLectures();
        try{
            while (rsUserLectures.next()){
                UserLecture userLecture = new UserLecture();
                int userId = rsUser.getInt("user_id");
                int lectureId = rsLectures.getInt("lecture_id");
                User user = users.stream().filter(u->u.getId() == userId).findFirst().get();
                Lecture lecture = lectures.stream().filter(l->l.getId() == lectureId).findFirst().get();
                userLecture.setUser(user);
                userLecture.setLecture(lecture);

                userLectures.add(userLecture);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return  null;
    }

    public HashSet<User> fillUsers(){
        HashSet<User> users = new HashSet<>();
        ResultSet rsUser = dataBaseManager.getRsUser();
        ResultSet rsLectures= dataBaseManager.getRsLectures();
        try {
            while(rsUser.next()){
                User user = new User();
                user.setId(rsUser.getInt("user_id"));
                int roleId = rsUser.getInt("role_id");
                Role role = roles.stream().filter(r->r.getId() == roleId).findFirst().get();
                user.setRole(role);
                user.setLogin(rsUser.getString("user_login"));
                user.setPassword(rsUser.getString("user_password"));
                user.setFirstName(rsUser.getString("user_first_name"));
                user.setLastName(rsUser.getString("user_last_name"));
                /*for (var r :
                        rsUserLectures) {

                }
                Lecture lecture = lectures.stream().filter(l->l.get)*/

                //user.setLectureList(new HashSet<>());


                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}
