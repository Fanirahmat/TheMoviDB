package com.mfanir.themovidb.Main

import com.mfanir.themovidb.Model.Movie

interface MainView {
    fun showMovieList(data: List<Movie>)
}