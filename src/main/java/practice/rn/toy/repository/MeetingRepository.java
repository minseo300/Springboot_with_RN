package practice.rn.toy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.rn.toy.entity.Meeting;

import java.util.List;

public interface MeetingRepository extends JpaRepository<Meeting,Long> {
    List<Meeting> findAllByGroup_Id(Long groupId);
}
