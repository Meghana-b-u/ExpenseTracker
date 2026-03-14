package com.example.expensetracker

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class AddExpenseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_expense)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Add Expense"

        val categories = listOf("Food", "Transport", "Bills", "Shopping", "Entertainment", "Other")
        val spinner = findViewById<Spinner>(R.id.spinnerCategory)
        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, categories)

        val etTitle = findViewById<EditText>(R.id.etTitle)
        val etAmount = findViewById<EditText>(R.id.etAmount)
        val etDate = findViewById<EditText>(R.id.etDate)

        findViewById<Button>(R.id.btnSave).setOnClickListener {
            val title = etTitle.text.toString().trim()
            val amount = etAmount.text.toString().trim()
            val date = etDate.text.toString().trim()

            if (title.isEmpty()) {
                etTitle.error = "Please enter a title"
                etTitle.requestFocus()
                return@setOnClickListener
            }
            if (amount.isEmpty()) {
                etAmount.error = "Please enter an amount"
                etAmount.requestFocus()
                return@setOnClickListener
            }
            if (date.isEmpty()) {
                etDate.error = "Please enter a date"
                etDate.requestFocus()
                return@setOnClickListener
            }

            val prefs = getSharedPreferences("expenses", MODE_PRIVATE)
            val editor = prefs.edit()
            val count = prefs.getInt("count", 0)
            editor.putString("title_$count", title)
            editor.putString("amount_$count", amount)
            editor.putString("date_$count", date)
            editor.putString("category_$count", spinner.selectedItem.toString())
            editor.putInt("count", count + 1)
            editor.apply()

            Toast.makeText(this, "Expense Saved!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

}