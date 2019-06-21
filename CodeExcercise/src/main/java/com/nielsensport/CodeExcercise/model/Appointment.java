package com.nielsensport.CodeExcercise.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Class Appointment
 */
@Entity
@Table(name = "appointments")
public class Appointment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "place")
    public String place;
    @org.hibernate.annotations.ColumnDefault("0")
    public BigDecimal price;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;
    @Temporal(value = TemporalType.TIME)
    private Date time;
    @org.hibernate.annotations.ColumnDefault("0")
    private Boolean status;

    /**
     * Base constructor of the class Appointment
     * Initializes the class attributes with default values.
     */
    public Appointment() {
        id = 0L;
        date = new Date ();
        time = new Date ();
        place = "";
        price = BigDecimal.ZERO;
        status = false;
    }

    /**
     * Constructor of the class Appointment
     *  Full initialization of class attributes with the constructor parameters
     * @param id
     * @param date
     * @param time
     * @param place
     * @param price
     * @param status
     */
    public Appointment(Long id, Date date, Date time, String place, BigDecimal price, Boolean status) {
        this ();
        this.id = id;
        this.date = date;
        this.time = time;
        this.place = place;
        this.price = price;
        this.status = status;
    }

    /**
     *  Getter for the id
     * @return Long
     */
    public Long getId() {
        return id;
    }

    /**
     *  Setter for the id
     * @param id Long
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *  Getter for the date attribute
     * @return java.util.Date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Setter for the date attribute
     * @param date
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public void setDate(Date date) {
        this.date = date;
    }



    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * Getter for the time attribute
     * @return java.util.Date
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    public Date getTime() {
        return time;
    }

    /**
     *  Setter for the place attribute
     * @param place java.lang.String
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * Getter for the place attribute
     * @return
     */
    public String getPlace() {
        return place;
    }

    /**
     * Setter for the price attribute
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Getter for the price attribute
     * @return java.math.BigDecimal
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Setter for the status attribute
     * @param status Boolean
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }


    /**
     * Getter for the status attribute
     * @return
     */

    public Boolean getStatus() {
        return status;
    }

    /**
     *  (non-JDK) toString
     * @return String
     */
    @Override
    public String toString() {
        return this.getId () + " | " + this.getDate () + " | " + this.getTime () + " | " + this.getPlace ()
                + " | "+this.getPrice () + " | " + this.getStatus ();
    }
}
