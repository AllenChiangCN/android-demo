package cn.allen.demo.view.toast

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import cn.allen.demo.R
import cn.allen.demo.base.BaseActivity
import cn.allen.toast.ToastUtils
import kotlinx.android.synthetic.main.activity_toast.*

class ToastActivity : BaseActivity(), View.OnClickListener {

    private lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast)

        init()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnCommonToast -> {
                ToastUtils.showCommon(R.string.show_common_toast)
            }
            R.id.btnCustomToast -> {
                ToastUtils.showCustom(R.string.show_common_toast)
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
        supportActionBar?.title = getString(R.string.toast)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initEvents() {
        btnCommonToast.setOnClickListener(this)
        btnCustomToast.setOnClickListener(this)
    }
}
