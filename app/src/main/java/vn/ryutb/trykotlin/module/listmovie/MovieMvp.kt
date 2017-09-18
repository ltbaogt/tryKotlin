package vn.ryutb.trykotlin.module.signin

import vn.ryutb.trykotlin.model.Movie
import vn.ryutb.trykotlin.module.base.Mvp

/**
 * Created by MyPC on 14/09/2017.
 */
interface MovieMvp {
    interface Model : Mvp.Model
    interface View : Mvp.View {
        fun setMovieList(withList: List<Movie>)
        fun setIsLoading(isLoading: Boolean)
        fun setIsLastPage(isLp: Boolean)
    }

    interface Presenter<V : View, M : Model> : Mvp.Presenter<V, M> {
        fun loadData(forPage: Int = 1)
    }
}