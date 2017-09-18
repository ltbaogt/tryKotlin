package vn.ryutb.trykotlin.module.base

import android.app.Activity
import android.view.View
import butterknife.ButterKnife
import butterknife.Unbinder

/**
 * Created by MyPC on 16/09/2017.
 */
abstract class AppBaseViewHolder {

    var mUnBinder: Unbinder

    constructor(withActivity: Activity) {
        mUnBinder = ButterKnife.bind(this, withActivity)
    }

    constructor(withView: View) {
        mUnBinder = ButterKnife.bind(withView)
    }


}