package vn.ryutb.trykotlin.module.signin

import com.google.gson.JsonObject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import vn.ryutb.trykotlin.module.base.BasePresenter
import vn.ryutb.trykotlin.network.RestClient

/**
 * Created by MyPC on 14/09/2017.
 */
class TestPresenter : BasePresenter<TestMvp.View, TestMvp.Model>(), TestMvp.Presenter<TestMvp.View, TestMvp.Model> {

    override fun loadData() {
        val request: JsonObject = JsonObject()
        request.addProperty("userLogin", "0909521182")
        request.addProperty("password", "123")
        request.addProperty("osName", "Android")
        request.addProperty("deviceToken", "a--dadkljnzxckjsahndzaskdzx-asmnzxc")
        disposalList.add(RestClient.provideRestClient().login(100, request)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map {
                    result ->
                    result.data
                }
                .subscribe({ abc -> view?.setTitle(abc.name) },
                        { err -> view?.setTitle(err.message ?: "Lỗi") }
                ))
    }

}