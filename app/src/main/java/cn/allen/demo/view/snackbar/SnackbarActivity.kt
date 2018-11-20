package cn.allen.demo.view.snackbar

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Toast
import cn.allen.demo.R
import cn.allen.demo.base.BaseActivity
import cn.allen.snackbar.SnackbarUtils
import kotlinx.android.synthetic.main.activity_snackbar.*

class SnackbarActivity : BaseActivity(), View.OnClickListener {

    private lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snackbar)

        init()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnCommonSnackbar -> {
                SnackbarUtils.with(this.rootActivitySnackbar)
                    .setText(R.string.snackbar, Snackbar.LENGTH_LONG)
                    .show()
            }
            R.id.btnActionSnackbar -> {
                SnackbarUtils.with(this.rootActivitySnackbar)
                    .setText(R.string.snackbar, Snackbar.LENGTH_LONG)
                    .setAction("Ok", View.OnClickListener {
                        Toast.makeText(this, "Close", Toast.LENGTH_SHORT).show()
                    })
                    .show()
            }
            else -> {
            }
        }
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
        btnCommonSnackbar.setOnClickListener(this)
        btnActionSnackbar.setOnClickListener(this)
    }
}
