package com.vadim.models;



import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by vadim on 16.04.2017.
 */
public class Lecture {

    protected int id;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    @XmlSchemaType(name = "hexBinary")
    protected byte[] text;
    @XmlElement(required = true)
    protected Course cource;

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
     * Gets the value of the name property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the text property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public byte[] getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setText(byte[] value) {
        this.text = value;
    }

    /**
     * Gets the value of the cource property.
     *
     * @return
     *     possible object is
     *     {@link Course }
     *
     */
    public Course getCource() {
        return cource;
    }

    /**
     * Sets the value of the cource property.
     *
     * @param value
     *     allowed object is
     *     {@link Course }
     *
     */
    public void setCource(Course value) {
        this.cource = value;
    }

}
