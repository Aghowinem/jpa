package hr.jpa.repository;

import hr.jpa.entity.Roles;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesReps extends JpaRepository<Roles, Integer> {
}
