package com.j2ee.tdspring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.j2ee.tdspring.entities.User;
import com.j2ee.tdspring.services.UserServices;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class UserController {
	@Autowired
	private UserServices userService;

	@RequestMapping(path = "/add-test-user", method = RequestMethod.GET)
	public void addTestUser() {
		System.out.println("test add");
		User user = new User();
		user.setUsername("jptest");
		user.setFirstname("Jean Pierre");
		user.setLastname("Test");
		user.setTelephone("0610203040");
		userService.createOrUpdate(user);
	}

	@Operation(summary = "Création ou mise à jour d'un utilisateur")
	@RequestMapping(path = "/user ", method = RequestMethod.PUT)
	public User addOrUpdateUser(@RequestBody User user) {
		return userService.createOrUpdate(user);
	}

	@Operation(summary = "Récupération de tous les utilisateurs")
	@RequestMapping(path = "/users/all", method = RequestMethod.GET)
	public List<User> getUsers() {
	return userService.getAllUser();	
	}

	@Operation(summary = "Suppression d'un utilisateur à partir de son identifiant")
	@RequestMapping(path = "/user", method = RequestMethod.DELETE)
	public void deleteUser(@RequestParam(value = "id") String username) {
		userService.deleteUserByUsername(username);
	}
	
	@Operation(summary = "Récupération d'un utilisateur à partir de son id")
	@RequestMapping(path = "/user", method = RequestMethod.GET)
	public User getUser(@RequestParam(value = "id") String username) {
		return userService.getUserById(username);
	}
}
