package cn.allen.demo.view.toast

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import cn.allen.demo.R
import cn.allen.demo.base.BaseActivity

class ToastActivity : BaseActivity() {

    private lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast)

        init()
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

    private fun init() {
        initToolbar()
    }

    private fun initToolbar() {
        mToolbar = findViewById(R.id.toolbar)
        setSupportActionBar(mToolbar)
        supportActionBar?.title = getString(R.string.toast)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
