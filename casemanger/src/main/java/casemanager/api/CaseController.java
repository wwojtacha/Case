package casemanager.api;

import casemanager.logic.CaseLogic;
import casemanager.model.Case;
import casemanager.types.Status;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cases")
public class CaseController {

    private CaseLogic caseLogic;

    public CaseController(CaseLogic caseLogic) {
        this.caseLogic = caseLogic;
    }

    @GetMapping("/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Case> getCasesByStatus(
            @PathVariable Status status) {
        return caseLogic.getCasesWithStatus(status);
    }

    @GetMapping("/cases/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Case> getCasesByUser(
            @PathVariable Long userId) {
        return caseLogic.getCasesByUser(userId);
    }
}
