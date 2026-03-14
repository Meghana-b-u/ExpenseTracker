package com.example.expensetracker

data class Transaction(
    val emoji: String,
    val title: String,
    val category: String,
    val amount: String,
    val date: String = ""
)