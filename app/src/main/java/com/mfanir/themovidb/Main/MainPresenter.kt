package com.mfanir.themovidb.Main

import com.google.gson.Gson
import com.mfanir.themovidb.Model.MovieResponse
import com.mfanir.themovidb.Network.ApiRepository
import com.mfanir.themovidb.Network.TMDBApi
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter(
    private val view: MainView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {
    fun getMovieList() {
        doAsync {
            val data = gson.fromJson(apiRepository.doRequest(TMDBApi.getMovie()), MovieResponse::class.java)
            uiThread {
                view.showMovieList(data.results)
            }
        }
    }
}