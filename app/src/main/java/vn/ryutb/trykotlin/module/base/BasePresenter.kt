package vn.ryutb.trykotlin.module.base

import io.reactivex.disposables.CompositeDisposable

/**
 * Created by MyPC on 14/09/2017.
 */
open class BasePresenter<V : Mvp.View, M : Mvp.Model> : Mvp.Presenter<V, M> {
    protected var view: V? = null
    protected var model: M? = null
    protected val disposalList : CompositeDisposable = CompositeDisposable()

    override fun attach(view: V?, model: M?) {
        this.view = view
        this.model = model
    }

    override fun detach() {
    }

}