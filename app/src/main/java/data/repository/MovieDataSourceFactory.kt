package data.repository

import androidx.lifecycle.MutableLiveData
import data.api.TheMovieDBInterface
import data.vo.Movie
import io.reactivex.disposables.CompositeDisposable
import androidx.paging.DataSource

class MovieDataSourceFactory (private val apiService : TheMovieDBInterface, private val compositeDisposable: CompositeDisposable)
    : DataSource.Factory<Int, Movie>() {

    val moviesLiveDataSource =  MutableLiveData<MovieDataSource>()

    override fun create(): DataSource<Int, Movie> {
        val movieDataSource = MovieDataSource(apiService,compositeDisposable)

        moviesLiveDataSource.postValue(movieDataSource)
        return movieDataSource
    }
}