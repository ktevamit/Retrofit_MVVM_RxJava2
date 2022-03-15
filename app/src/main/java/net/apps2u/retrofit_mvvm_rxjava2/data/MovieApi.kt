package net.apps2u.retrofit_mvvm_rxjava2.data


import io.reactivex.Single
import net.apps2u.retrofit_mvvm_rxjava2.model.MovieModel
import retrofit2.http.GET

interface MovieApi {
    @GET("top.php")
    fun getMovie(): Single<List<MovieModel>>
}