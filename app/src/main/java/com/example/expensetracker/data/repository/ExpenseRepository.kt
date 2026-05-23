package com.example.expensetracker.data.repository

import androidx.lifecycle.LiveData
import com.example.expensetracker.data.local.ExpenseDao
import com.example.expensetracker.data.local.ExpenseEntity

class ExpenseRepository(private val expenseDao: ExpenseDao) {

    val allExpenses: LiveData<List<ExpenseEntity>> = expenseDao.getAllExpenses()

    suspend fun insert(expense: ExpenseEntity) {
        expenseDao.insertExpense(expense)
    }

    suspend fun delete(expense: ExpenseEntity) {
        expenseDao.deleteExpense(expense)
    }
}
