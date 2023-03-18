package practice.rn.toy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.rn.toy.entity.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {
}
