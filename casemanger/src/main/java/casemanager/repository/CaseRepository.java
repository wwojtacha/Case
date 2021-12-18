package casemanager.repository;

import casemanager.model.Case;
import casemanager.types.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CaseRepository extends JpaRepository<Case, Long> {

    List<Case> findCasesByStatus(Status status);

    List<Case> findAllByUser_Id(Long userId);

}
