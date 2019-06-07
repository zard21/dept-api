package kr.codelab.demo.repository;

import kr.codelab.demo.model.DeptGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeptGroupRepository extends JpaRepository<DeptGroup, Long> {

    Optional<DeptGroup> findByName(String name);
}
