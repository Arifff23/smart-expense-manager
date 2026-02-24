package com.arif.expenseManage.service;

import com.arif.expenseManage.entity.Expense;
import com.arif.expenseManage.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    // CREATE
    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    // READ ALL
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    // READ BY ID
    public Expense getExpenseById(Long id) {
        Optional<Expense> expense = expenseRepository.findById(id);
        return expense.orElse(null);
    }

    // DELETE
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    // UPDATE
    public Expense updateExpense(Long id, Expense newExpense) {
        Optional<Expense> oldExpense = expenseRepository.findById(id);

        if (oldExpense.isPresent()) {
            Expense expense = oldExpense.get();
            expense.setTitle(newExpense.getTitle());
            expense.setAmount(newExpense.getAmount());
            expense.setCategory(newExpense.getCategory());
            expense.setDate(newExpense.getDate());
            return expenseRepository.save(expense);
        }

        return null;
    }
}