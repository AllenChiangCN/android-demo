package cn.allen.demo

import android.app.Application

class App : Application() {

    companion object {

        @JvmStatic
        private lateinit var mInstance: App

        fun getApp(): App {
            return mInstance
        }
    }

    override fun onCreate() {
        super.onCreate()
        mInstance = this
    }
}