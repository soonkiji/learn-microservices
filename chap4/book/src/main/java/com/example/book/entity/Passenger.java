package com.example.book.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Passenger {
    @Id
    @GeneratedValue
    Long id;

    String firstName;

    String lastName;

    String gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOOKING_ID")
    @JsonIgnore // avoid infinite loop when serializing.
    BookingRecord bookingRecord;

    public Passenger() {
    }

    public Passenger(String firstName, String lastName, String gender, BookingRecord booking) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.bookingRecord = booking;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public BookingRecord getBookingRecord() {
        return bookingRecord;
    }

    public void setBookingRecord(BookingRecord bookingRecord) {
        this.bookingRecord = bookingRecord;
    }

    @Override
    public boolean equals(Object obj) {
        return org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return (new org.apache.commons.lang3.builder.ReflectionToStringBuilder(this,
                org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE) {
            protected boolean accept(java.lang.reflect.Field f) {
                return super.accept(f)
                        && !java.util.Collection.class.isAssignableFrom(f.getType())
                        && !f.getName().startsWith("passw");
            }
        }).toString();
    }
}
