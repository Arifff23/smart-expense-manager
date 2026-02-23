package com.arif.expenseManage.repository;

import com.arif.expenseManage.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}