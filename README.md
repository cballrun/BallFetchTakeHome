# Fetch Take Home Challenge

## About This Application

- This native Android application written in Kotlin returns a grouped, sorted, and filtered list of items from a provided URL containing a list of JSON items. Items are grouped by List ID, with each List ID category having its own header. Within each List ID section, items are sorted by name. All items with a null value or blank string in the Name field are excluded from the return.
- The list is displayed using RecyclerView for an easy-to-use scrollable list.

## Application Setup
- Clone the repository
- Open in Android Studio
- Set up a new virtual device with API level 24 or higher
- Click the run button

## Application Details

- Target Android API Level: 34
- Kotlin Version 1.9.0 

## Added Dependencies

- Retrofit 2.11.0
- Retrofit Gson Converter 2.11.0
- Kotlin Coroutines Core 1.8.0
- Kotlin Coroutines Android 1.8.0
