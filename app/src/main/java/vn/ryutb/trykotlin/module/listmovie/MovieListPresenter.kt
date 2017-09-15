package vn.ryutb.trykotlin.module.signin

import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import vn.ryutb.trykotlin.module.base.BasePresenter
import vn.ryutb.trykotlin.network.RestClient
import java.lang.StringBuilder

/**
 * Created by MyPC on 14/09/2017.
 */
class MovieListPresenter : BasePresenter<MovieMvp.View, MovieMvp.Model>(), MovieMvp.Presenter<MovieMvp.View, MovieMvp.Model> {

    override fun loadData(forPage: Int) {
        val movieList: StringBuilder = StringBuilder()
        disposalList.add(RestClient.provideRestClient().getMovieList(forPage)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap {
                    result ->
                    Observable.fromIterable(result.results)
                }
                //.filter { t -> t.title.startsWith("N") }
                .concatMap { s -> Observable.just(movieList.append(s.title).append(" - ") ); }
                .subscribe({ abc -> view?.setTitle(abc.toString()) },
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

}