package cn.allen.demo.view.snackbar

import android.os.Bundle
import android.support.v7.widget.Toolbar
import cn.allen.demo.R
import cn.allen.demo.base.BaseActivity

class SnackbarActivity : BaseActivity() {

    private lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snackbar)

        init()
    }

    private fun init() {
        initToolbar()
        initEvents()
    }

    private fun initToolbar() {
        mToolbar = findViewById(R.id.toolbar)
        setSupportActionBar(mToolbar)
        supportActionBar?.title = getString(R.string.snackbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initEvents() {

    }
}
