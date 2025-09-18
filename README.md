SimpleTaskApplication
Overview
This is a simple Android app built using Kotlin and Jetpack Compose that fetches and displays posts from a remote REST API. The app demonstrates basic modern Android architecture, clean modularization, and state management with Kotlin coroutines and StateFlow.

Features
Fetch JSON data from a REST API using Retrofit

Display a filtered list of posts

Clean separation of concerns leveraging MVVM pattern

Basic error handling and state display

Simple UI with Compose and Material Design components

Architecture and Implementation
The project is split into two main Gradle modules:

:data — Handles data layer including network (Retrofit with kotlinx.serialization), models, and data source

:app — Contains UI, ViewModel, and repository implementations

Time Spent Breakdown
20 minutes: Initial project setup; configured imports, modules, and project structure to enable clean separation and scalability.

30 minutes: Implemented data layer logic, including Retrofit configuration, data source, models, and serialization using kotlinx.serialization.
             Developed repository layer, repository implementation, and the ViewModel to expose StateFlow of posts.

10 minutes: Created UI using Jetpack Compose to display the list of posts with a simple and clean card-based layout.

How to Run
Clone the repository:

git clone https://github.com/ikbal995/SimpleTaskApplication.git
Open the project in Android Studio.

Build and run the app on an emulator or physical device with internet access.

Notes for Review
The architecture is designed to be easily extendable for more complex features.

Error handling is basic but structured for improvement.

UI is kept minimal but follows modern Compose and Material principles.
