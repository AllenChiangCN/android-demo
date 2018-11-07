package cn.allen.demo.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import cn.allen.demo.R
import cn.allen.demo.adapter.MainRecyclerAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var mTitles: Array<String>

    private lateinit var mToolbar: Toolbar

    private lateinit var mRecyclerView: RecyclerView

    private lateinit var mRecyclerAdapter: MainRecyclerAdapter

    private lateinit var mLayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    fun init() {
        mToolbar = findViewById(R.id.toolbar)
        setSupportActionBar(mToolbar)

        mTitles = arrayOf("Toast")
        mRecyclerView = findViewById<RecyclerView>(R.id.recycler_view_main)
        mRecyclerAdapter = MainRecyclerAdapter(mTitles)
        mLayoutManager = LinearLayoutManager(this)
        mRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = mLayoutManager
            adapter = mRecyclerAdapter
        }
    }
}
