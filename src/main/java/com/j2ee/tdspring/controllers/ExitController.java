package com.j2ee.tdspring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.j2ee.tdspring.entities.Exit;
import com.j2ee.tdspring.services.ExitServices;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class ExitController {
    @Autowired
    private ExitServices exitService;

	@Operation(summary = "Récupération d'une sortie par l'id de l'utilisateur")
    @GetMapping(path = "/exits")
    public Exit getUser(@RequestParam(value = "id") Integer id) {
        return exitService.getExitById(id);
    }
	
	@Operation(summary = "Création ou modification d'un sortie")
    @PutMapping("/exits")
    public Exit addOrUpdateUser(@RequestBody Exit exit) {
        return exitService.createOrUpdate(exit);
    }

    @GetMapping("/exits/all")
    public List<Exit> getUsers() {
        return exitService.getExits();
    }

    @DeleteMapping("/exits")
    public void deleteUser(@RequestParam(value = "id") Integer id) {
    	exitService.deleteExit(id);
    }
}
