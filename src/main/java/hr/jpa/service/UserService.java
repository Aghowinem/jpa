
package hr.jpa.service;

import hr.jpa.entity.Employee;
import hr.jpa.entity.Roles;
import hr.jpa.entity.User;
import hr.jpa.repository.UserReps;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {


    @Autowired
    private UserReps userReps;

    @Autowired
    private RolesService rolesService;

    public Optional<User> findById(int id){
        return userReps.findById(id);
    }

    public User insert(User User){
        return userReps.save(User);
    }



    public List<User> findAll() {

        return userReps.findAll();
    }

    public User update(User User){
        User currentUser = userReps.findById(User.getId()).get();
        currentUser.setUserName(User.getUserName());
        currentUser.setPassword(User.getPassword());

        return userReps.save(currentUser);
    }

    @Transactional
    public void AddRoleForAllUsers(String roleName){
        Roles roles = rolesService.findByName(roleName);

        findAll().forEach(user -> {
            user.addRoles(roles);
            userReps.save(user);
        });
    }
}