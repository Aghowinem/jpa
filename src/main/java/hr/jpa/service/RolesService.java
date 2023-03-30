package hr.jpa.service;

import hr.jpa.entity.Roles;
import hr.jpa.repository.RolesReps;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class RolesService {

    @Autowired
    private RolesReps rolesReps;

    public Optional<Roles> findById(int id){
        return rolesReps.findById(id);
    }

    public Roles insert(Roles Roles){
        return rolesReps.save(Roles);
    }


    public Iterable<Roles> findall(){
        return rolesReps.findAll();
    }

    public Roles update(Roles Roles){
        Roles currentRoles = rolesReps.findById(Roles.getId()).get();
        currentRoles.setName(Roles.getName());
        return rolesReps.save(currentRoles);
    }
}
