package com.j2ee.tdspring.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="sortie")
public class Exit {

    @Id
    @Column(name="id", unique=true, nullable=false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int id;

    @Column(name="name", length=30, nullable=false)
    private String name;

    @Column(name="description", length=30, nullable=false)
    private String description;
    
    
    @Column(name="exitDate", nullable=false)
    private Date exitDate;
    
    @Column(name="duration", nullable=false)
    private int duration;
    
    @Column(name="complexity", nullable=false)
    private int complexity;
    
    
    @Column(name="location", length=30, nullable=false)
    private String location;
    
    @Column(name="participate", nullable=false)
    private int participate;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getExitDate() {
        return exitDate;
    }

    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getComplexity() {
        return complexity;
    }

    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getParticipate() {
        return participate;
    }

    public void setParticipate(int participate) {
        this.participate = participate;
    }

    
    
    @Column
    @ManyToMany
    @JsonIgnore
    @JoinTable(name= "outing_users", joinColumns= @JoinColumn(name = "exit_identifier"), inverseJoinColumns= @JoinColumn(name = "username"))
    List<User> participants;

    public void addParticipant(User user) {
        participants.add(user);
    }

    public void removeParticipant(User user) {
        participants.remove(user);
    }
}