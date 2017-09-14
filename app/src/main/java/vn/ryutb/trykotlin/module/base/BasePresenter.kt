package vn.ryutb.trykotlin.module.base

/**
 * Created by MyPC on 14/09/2017.
 */
open class BasePresenter<in V : Mvp.View, in M : Mvp.Model> : Mvp.Presenter<V, M> {
    override fun attach(view: V, model: M) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun detach() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}