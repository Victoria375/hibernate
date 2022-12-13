package app.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import app.entities.Role;

@Repository
public interface RoleRepository extends CrudRepository <Role, Long> {
}