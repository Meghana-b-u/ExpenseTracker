package com.example.expensetracker

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TransactionDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Transaction Detail"

        findViewById<TextView>(R.id.tvDetailEmoji).text = intent.getStringExtra("emoji")
        findViewById<TextView>(R.id.tvDetailTitle).text = intent.getStringExtra("title")
        findViewById<TextView>(R.id.tvDetailCategory).text = intent.getStringExtra("category")
        findViewById<TextView>(R.id.tvDetailAmount).text = "- ₹${intent.getStringExtra("amount")}"
        findViewById<TextView>(R.id.tvDetailDate).text = intent.getStringExtra("date")
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
