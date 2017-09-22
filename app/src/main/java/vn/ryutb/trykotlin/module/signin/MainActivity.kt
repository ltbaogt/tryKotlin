package vn.ryutb.trykotlin.module.signin

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_firebase.*
import kotlinx.android.synthetic.main.activity_main.*
import vn.ryutb.trykotlin.R
import vn.ryutb.trykotlin.module.base.BaseActivity

class MainActivity : BaseActivity(), SignInMvp.View {
    private lateinit var mPresenter: SignInPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase)
        mPresenter = SignInPresenter(this)
        mPresenter.attach(this, null)
        btnSendCode.setOnClickListener({ _ -> mPresenter.sendCode(etPhone.text.toString()) })
        btnVerify.setOnClickListener({_ -> mPresenter.verifyCode(etVerifyCode.text.toString())})

    }

    override fun setTitle(withTitle: String) {
        (findViewById(R.id.tv01) as TextView).text = withTitle

        (findViewById(R.id.tv01) as TextView).setOnClickListener { v: View? -> Toast.makeText(applicationContext, "", Toast.LENGTH_SHORT).show() }
    }
}
