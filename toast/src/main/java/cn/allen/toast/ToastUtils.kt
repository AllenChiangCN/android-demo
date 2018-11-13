package cn.allen.toast

import android.content.Context
import android.os.Handler
import android.support.annotation.StringRes
import android.view.Gravity
import android.widget.Toast
import org.jetbrains.annotations.NotNull


class ToastUtils {

    companion object {

        private var sObject: Any? = null

        private var sHandler: Handler? = null

        private var sContext: Context? = null

        private var sToast: Toast? = null

        fun init(context: Context) {
            sContext = context
            sHandler = Handler(android.os.Looper.getMainLooper())
            sObject = Any()
        }

        private fun checkNull() {
            if (sContext == null) {
                throw NullPointerException("ToastUtils should be initialized")
            }
        }

        fun showCommon(@NotNull charSequence: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
            checkNull()
            makeAndShow(charSequence, duration)
        }

        fun showCommon(@StringRes resId: Int, duration: Int = Toast.LENGTH_SHORT) {
            checkNull()
            makeAndShow(resId, duration)
        }

        private fun makeAndShow(@NotNull charSequence: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
            cancel()
            sHandler?.post {
                synchronized(sObject!!) {
                    sToast = Toast.makeText(sContext, charSequence, duration)
                    sToast?.setGravity(Gravity.CENTER, 0, 0)
                    sToast?.show()
                }
            }
        }

        private fun makeAndShow(@StringRes resId: Int, duration: Int = Toast.LENGTH_SHORT) {
            cancel()
            sHandler?.post {
                synchronized(sObject!!) {
                    sToast = Toast.makeText(sContext, resId, duration)
                    sToast?.setGravity(Gravity.CENTER, 0, 0)
                    sToast?.show()
                }
            }
        }

        private fun cancel() {
            if (sToast != null) {
                sToast?.cancel()
                sToast = null
            }
        }
    }
}