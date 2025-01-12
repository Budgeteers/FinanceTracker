package com.budgeteers.financetracker.service;

import com.budgeteers.financetracker.dao.ExpenseEntryDao;
import com.budgeteers.financetracker.dao.IncomeEntryDao;
import com.budgeteers.financetracker.model.ExpenseEntry;
import com.budgeteers.financetracker.model.IncomeEntry;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Service
public class EntryService {
    private final IncomeEntryDao incomeEntryDao;
    private final ExpenseEntryDao expenseEntryDao;

    public EntryService(IncomeEntryDao incomeEntryDao, ExpenseEntryDao expenseEntryDao) {
        this.incomeEntryDao = incomeEntryDao;
        this.expenseEntryDao = expenseEntryDao;
    }

    public void addIncomeEntry(int amount, IncomeEntry.IncomeCategory incomeCategory, String notes) {
        IncomeEntry entry = new IncomeEntry(null, amount, incomeCategory, notes);
        incomeEntryDao.save(entry);
    }

    public void addExpenseEntry(int amount, ExpenseEntry.ExpenseCategory expenseCategory, String notes) {
        ExpenseEntry entry = new ExpenseEntry(null, amount, expenseCategory, notes);
        expenseEntryDao.save(entry);
    }
    
    public List<ExpenseEntry> getExpenseEntries() {
        return expenseEntryDao.findAll();
    }

    public List<IncomeEntry> getIncomeEntries() {
        return incomeEntryDao.findAll();
    }

    public int getProfit() {
        int profit = 0;

        for (IncomeEntry incomeEntry : incomeEntryDao.findAll()) {
            profit += incomeEntry.getAmount();
        }

        for (ExpenseEntry expenseEntry : expenseEntryDao.findAll()) {
            profit -= expenseEntry.getAmount();
        }

        return profit;
    }

    public void deleteExpenseEntry(String id) {
        expenseEntryDao.delete(id);
    }
}
