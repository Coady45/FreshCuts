# Fresh Cuts Barber

A simple Android mobile application for booking barber appointments.

## Description

Fresh Cuts Barber is a mobile app that allows customers to easily book haircut appointments.  
Users can view available services, choose a barber, select a date and time, and confirm their booking.

This project was developed as part of a student assignment.

## Features

- User Login and Registration
- Home page with quick actions
- View list of Services
- View list of Barbers and their specialities
- Book an Appointment (Service, Barber, Date, Time, Notes)
- View My Bookings
- User Profile with Logout
- Bottom Navigation for easy movement between pages

## Screens

- Login
- Register
- Home
- Services
- Barbers
- Book Appointment
- My Bookings
- Profile

## Tech Stack

- Language: Kotlin
- UI: XML Layouts
- Architecture: Single Activity + Multiple Fragments
- Navigation: Android Navigation Component
- Bottom Navigation Bar
- View Binding

## How to Run the App

1. Open the project in **Android Studio**
2. Sync the project with Gradle
3. Connect an Android phone or start an emulator
4. Click the **Run** button

### Or install the APK:

1. Build → Build Bundle(s) / APK(s) → Build APK(s)
2. Locate the file: `app/build/outputs/apk/debug/app-debug.apk`
3. Transfer the APK to your phone and install it

## Project Structure

- `LoginActivity` & `RegisterActivity` → Authentication
- `MainActivity` → Main container with Bottom Navigation
- Fragments:
  - HomeFragment
  - ServicesFragment
  - BarbersFragment
  - BookAppointmentFragment
  - MyBookingsFragment
  - ProfileFragment



## Future Improvements

- Real database (Firebase / Room)
- Push notifications / SMS reminders
- Online payment
- Barber availability calendar
- Ratings and reviews# FreshCuts

-       Youtube link [   ]
