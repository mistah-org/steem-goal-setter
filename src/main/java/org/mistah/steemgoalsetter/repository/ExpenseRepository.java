package org.mistah.steemgoalsetter.repository;

import org.mistah.steemgoalsetter.model.expense.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends MongoRepository<Expense, String> {
}