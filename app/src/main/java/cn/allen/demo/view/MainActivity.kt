package cn.allen.demo.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import cn.allen.demo.R
import cn.allen.demo.adapter.MainRecyclerAdapter
import cn.allen.demo.util.LaunchUtil
import cn.allen.demo.view.toast.ToastActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mTitles: Array<String>

    private lateinit var mToolbar: Toolbar

    private lateinit var mRecyclerView: RecyclerView

    private lateinit var mRecyclerAdapter: MainRecyclerAdapter

    private lateinit var mLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        initToolbar()
        initRecyclerView()
    }

    private fun initToolbar() {
        mToolbar = findViewById(R.id.toolbar)
        setSupportActionBar(mToolbar)
        supportActionBar?.title = getString(R.string.app_name)
    }

    private fun initRecyclerView() {
        mTitles = arrayOf(getString(R.string.toast))
        mRecyclerAdapter = MainRecyclerAdapter(mTitles)
        mLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mRecyclerView = findViewById<RecyclerView>(R.id.recycler_view_main).apply {
            setHasFixedSize(true)
            layoutManager = mLayoutManager
            addItemDecoration(DividerItemDecoration(this.context, (layoutManager as LinearLayoutManager).orientation))
            adapter = mRecyclerAdapter
        }
        mRecyclerAdapter.setOnItemClickListener(object : MainRecyclerAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                LaunchUtil.start(this@MainActivity, ToastActivity::class.java).launch()
            }
        })
    }
}
