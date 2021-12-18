package casemanager.logic;

import casemanager.model.Case;
import casemanager.repository.CaseRepository;
import casemanager.types.Status;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaseLogic {

    private CaseRepository caseRepository;

    public CaseLogic(CaseRepository caseRepository) {
        this.caseRepository = caseRepository;
    }

    public List<Case> getCasesWithStatus(Status status) {

        return caseRepository.findCasesByStatus(status);
    }

    public List<Case> getCasesByUser(Long userId) {
        return caseRepository.findAllByUser_Id(userId);
    }
}
