package net.apps2u.retrofit_mvvm_rxjava2.data


import io.reactivex.Single
import net.apps2u.retrofit_mvvm_rxjava2.model.MovieModel
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

import retrofit2.converter.gson.GsonConverterFactory


class MovieService {
    private val BASE_URL = ""

    private val  api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(MovieApi::class.java)

    fun getMovies(): Single<List<MovieModel>> {
        return api.getMovie()
    }
}
