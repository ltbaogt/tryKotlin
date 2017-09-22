package vn.ryutb.trykotlin.repo

import android.app.Activity
import android.util.Log
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import vn.ryutb.trykotlin.model.SignInModel
import vn.ryutb.trykotlin.repo.irepo.UserBaseRepo
import java.util.concurrent.TimeUnit

/**
 * Created by MyPC on 18/09/2017.
 */
class FirebaseUserRepo : UserBaseRepo {

    private val mContext: Activity
    var mVerificationId: String? = null
    var mForceResendingToken: PhoneAuthProvider.ForceResendingToken? = null
    var mCredential: PhoneAuthCredential? = null

    constructor(context: Activity) {
        mContext = context
    }

    override fun sendCode(phone: String, loginCallback: UserBaseRepo.OnUserLoginResult) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phone,
                60,
                TimeUnit.SECONDS,
                mContext,
                object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    override fun onVerificationCompleted(p0: PhoneAuthCredential?) {
                        Log.d("BAOLT", ">>>onVerificationCompleted")
                        mCredential = p0
                        signIn(mCredential, loginCallback)
//                        val data = SignInModel(p0?.smsCode ?: "000000")
//                        loginCallback.onLoginSuccess(data)
                    }

                    override fun onVerificationFailed(p0: FirebaseException?) {
                        Log.d("BAOLT", ">>>onVerificationFailed")
                        loginCallback.onLoginFailed(p0 as Throwable)
                    }

                    override fun onCodeSent(verificationId: String?, forceResendingToken: PhoneAuthProvider.ForceResendingToken?) {
                        Log.d("BAOLT", ">>>onCodeSent")
                        super.onCodeSent(verificationId, forceResendingToken)
                        mVerificationId = verificationId
                        mForceResendingToken = forceResendingToken
                    }

                    override fun onCodeAutoRetrievalTimeOut(verificationId: String?) {
                        Log.d("BAOLT", ">>>onCodeAutoRetrievalTimeOut")
                        super.onCodeAutoRetrievalTimeOut(verificationId)
                    }
                })
    }

    override fun verifyCode(verifyCode: String, signInCallback: UserBaseRepo.OnUserLoginResult) {
        mVerificationId?.let {
            mCredential = PhoneAuthProvider.getCredential(it, verifyCode)
            signIn(mCredential, signInCallback)
        }
    }

    override fun signIn(phoneAuth: PhoneAuthCredential?, signInCallback: UserBaseRepo.OnUserLoginResult) {
        phoneAuth?.let {
            val auth = FirebaseAuth.getInstance().signInWithCredential(it)
                    .addOnCompleteListener { task ->
                        run {
                            if (task.isSuccessful) {
                                Log.d("BAOLT", "signInWithCredential:success")
                            } else {
                                Log.w("BAOLT", "signInWithCredential:failure", task.getException());
                            }
                        }
                    }
        }

    }

}