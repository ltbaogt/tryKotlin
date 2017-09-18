package vn.ryutb.trykotlin.module.signin

import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import vn.ryutb.trykotlin.model.Movie
import vn.ryutb.trykotlin.module.base.BasePresenter
import vn.ryutb.trykotlin.network.RestClient
import java.lang.StringBuilder

/**
 * Created by MyPC on 14/09/2017.
 */
class MovieListPresenter : BasePresenter<MovieMvp.View, MovieMvp.Model>(), MovieMvp.Presenter<MovieMvp.View, MovieMvp.Model> {

    override fun loadData(forPage: Int) {
        disposalList.add(RestClient.provideRestClient().getMovieList(forPage)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map {
                    result ->
                    result.results
                }
                //.filter { t -> t.title.startsWith("N") }
//                .concatMap { s -> Observable.just(movieList.append(s.title).append(" - ")); }
                .subscribe({ videos -> onReceiveMovie(videos) },
                        { err -> Log.e("Baolt", err.message) }
                ))
//                .map {
//                    result ->
//                    result.results
//                }
//                .subscribe({ abc -> view?.setTitle(abc[0].title) },
//                        { err -> Log.e("Baolt", err.message) }
//                ))
    }

    private fun onReceiveMovie(arrayList: ArrayList<Movie>) {
        view?.setIsLoading(false)
        if (arrayList.size > 0) view?.setMovieList(arrayList)
        if (arrayList.size < MovieListActivity.PAGE_SIZE) view?.setIsLastPage(true)
    }

}