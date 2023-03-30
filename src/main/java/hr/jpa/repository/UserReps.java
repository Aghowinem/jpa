package hr.jpa.repository;

import hr.jpa.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserReps extends CrudRepository<User, Integer> {
}
