package conjf.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import conjf.spring.boot.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
