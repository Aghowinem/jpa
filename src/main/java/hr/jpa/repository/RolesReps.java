package hr.jpa.repository;

import hr.jpa.entity.Roles;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesReps extends JpaRepository<Roles, Integer> {

    Roles findByName(String name);
}