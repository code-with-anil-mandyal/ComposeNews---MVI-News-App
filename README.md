# ComposeNews - MVI News App

A modern Android News app built with **Jetpack Compose**, using **MVI architecture**, **Ktor** for API calls, and **Koin** for dependency injection.  
Implements **Coroutines + Flow** for async data handling and **Swipe-to-Refresh** with clean UI state management.

---

## 📱 Features
- Fetch latest news articles from API using **Ktor**
- Display articles in a clean **Jetpack Compose UI**
- **Swipe-to-Refresh** to reload news
- **Error handling** with proper messages
- **Navigation** to article details screen
- Unidirectional **MVI architecture** with `Intent → State → UI`
- Dependency injection with **Koin**
- Clean separation of concerns (**Data, Domain, Presentation**)

---

## 🛠 Tech Stack
- **Kotlin + Coroutines + Flow** – Asynchronous programming and reactive streams  
- **Jetpack Compose** – Modern UI toolkit for Android  
- **MVI Architecture** – Clear unidirectional data flow  
- **Ktor** – Networking and API calls  
- **Koin** – Dependency Injection  
- **Accompanist SwipeRefresh** – Pull-to-refresh support  

---

## 📂 Folder Structure
com.mviktorcomposeexample
│
├─ common
│   └─ utils
│       └─ DateUtils.kt        // e.g., getDaysAgoString() and other helpers
│
├─ data
│   ├─ mapper                  // Maps API response to domain models
│   ├─ remote                  // ApiKey, BaseApiService, NewsService
│   └─ repository              // Implementation of repositories
│
├─ di
│   ├─ apiModule.kt            // Provides API / Ktor client
│   ├─ networkModule.kt        // Provides networking helpers, interceptors, logging
│   ├─ repositoryModule.kt     // Provides repository instances
│   ├─ useCaseModule.kt        // Provides use case instances
│   └─ viewModelModule.kt      // Provides ViewModel instances
│
├─ domain
│   ├─ models                  // API response & domain models
│   ├─ repository              // Repository interfaces
│   └─ useCase                  // Use cases like NewsUseCase
│
├─ presentation
│   ├─ components               // Reusable Composables (Loader, ErrorMessage, NewsItem, etc.)
│   ├─ navigation               // NavHost + screen routes
│   ├─ screens
│   │   ├─ home
│   │   │   ├─ HomeScreen.kt
│   │   │   ├─ HomeViewModel.kt
│   │   │   ├─ HomeState.kt
│   │   │   └─ HomeIntent.kt
│   │   └─ details
│   │       └─ DetailsScreen.kt
│   └─ ui
│       └─ theme                // Colors.kt, Theme.kt, Type.kt
│
├─ MainActivity.kt
└─ MyApplication.kt

---

## 🚀 Getting Started

1. **Clone the repository**
```bash
git clone https://github.com/yourusername/ComposeNews.git

2.	Open in Android Studio

	•	Minimum SDK: 24+
	•	Gradle Kotlin DSL supported

3.	Add your NewsAPI key
    const val API_KEY = "YOUR_NEWS_API_KEY"

4.	Run the app

	•	Build & run on emulator or physical device.

