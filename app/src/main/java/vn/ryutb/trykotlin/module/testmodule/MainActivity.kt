package vn.ryutb.trykotlin.module.testmodule

import android.os.Bundle
import vn.ryutb.trykotlin.R
import vn.ryutb.trykotlin.module.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
