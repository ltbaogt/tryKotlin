package vn.ryutb.trykotlin.module.signin

import vn.ryutb.trykotlin.module.base.Mvp

/**
 * Created by MyPC on 14/09/2017.
 */
interface MovieMvp {
    interface Model : Mvp.Model {}
    interface View : Mvp.View {
        fun setCount(withCount: Int)
        fun setTitle(withTitle: String)
    }
    interface Presenter<V : View, M : Model> : Mvp.Presenter<V, M> {
        fun loadData(forPage: Int = 1)
    }
}