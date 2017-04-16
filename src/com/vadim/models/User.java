package com.vadim.models;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by vadim on 16.04.2017.
 */
public class User {
    private int id;
    private Role role;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private List<Lecture> lectures = new LinkedList<>();

}
