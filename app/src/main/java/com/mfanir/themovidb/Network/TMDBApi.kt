package com.mfanir.themovidb.Network

import com.mfanir.themovidb.BuildConfig.API_KEY
import com.mfanir.themovidb.BuildConfig.BASE_URL

object TMDBApi {
    fun getMovie(): String {
        return BASE_URL + API_KEY
    }
}