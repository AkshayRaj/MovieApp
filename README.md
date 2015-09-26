# MovieApp
This repository contains source code for an Android App which uses APIs from TMDB : The Movie Database.
APIs are used to search for Movies using User Query.
The results display a listView of first 20 movies returned by the TMDB server
The App uses the android MVC pattern to construct the UI
Each element in the listView contains moviePoster, movieName, movieYear
Each element is clickable and opens a new Activity which shows more info regarding the movie selected. It shows a backdrop image,
movieName, movieReleaseData, movieRating, movieRuntime(if returned by the API), and a short summary
Target for androidSDK API Level 14 - 19.
