package org.mistah.steemgoalsetter.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mistah.steemgoalsetter.model.admin.Role;
import org.mistah.steemgoalsetter.model.admin.SystemUser;
import org.mistah.steemgoalsetter.repository.RoleRepository;
import org.mistah.steemgoalsetter.repository.UserRepository;
import org.mistah.steemgoalsetter.service.RoleProductGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    RoleProductGenerator roleProductGen;

    private static final List<String[]> USERS_LIST = new ArrayList<String[]>();
    static {
        List<String[]> systemUsers = new ArrayList<String[]>();
        //*
        systemUsers.add(new String[] {"eastmael", "East", "Mael", "1234", "ROLE_ADMIN"});
        /* */
        USERS_LIST.addAll(systemUsers);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Map<String, Object> model) {

        createRoles();
        createAdmin();
        createUsers();
        return "home";
    }

    private void createUsers() {
        for (String[] userInfo : USERS_LIST) {
            SystemUser user = userRepo.findOne(userInfo[0]);
            if (user == null) {
                List<Role> roles = new ArrayList<Role>();
                roles.add(roleRepo.findOne(userInfo[4]));
                user = new SystemUser(userInfo[0], userInfo[1], userInfo[2], userInfo[3], roles);
                userRepo.save(user);
            }
        }
    }

    private void createAdmin() {
        SystemUser admin = userRepo.findOne("admin");
        if (admin == null) {
            List<Role> adminRole = new ArrayList<Role>();
            adminRole.add(roleRepo.findOne("ROLE_ADMIN"));
            SystemUser user = new SystemUser("admin", "Admin", "Admin", "admin", adminRole);
            userRepo.save(user);
        }
    }

    private void createRoles() {
        List<Role> roles = roleRepo.findAll();
        if (roles == null || roles.isEmpty()) {
            roles.add(roleRepo.save(new Role("ROLE_ADMIN", "Admin")));
        }
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

}