package vn.ryutb.trykotlin.module.signin

import android.app.Activity
import android.util.Log
import vn.ryutb.trykotlin.model.SignInModel
import vn.ryutb.trykotlin.module.base.BasePresenter
import vn.ryutb.trykotlin.repo.FirebaseUserRepo
import vn.ryutb.trykotlin.repo.irepo.UserBaseRepo

/**
 * Created by MyPC on 14/09/2017.
 */
class SignInPresenter(act: Activity) : BasePresenter<SignInMvp.View, SignInMvp.Model>(), SignInMvp.Presenter<SignInMvp.View, SignInMvp.Model> {

    private val mActivity = act

    private val repo: FirebaseUserRepo

    init {
        repo = FirebaseUserRepo(mActivity)
    }

    override fun sendCode(phone: String) {
        repo.sendCode(phone, object : UserBaseRepo.OnUserLoginResult {
            override fun onLoginSuccess(result: SignInModel) {
                Log.d("Baolt", result.toString())
            }

            override fun onLoginFailed(isValid: Throwable) {
                Log.d("Baolt", isValid.message)
            }
        })
    }

    override fun verifyCode(code: String) {
        repo.verifyCode(code, object : UserBaseRepo.OnUserLoginResult {
            override fun onLoginSuccess(result: SignInModel) {
                Log.d("Baolt", result.toString())
            }

            override fun onLoginFailed(isValid: Throwable) {
                Log.d("Baolt", isValid.message)
            }
        })
    }

}