package cn.allen.demo.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import java.lang.ref.WeakReference

class LaunchUtil private constructor() {

    private var mContext: Context? = null

    private var mIntent: Intent? = null

    companion object {

        @JvmStatic
        private var sInstance: LaunchUtil? = null

        fun start(context: Context, clazz: Class<*>): LaunchUtil {
            sInstance = LaunchUtil()
            sInstance?.mContext = WeakReference<Context>(context).get()
            sInstance?.mIntent = Intent()
            sInstance?.mIntent?.setClass(sInstance?.mContext!!, clazz)
            return sInstance!!
        }
    }

    // TODO: put extra datas & overload this function
//    fun putExtra(): LaunchUtil {
//        return this
//    }

    fun launchForResult(requestCode: Int) {
        if (mContext != null) {
            if (mContext is Activity) {
                val activity: Activity = mContext as Activity
                activity.startActivityForResult(mIntent, requestCode)
                mContext = null
                mIntent = null
            }
        }
    }

    fun launch() {
        if (mContext != null) {
            mContext?.startActivity(mIntent)
            mContext = null
            mIntent = null
        }
    }
}