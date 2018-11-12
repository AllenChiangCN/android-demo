package cn.allen.demo

import android.app.Application
import cn.jiguang.analytics.android.api.JAnalyticsInterface
import cn.jpush.android.api.JPushInterface

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

        initJiguang()
    }

    private fun initJiguang() {
        JAnalyticsInterface.setDebugMode(BuildConfig.DEBUG)
        JAnalyticsInterface.initCrashHandler(this)
        JAnalyticsInterface.init(this)

        JPushInterface.setDebugMode(BuildConfig.DEBUG)
        JPushInterface.init(this)
    }
}