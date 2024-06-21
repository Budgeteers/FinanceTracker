package com.budgeteers.financetracker.services.entry;

import com.budgeteers.financetracker.FinanceTrackerApplication;
import com.budgeteers.financetracker.api.controllers.entry.EntryController;
import com.budgeteers.financetracker.services.entry.models.Entry;
import com.budgeteers.financetracker.services.entry.models.ExpenseEntry;
import com.budgeteers.financetracker.services.entry.models.IncomeEntry;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.budgeteers.financetracker.services.entry.models.ExpenseEntry.ExpenseCategory.TRANSPORTATION;
import static com.budgeteers.financetracker.services.entry.models.IncomeEntry.IncomeCategory.BUSINESS;
import static com.budgeteers.financetracker.services.entry.models.IncomeEntry.IncomeCategory.TAX_RETURN;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EntryServiceTest {

    private EntryService entryService;

    @BeforeEach
    void setUp() {
        entryService = new EntryService();
    }

    @Test
    void addIncomeEntry() {
        entryService.addIncomeEntry(50, "TAX_RETURN", "tax return");
        assertEquals(1, entryService.getIncomeEntries().size());

        IncomeEntry incomeEntry = entryService.getIncomeEntries().get(0);
        assertEquals(50, incomeEntry.getAmount());
        assertEquals(TAX_RETURN, incomeEntry.getCategory());
        assertEquals("tax return", incomeEntry.getNotes());
    }

    @Test
    void addExpenseEntry() {
        entryService.addExpenseEntry(1050, "TRANSPORTATION", "Go bus");
        assertEquals(1, entryService.getExpenseEntries().size());

        ExpenseEntry expenseEntry = entryService.getExpenseEntries().get(0);
        assertEquals(1050, expenseEntry.getAmount());
        assertEquals(TRANSPORTATION, expenseEntry.getCategory());
        assertEquals("Go bus", expenseEntry.getNotes());
    }

    @Test
    void getProfit() {
        entryService.addIncomeEntry(50, "TAX_RETURN", "tax return");
        entryService.addExpenseEntry(1050, "TRANSPORTATION", "Go bus");

        IncomeEntry incomeEntry = entryService.getIncomeEntries().get(0);
        ExpenseEntry expenseEntry = entryService.getExpenseEntries().get(0);

        int profit = entryService.getProfit();
        assertEquals(-1000, profit);
    }

    //check that it throws exception
    @Test
    void addIncomeEntryConstraintViolationException(){
        assertThrows(ConstraintViolationException.class, () -> entryService.addIncomeEntry(-100, "PART_TIME_EMPLOYMENT", "Chatime"));
    }

    @Test
    void addExpenseEntryConstraintViolationException(){

    }
}