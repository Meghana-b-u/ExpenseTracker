# 💰 ExpenseTracker — Android App

![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Android Studio](https://img.shields.io/badge/Android%20Studio-3DDC84?style=for-the-badge&logo=androidstudio&logoColor=white)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen?style=for-the-badge)

A fully functional **Expense Tracker Android App** built in Android Studio using Kotlin to track daily expenses with category filtering and local data storage.

---

## 📸 App Preview

<!-- Upload your screenshots to GitHub and replace the links below -->
| Splash Screen | Home Screen | Add Expense | Transaction Detail |
|---|---|---|---|
| ![Splash](screenshots/splash.png) | ![Home](screenshots/home.png) | ![Add](screenshots/add_expense.png) | ![Detail](screenshots/detail.png) |

---

## 📁 Project Structure
```
ExpenseTracker/
├── app/src/main/
│   ├── java/com/example/expensetracker/
│   │   ├── SplashActivity.kt
│   │   ├── MainActivity.kt
│   │   ├── AddExpenseActivity.kt
│   │   ├── TransactionDetailActivity.kt
│   │   ├── Transaction.kt
│   │   └── TransactionAdapter.kt
│   └── res/
│       └── layout/
│           ├── activity_splash.xml
│           ├── activity_main.xml
│           ├── activity_add_expense.xml
│           ├── activity_transaction_detail.xml
│           └── list_item_transaction.xml
└── README.md
```

---

## 📋 App Details

| Property | Details |
|---|---|
| **Language** | Kotlin |
| **IDE** | Android Studio |
| **Minimum SDK** | API 24 (Android 7.0) |
| **Storage** | SharedPreferences (local) |
| **Architecture** | Single module, Activity based |

---

## 📱 Screens

| Screen | Description |
|---|---|
| Splash Screen | App intro with logo and name, auto navigates to Home |
| Home/Dashboard | Shows total expenses, transaction count, highest expense and transaction list |
| Add Expense | Form to add new expense with title, amount, category and date |
| Transaction Detail | Shows full details of a selected transaction |

---

## ✨ Features

| Feature | Description |
|---|---|
| Add Expense | Add title, amount, category and date |
| Total Expenses | Dynamically calculated from saved data |
| Transaction Count | Shows total number of transactions |
| Highest Expense | Automatically tracks highest single expense |
| Category Filter | Filter by Food, Transport, Bills, Shopping, Entertainment |
| Input Validation | Shows error if any field is empty on save |
| Local Storage | Data saved using SharedPreferences |
| Navigation | Back button on all screens using Intents |
| Custom List | Emoji icons per category in transaction list |

---

## 🧮 Category Emoji Mapping
```kotlin
val emoji = when (category) {
    "Food"          -> "🍕"
    "Transport"     -> "🚌"
    "Bills"         -> "📱"
    "Shopping"      -> "🛒"
    "Entertainment" -> "🎬"
    else            -> "💰"
}
```

---

## 🔑 Key Highlights

- 🍕 **Food** expenses shown with pizza emoji for quick identification
- 💰 **Total expenses** update automatically every time you add a new expense
- 🔍 **Category filter** buttons let you view only relevant transactions
- ✅ **Input validation** prevents saving incomplete expense entries
- 💾 **SharedPreferences** stores all data locally without needing a database

---

## 🛠️ Tools Used

| Tool | Purpose |
|---|---|
| Android Studio | Development IDE |
| Kotlin | Programming language |
| XML Layouts | UI design |
| SharedPreferences | Local data storage |
| Android Intents | Screen navigation |
| ArrayAdapter | Custom transaction list |

---

## 🚀 How to Run This Project

**Step 1** — Clone this repository
```bash
git clone https://github.com/Meghana-b-u/ExpenseTracker.git
```

**Step 2** — Open Android Studio
```
Download free from https://developer.android.com/studio
```

**Step 3** — Open the project
```
File → Open → select ExpenseTracker folder
```

**Step 4** — Wait for Gradle to sync
```
Let Android Studio finish syncing all dependencies
```

**Step 5** — Run the app
```
Click the green Run ▶ button
Select emulator or connected physical device (API 24+)
```
---

## 👤 Author

**Meghana Balappa Uppar**
- GitHub: (https://github.com/Meghana-b-u)
- LinkedIn: (https://www.linkedin.com/in/meghana-uppar-374603267/)

---

## 📄 License

This project is open source under the [MIT License](LICENSE).

---

⭐ Star this repo if you found it helpful!
