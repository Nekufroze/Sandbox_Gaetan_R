## Project Architecture

This project follows the MVVM (Model-View-ViewModel) architecture pattern.
The project is written in Kotlin and Java, and uses Gradle for build automation.

### Model

The Model represents the data and business logic of the application. In this project, the Model is
represented by the `CharacterRepositoryImpl` class, which retrieves character and episode data from
a local file.

### View

The View is responsible for rendering the UI and responding to user interactions. In this project,
the View is represented by various UI screens such
as `CharactersViewModel`, `EpisodeDetailsViewModel`, and `CharacterDetailsViewModel`.

### ViewModel

The ViewModel acts as a bridge between the Model and the View. It handles the logic and
provides data for the UI. The ViewModel respects the lifecycle of its
associated View. Here ViewModel are represented by classes
like `CharactersViewModel`, `EpisodeDetailsViewModel`, and `CharacterDetailsViewModel`.

## Building the Project

To build the project, you need to have Android Studio installed, an emulator or an android phone
with at least an sdk 30.
Open the project in Android Studio
and click on `Build > Make Project`.

## Running the Project

To run the project, you need to have an Android device or emulator connected. Click
on `Run > Run 'app'`.

