package com.example.website.dto;

import org.apache.commons.lang3.builder.ToStringStyle;

public class Passenger {
    private String firstName;
    private String lastName;
    private String sex;
    private BookingRecord booking;

    public Passenger() {
    }

    public Passenger(String firstName, String lastName, String sex, BookingRecord booking) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.booking = booking;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public BookingRecord getBooking() {
        return booking;
    }

    public void setBooking(BookingRecord booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return (new org.apache.commons.lang3.builder.ReflectionToStringBuilder(this,
                ToStringStyle.MULTI_LINE_STYLE) {
            protected boolean accept(java.lang.reflect.Field f) {
                return super.accept(f)
                        && !java.util.Collection.class.isAssignableFrom(f.getType())
                        && !f.getName().startsWith("passw");
            }
        }).toString();
    }
}
