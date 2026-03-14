# 💰 ExpenseTracker

An Android application to track daily expenses, built with Kotlin in Android Studio.

## 📱 Screens
- **Splash Screen** — App intro with logo and name
- **Home/Dashboard** — Shows total expenses, transaction count, highest expense and recent transactions
- **Add Expense** — Form to add new expense with title, amount, category and date
- **Transaction Detail** — Shows full details of a selected transaction

## ✨ Features
- Add expenses with title, amount, category and date
- View total expenses dynamically
- View total transaction count
- View highest expense
- Filter transactions by category (Food, Transport, Bills, Shopping, Entertainment)
- Input validation on Add Expense form
- Data saved locally using SharedPreferences
- Back button navigation on all screens
- Custom transaction list with emoji icons per category

## 🛠 Built With
- Kotlin
- Android Studio
- SharedPreferences (local data storage)
- XML Layouts
- Android Intents (navigation)

## 📂 Project Structure
```
app/
├── java/com/example/expensetracker/
│   ├── SplashActivity.kt
│   ├── MainActivity.kt
│   ├── AddExpenseActivity.kt
│   ├── TransactionDetailActivity.kt
│   ├── Transaction.kt
│   └── TransactionAdapter.kt
└── res/
    └── layout/
        ├── activity_splash.xml
        ├── activity_main.xml
        ├── activity_add_expense.xml
        ├── activity_transaction_detail.xml
        └── list_item_transaction.xml
```

## 🚀 How to Run
1. Clone the repository
2. Open in Android Studio
3. Run on emulator or physical device (API 24+)

## 👩‍💻 Developed By
Meghana B U — Internship Side Project
