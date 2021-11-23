package com.j2ee.tdspring.services;

import com.j2ee.tdspring.entities.Exit;
import com.j2ee.tdspring.repositories.ExitRepository;
import com.j2ee.tdspring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExitServices{
    @Autowired
    private ExitRepository exitRepository;
    @Autowired
    private UserServices userService;

    public Exit createOrUpdate(Exit user) {
        return exitRepository.save(user);
    }

    public Exit getExitById(Integer id) {
        return exitRepository.findById(id).orElse(null);
    }

    public List<Exit> getExits() {
        return exitRepository.findAll();
    }

    public void deleteExit(Integer id) {
    	exitRepository.deleteById(id);
    }

    public void addUserToOuting(Integer id, String username) {
    	Exit exit = getExitById(id);
    	exit.addParticipant(userService.getUserById(username));
        createOrUpdate(exit);
    }

    public void removeUserFromOuting(Integer id, String username) {
    	Exit exit = getExitById(id);
    	exit.removeParticipant(userService.getUserById(username));
        createOrUpdate(exit);
    }
}
