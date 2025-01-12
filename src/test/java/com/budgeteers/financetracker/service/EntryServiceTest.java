package com.budgeteers.financetracker.service;

import com.budgeteers.financetracker.dao.ExpenseEntryDao;
import com.budgeteers.financetracker.dao.IncomeEntryDao;
import com.budgeteers.financetracker.model.ExpenseEntry;
import com.budgeteers.financetracker.model.IncomeEntry;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.budgeteers.financetracker.model.ExpenseEntry.ExpenseCategory.TRANSPORTATION;
import static com.budgeteers.financetracker.model.IncomeEntry.IncomeCategory.TAX_RETURN;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class EntryServiceTest {

    private EntryService entryService;

    @Mock
    private EntityManager entityManager;

    @Mock
    private IncomeEntryDao incomeEntryDao;
    
    @Mock
    private ExpenseEntryDao expenseEntryDao;

    @BeforeEach
    void setUp() {
        entryService = new EntryService(incomeEntryDao, expenseEntryDao);
    }

    @Test
    void addIncomeEntry() {
        when(incomeEntryDao.findAll()).thenReturn(List.of(new IncomeEntry("1",50, TAX_RETURN, "tax return")));

        entryService.addIncomeEntry(50, TAX_RETURN, "tax return");
        assertEquals(1, entryService.getIncomeEntries().size());

        IncomeEntry incomeEntry = entryService.getIncomeEntries().get(0);
        assertEquals(50, incomeEntry.getAmount());
        assertEquals(TAX_RETURN, incomeEntry.getCategory());
        assertEquals("tax return", incomeEntry.getNotes());
    }

    @Test
    void addExpenseEntry() {
        when(expenseEntryDao.findAll()).thenReturn(List.of(new ExpenseEntry("1", 1050, TRANSPORTATION, "Go bus")));

        entryService.addExpenseEntry(1050, TRANSPORTATION, "Go bus");
        assertEquals(1, entryService.getExpenseEntries().size());

        ExpenseEntry expenseEntry = entryService.getExpenseEntries().get(0);
        assertEquals(1050, expenseEntry.getAmount());
        assertEquals(TRANSPORTATION, expenseEntry.getCategory());
        assertEquals("Go bus", expenseEntry.getNotes());
    }

    @Test
    void getProfit() {
        when(incomeEntryDao.findAll()).thenReturn(List.of(new IncomeEntry("1", 50, TAX_RETURN, "tax return")));
        when(expenseEntryDao.findAll()).thenReturn(List.of(new ExpenseEntry("1",1050, TRANSPORTATION, "Go bus")));

        entryService.addIncomeEntry(50, TAX_RETURN, "tax return");
        entryService.addExpenseEntry(1050, TRANSPORTATION, "Go bus");

        int profit = entryService.getProfit();
        assertEquals(-1000, profit);
    }
}