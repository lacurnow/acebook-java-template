package com.makersacademy.acebook.model;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import lombok.Data;

@Data
@Entity
@Table(name = "POSTS")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="content")
    private String content;

    @Column(name="timestamp")
    private Timestamp timestamp;
    
    @Column(name="likes")
    private Long likes;

    @Column(name="commentcount")
    private Long commentcount;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="userid")
    private User user;
    private String imagepath;

    public Post() {}

    public Post(String content, String imagepath) {
        this.content = content;
        this.imagepath = imagepath;
    }

    public String getContent() { return this.content; }
    public void setContent(String content) { this.content = content; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user;  }
    public Long getId() {return this.id; }

    public String getImagepath() { return this.imagepath; }
    public void setImagepath(String imagepath) { this.imagepath = imagepath; }

    public Timestamp getTimestamp() { return this.timestamp; }

    public void generateTimestamp() {
        long now = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(now);
        this.timestamp = timestamp;
    }

    public Long getLikes() { return this.likes; }
    public void setLikes(Long likes) { this.likes = likes; }

    public Long getCommentcount() { return this.commentcount; }
    public void setCommentcount(Long commentcount) { this.commentcount = commentcount; }

    public String formatTimestamp() {
        LocalDateTime localDateTime = this.timestamp.toLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE d MMM y, HH:mm:ss");
        String formatted = localDateTime.format(formatter);
        return formatted;
    }

}
