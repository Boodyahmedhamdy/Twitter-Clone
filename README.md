# Twitter Clone
this is a clone for twitter (X) application on **Android**, without any external sources or  database all data is represented in the app using `res` folder.

## Features
- the same look and feel for the Original app
- Change Icon from inside the app
- Dark theme enabled depending on system theme
- Change language of the app - coming soon

## Tech used
- Kotlin
- Jetpack Compose for UI
- ViewModel
- Navigation
- `Scaffold`, `NavigationDrawer` and other UI Material Components

## Understanding the App
lets dive into the application, starting from packages:
- `ui` most of the code is here because the UI layer is the current active layer
    - `components` has shared ui components like navigation drawer, top bar, bottom bar and so on
    - `screens` the content of the screen itself
    - `states` contains ui states for each element
    - `viewmodels` view model for each screen
    - `theme` created by android studio
- `utils` contains data sources to be used by `ui` package
- root contains
    - Main Activity
    - the App **starting point for application**
    - the navigation host to handle navigation


## How to Contribute
this app was made in purpose of learning how to build complex ui, it is not optimal  
and needs a lot of fixes.

while it is completely functional, it is good to improve the performance and add new features.

1. fork
2. clone to your machine
3. **enjoy** adding features or fixing bugs
4. push to your account
5. create a pull request with changes you have made and mention why you made it
6. have a great day 😊