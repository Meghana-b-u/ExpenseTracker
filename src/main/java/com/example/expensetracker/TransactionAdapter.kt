package com.example.expensetracker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class TransactionAdapter(context: Context, private val transactions: List<Transaction>) :
    ArrayAdapter<Transaction>(context, 0, transactions) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.list_item_transaction, parent, false)

        val item = transactions[position]
        view.findViewById<TextView>(R.id.tvEmoji).text = item.emoji
        view.findViewById<TextView>(R.id.tvTitle).text = item.title
        view.findViewById<TextView>(R.id.tvCategory).text = item.category
        view.findViewById<TextView>(R.id.tvDate).text = item.date
        view.findViewById<TextView>(R.id.tvAmount).text = "- ₹${item.amount}"

        return view
    }
}