package com.makersacademy.acebook.controller;
import java.security.Principal;

import com.makersacademy.acebook.model.Friend;
import com.makersacademy.acebook.model.User;
import com.makersacademy.acebook.repository.FriendsRepository;
import com.makersacademy.acebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class FriendsController {

  @Autowired 
  UserRepository userRepository;

  @Autowired
  FriendsRepository friendsRepository;

  private User getUser(Principal principal) {
    String username = principal.getName();
    User user = userRepository.findByUsername(username);
    return user;
}

  @GetMapping("/friends")
  public String index(Model model) {
    Iterable<User> users = userRepository.findAllUsers();
    Iterable<Friend> friends = friendsRepository.findAllFriends();
    model.addAttribute("users", users);
    model.addAttribute("user", new User());
    return "friends/index";
  }

  @PostMapping("/friends")
  public RedirectView create(@ModelAttribute User user, Principal principal) {
    User currentUser = getUser(principal);
    return new RedirectView("/friends");
  }
}
