package vn.ryutb.trykotlin.module.signin

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import vn.ryutb.trykotlin.R
import vn.ryutb.trykotlin.module.base.BaseActivity

class MainActivity : BaseActivity(), TestMvp.View {
    private lateinit var mPresenter: TestPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPresenter = TestPresenter()
        mPresenter.attach(this, null)
        mPresenter.loadData()
    }

    override fun setTitle(withTitle: String) {
        (findViewById(R.id.tv01) as TextView).text = withTitle

        (findViewById(R.id.tv01) as TextView).setOnClickListener { v: View? -> Toast.makeText(applicationContext, "", Toast.LENGTH_SHORT).show() }
    }
}
