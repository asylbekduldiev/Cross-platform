package com.taske.taskDelat.model;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {

        @Id
        @GeneratedValue
        private Long id;
        @Column(unique=true)
        private String email;
        private String passwordHash;
       // private String roles; // e.g. "ROLE_USER,ROLE_ADMIN"

    public User(Long id, String email, String passwordHash) {
        this.id = id;
        this.email = email;
        this.passwordHash = passwordHash;
       // this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

   /* public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }*/
}
