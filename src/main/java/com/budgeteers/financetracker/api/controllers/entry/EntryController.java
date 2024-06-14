package com.budgeteers.financetracker.api.controllers.entry;

import com.budgeteers.financetracker.api.controllers.entry.models.EntryResponse;
import com.budgeteers.financetracker.api.controllers.entry.models.ExpenseEntryRequest;
import com.budgeteers.financetracker.api.controllers.entry.models.IncomeEntryRequest;
import com.budgeteers.financetracker.api.controllers.entry.models.ProfitResponse;
import com.budgeteers.financetracker.services.entry.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entry")
public class EntryController {

    private final EntryService entryService;

    @Autowired
    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @PostMapping("/income")
    public ResponseEntity<EntryResponse> addIncomeEntry(@RequestBody IncomeEntryRequest incomeEntryRequest) {
        try {
<<<<<<< 6-creating-notes
            entryService.addIncomeEntry(incomeEntryRequest.getAmount(), incomeEntryRequest.getCategory(), incomeEntryRequest.getCategoryNote());
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            EntryResponse response = new EntryResponse(400,incomeEntryRequest.getCategory() + " is not a valid category");
=======
            entryService.addIncomeEntry(incomeEntryRequest.getAmount(), incomeEntryRequest.getCategory());
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            EntryResponse response = new EntryResponse(400,incomeEntryRequest.getCategory() + " is not a valid input");
>>>>>>> main
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/expense")
    public ResponseEntity<EntryResponse> addExpenseEntry(@RequestBody ExpenseEntryRequest expenseEntryRequest) {
        try {
<<<<<<< 6-creating-notes
            entryService.addExpenseEntry(expenseEntryRequest.getAmount(), expenseEntryRequest.getCategory(), expenseEntryRequest.getCategoryNote());
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            EntryResponse response = new EntryResponse(400,expenseEntryRequest.getCategory() + " is not a valid category");
=======
            entryService.addExpenseEntry(expenseEntryRequest.getAmount(), expenseEntryRequest.getCategory());
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            EntryResponse response = new EntryResponse(400,expenseEntryRequest.getCategory() + " is not a valid input");
>>>>>>> main
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/profit")
    public ResponseEntity<ProfitResponse> getProfit() {
        return ResponseEntity.ok(new ProfitResponse(entryService.getProfit()));
    }
}
