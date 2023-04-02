package hr.jpa.config;

import hr.jpa.entity.Roles;
import hr.jpa.entity.User;
import hr.jpa.service.RolesService;
import hr.jpa.service.UserService;
import org.apache.catalina.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class AppStartUp implements CommandLineRunner {


    @Autowired
    private UserService userService;

    @Autowired
    private RolesService rolesService;

    @Override
    public void run(String... args) throws Exception {
        if (userService.findAll().isEmpty()) {
            Roles role1 = new Roles();
            role1.setName("Admin");

            Roles role2 = new Roles();
            role2.setName("user");

            rolesService.insert(role1);
            rolesService.insert(role2);

            Set<Roles> adminRoles = new HashSet<>();
            adminRoles.add(role1);

            Set<Roles> userRoles = new HashSet<>();
            userRoles.add(role2);

            //create user
            User user1 = new User();
            user1.setUserName("Admin user");
            user1.setPassword("1234");
            user1.setRoles(adminRoles);
            userService.insert(user1);

            User user2 = new User();
            user2.setUserName("user1");
            user2.setPassword("1234");
            user2.setRoles(userRoles);
            userService.insert(user2);
        }
    }
}