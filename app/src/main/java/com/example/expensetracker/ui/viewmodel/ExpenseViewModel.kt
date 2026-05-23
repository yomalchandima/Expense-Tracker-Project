package com.example.expensetracker.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.expensetracker.data.local.ExpenseDatabase
import com.example.expensetracker.data.local.ExpenseEntity
import com.example.expensetracker.data.repository.ExpenseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExpenseViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ExpenseRepository
    val allExpenses: LiveData<List<ExpenseEntity>>

    init {
        val expenseDao = ExpenseDatabase.getDatabase(application).expenseDao()
        repository = ExpenseRepository(expenseDao)
        allExpenses = repository.allExpenses
    }

    fun insert(expense: ExpenseEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(expense)
    }

    fun delete(expense: ExpenseEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(expense)
    }
}
