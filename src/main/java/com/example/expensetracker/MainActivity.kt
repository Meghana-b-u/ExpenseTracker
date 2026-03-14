package com.example.expensetracker

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: TransactionAdapter
    private lateinit var listView: ListView
    private var allTransactions = mutableListOf<Transaction>()
    private var selectedCategory = "All"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "ExpenseTracker"

        listView = findViewById(R.id.transactionList)

        findViewById<Button>(R.id.btnAddExpense).setOnClickListener {
            startActivity(Intent(this, AddExpenseActivity::class.java))
        }

        setupFilterButtons()
    }

    override fun onResume() {
        super.onResume()
        loadTransactions()
    }

    private fun setupFilterButtons() {
        val buttons = mapOf(
            R.id.btnAll to "All",
            R.id.btnFood to "Food",
            R.id.btnTransport to "Transport",
            R.id.btnBills to "Bills",
            R.id.btnShopping to "Shopping",
            R.id.btnEntertainment to "Entertainment"
        )

        buttons.forEach { (id, category) ->
            findViewById<Button>(id).setOnClickListener {
                selectedCategory = category
                updateFilterButtons(buttons, id)
                applyFilter(allTransactions)
            }
        }
    }

    private fun updateFilterButtons(buttons: Map<Int, String>, selectedId: Int) {
        buttons.keys.forEach { id ->
            val btn = findViewById<Button>(id)
            if (id == selectedId) {
                btn.backgroundTintList =
                    android.content.res.ColorStateList.valueOf(android.graphics.Color.parseColor("#1E1E2E"))
                btn.setTextColor(android.graphics.Color.WHITE)
            } else {
                btn.backgroundTintList =
                    android.content.res.ColorStateList.valueOf(android.graphics.Color.parseColor("#EEEEEE"))
                btn.setTextColor(android.graphics.Color.parseColor("#1E1E2E"))
            }
        }
    }

    private fun loadTransactions() {
        val prefs = getSharedPreferences("expenses", MODE_PRIVATE)
        val count = prefs.getInt("count", 0)

        allTransactions = mutableListOf()
        var total = 0.0
        var highest = 0.0

        for (i in 0 until count) {
            val title = prefs.getString("title_$i", "Unknown") ?: "Unknown"
            val amount = prefs.getString("amount_$i", "0") ?: "0"
            val category = prefs.getString("category_$i", "Other") ?: "Other"
            val date = prefs.getString("date_$i", "") ?: ""

            val amountDouble = amount.toDoubleOrNull() ?: 0.0
            total += amountDouble
            if (amountDouble > highest) highest = amountDouble

            val emoji = when (category) {
                "Food" -> "🍕"
                "Transport" -> "🚌"
                "Bills" -> "📱"
                "Shopping" -> "🛒"
                "Entertainment" -> "🎬"
                else -> "💰"
            }

            allTransactions.add(Transaction(emoji, title, category, amount, date))
        }

        findViewById<TextView>(R.id.tvTotalBalance).text = "₹${"%.0f".format(total)}"
        findViewById<TextView>(R.id.tvTotalCount).text = "${allTransactions.size} items"
        findViewById<TextView>(R.id.tvHighest).text = "₹${"%.0f".format(highest)}"

        if (allTransactions.isEmpty()) {
            allTransactions.addAll(listOf(
                Transaction("🍕", "Pizza", "Food", "450", "01/03/2026"),
                Transaction("🚌", "Bus Pass", "Transport", "120", "05/03/2026"),
                Transaction("📱", "Mobile Bill", "Bills", "299", "10/03/2026")
            ))
        }

        applyFilter(allTransactions)
    }

    private fun applyFilter(transactions: List<Transaction>) {
        val filtered = if (selectedCategory == "All") {
            transactions
        } else {
            transactions.filter { it.category == selectedCategory }
        }

        adapter = TransactionAdapter(this, filtered)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val item = filtered[position]
            val intent = Intent(this, TransactionDetailActivity::class.java)
            intent.putExtra("title", item.title)
            intent.putExtra("category", item.category)
            intent.putExtra("amount", item.amount)
            intent.putExtra("emoji", item.emoji)
            intent.putExtra("date", item.date)
            startActivity(intent)
        }
    }
}