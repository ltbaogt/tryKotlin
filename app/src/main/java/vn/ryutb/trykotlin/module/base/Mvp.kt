package vn.ryutb.trykotlin.module.base

/**
 * Created by MyPC on 14/09/2017.
 */
interface Mvp {
    interface Model {}
    interface View {}
    interface Presenter<in V : Mvp.View, in M : Mvp.Model> {
        fun attach(view: V, model: M)
        fun detach()
    }
}