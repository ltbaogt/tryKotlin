package vn.ryutb.trykotlin.module.signin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import vn.ryutb.trykotlin.R
import vn.ryutb.trykotlin.module.base.BaseActivity

class MovieListActivity : BaseActivity(), MovieMvp.View {

    private lateinit var mPresenter: MovieListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPresenter = MovieListPresenter()
        mPresenter.attach(this, null)
        (findViewById(R.id.loadData) as Button).setOnClickListener({v ->
            mPresenter.loadData((findViewById(R.id.et01) as EditText).text.toString().toIntOrNull() ?: 1)
        })

    }

    override fun setCount(withCount: Int) {
        (findViewById(R.id.tv01) as TextView).text = withCount.toString()

        (findViewById(R.id.tv01) as TextView).setOnClickListener { v: View? -> Toast.makeText(applicationContext, "", Toast.LENGTH_SHORT).show() }
    }

    override fun setTitle(withTitle: String) {
        (findViewById(R.id.tv01) as TextView).text = withTitle
    }
}
