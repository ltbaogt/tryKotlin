package vn.ryutb.trykotlin.repo.irepo

import com.google.firebase.auth.PhoneAuthCredential
import vn.ryutb.trykotlin.model.SignInModel

/**
 * Created by MyPC on 18/09/2017.
 */
interface UserBaseRepo : BaseRepo {
    interface OnUserLoginResult {
        fun onLoginSuccess(result: SignInModel)
        fun onLoginFailed(isValid: Throwable)
    }

    fun sendCode(phone: String, verifyCallback: OnUserLoginResult)
    fun verifyCode(verifyCode: String, signInCallback: OnUserLoginResult)
    fun signIn(phoneAuth: PhoneAuthCredential?, signInCallback: OnUserLoginResult)
}