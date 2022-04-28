package com.makersacademy.acebook.model;

import static java.lang.Boolean.TRUE;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private boolean enabled;
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Post> posts;

    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Friend> friends;

    public List<Post> getPosts() {
        return posts;
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public void addFriend(Friend friend) {
        friends.add(friend);
    }

    public User() { this.enabled = TRUE; }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.enabled = TRUE;
    }

    public User(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public String getUsername() { return this.username; }
    public String getPassword() { return this.password; }
    public Long getId() { return this.id; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
}
