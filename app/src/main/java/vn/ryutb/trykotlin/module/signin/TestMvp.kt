package vn.ryutb.trykotlin.module.signin

import vn.ryutb.trykotlin.module.base.Mvp

/**
 * Created by MyPC on 14/09/2017.
 */
interface TestMvp {
    interface Model : Mvp.Model {}
    interface View : Mvp.View {
        fun setTitle(withTitle: String)
    }
    interface Presenter<V : View, M : Model> : Mvp.Presenter<V, M> {
        fun loadData()
    }
}