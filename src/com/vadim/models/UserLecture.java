//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.04.18 at 07:30:35 PM MSK 
//


package com.vadim.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserLecture", propOrder = {
    "user",
    "lecture"
})
public class UserLecture {

    @XmlElement(required = true)
    private User user;
    @XmlElement(required = true)
    private Lecture lecture;

    /**
     * Gets the value of the user property.
     *
     * @return
     *     possible object is
     *     {@link User }
     *
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     *
     * @param value
     *     allowed object is
     *     {@link User }
     *
     */
    public void setUser(com.vadim.models.User value) {
        this.user = value;
    }

    /**
     * Gets the value of the lecture property.
     *
     * @return
     *     possible object is
     *     {@link Lecture }
     *
     */
    public Lecture getLecture() {
        return lecture;
    }

    /**
     * Sets the value of the lecture property.
     *
     * @param value
     *     allowed object is
     *     {@link Lecture }
     *     
     */
    public void setLecture(Lecture value) {
        this.lecture = value;
    }

}
