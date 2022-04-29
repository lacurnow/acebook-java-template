package com.makersacademy.acebook.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="FRIENDS")
public class Friend {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="friend_id")
  private Long friendId;

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="userid")
  private User user;

  public Friend(){}

  public Friend(User friend) {
    this.friendId = friend.getId();
  }

  public User getUser() { return user; }
  public void setUser(User user) { this.user = user;  }

}
