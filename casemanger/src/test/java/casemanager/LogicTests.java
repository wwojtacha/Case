package casemanager;

import casemanager.logic.CaseLogic;
import casemanager.model.Case;
import casemanager.repository.CaseRepository;
import casemanager.types.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogicTests {

    private CaseLogic caseLogic;

    @Mock
    private CaseRepository caseRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        caseLogic = new CaseLogic(caseRepository);
    }

    @Test
    void shouldGetCasesWithOpenStatus() {

        Case openCase1 = Mockito.mock(Case.class);
        Case openCase2 = Mockito.mock(Case.class);

        List<Case> openCases = Arrays.asList(openCase1, openCase2);

        Mockito.when(caseRepository.findCasesByStatus(Status.OPEN)).thenReturn(openCases);
        Mockito.when(openCase1.getStatus()).thenReturn(Status.OPEN);
        Mockito.when(openCase2.getStatus()).thenReturn(Status.OPEN);

        List<Case> actualOpenCases = caseLogic.getCasesWithStatus(Status.OPEN);
        int openFilteredCasesSize = (int) actualOpenCases
                .stream()
                .filter(myCase -> Status.OPEN == myCase.getStatus())
                .count();

        boolean areOnlyOpenCases = actualOpenCases.size() == openFilteredCasesSize;

        final String failedTestMessage =
                "Expected to get only cases with status 'OPEN'";


        assertTrue(areOnlyOpenCases, failedTestMessage);
    }


}
