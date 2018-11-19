package cn.allen.demo.base

import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import cn.jiguang.analytics.android.api.JAnalyticsInterface

abstract class BaseActivity : AppCompatActivity() {

    var TAG = javaClass.simpleName

    override fun onResume() {
        super.onResume()
        JAnalyticsInterface.onPageStart(this, javaClass.canonicalName)
    }

    override fun onPause() {
        super.onPause()
        JAnalyticsInterface.onPageEnd(this, javaClass.canonicalName)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                finish()
            }
            else -> {
            }
        }
        return super.onOptionsItemSelected(item)
    }
}