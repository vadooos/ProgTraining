package com.vadim.models;

import java.util.*;

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



    private HashSet<Lecture> lectureList;

    /**
     * Gets the value of the id property.
     *
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the role property.
     *
     * @return
     *     possible object is
     *     {@link Role }
     *
     */
    public Role getRole() {
        return role;
    }

    /**
     * Sets the value of the role property.
     *
     * @param value
     *     allowed object is
     *     {@link Role }
     *
     */
    public void setRole(Role value) {
        this.role = value;
    }

    /**
     * Gets the value of the login property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the value of the login property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLogin(String value) {
        this.login = value;
    }

    /**
     * Gets the value of the password property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the firstName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    public HashSet<Lecture> getLectureList() {
        if (lectureList == null) {
            lectureList = new HashSet<Lecture>();
        }
        return lectureList;
    }

    public void setLectureList(HashSet<Lecture> lectureList) {
        this.lectureList = lectureList;
    }
}
