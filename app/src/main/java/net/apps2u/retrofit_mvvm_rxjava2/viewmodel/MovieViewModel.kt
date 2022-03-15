package net.apps2u.retrofit_mvvm_rxjava2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

import net.apps2u.retrofit_mvvm_rxjava2.data.MovieService
import net.apps2u.retrofit_mvvm_rxjava2.model.MovieModel

class MovieViewModel: ViewModel() {
    val movies = MutableLiveData<List<MovieModel>>()

    private val movieService: MovieService = MovieService()
    private val disposable: CompositeDisposable = CompositeDisposable()

    fun refresh(){
        fetchDataFromRemoteApi()
    }

    fun fetchDataFromRemoteApi(){
        disposable.add(
            movieService.getMovies()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<MovieModel>>(){
                    override fun onSuccess(movieList: List<MovieModel>) {
                        movies.value = movieList
                    }
                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}