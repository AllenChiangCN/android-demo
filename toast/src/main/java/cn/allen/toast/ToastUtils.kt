package cn.allen.toast

import android.content.Context
import android.os.Handler
import android.support.annotation.StringRes
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import org.jetbrains.annotations.NotNull


class ToastUtils {

    companion object {

        private var sObject: Any? = null

        private var sHandler: Handler? = null

        private var sContext: Context? = null

        private var sView: View? = null

        private var sText: TextView? = null

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

        fun showCustom(@NotNull charSequence: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
            checkNull()
            makeCustomAndShow(charSequence, duration)
        }

        fun showCustom(@StringRes resId: Int, duration: Int = Toast.LENGTH_SHORT) {
            checkNull()
            makeCustomAndShow(resId, duration)
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

        private fun makeCustomAndShow(@NotNull charSequence: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
            if (sView == null) {
                sView = LayoutInflater.from(sContext).inflate(R.layout.layout_toast, null)
                sText = sView?.findViewById(R.id.text_toast)
            }
            cancel()
            sHandler?.post {
                synchronized(sObject!!) {
                    sToast = Toast(sContext)
                    sToast?.setGravity(Gravity.CENTER, 0, 0)
                    sToast?.duration = duration
                    sText?.text = charSequence
                    sToast?.view = sView
                    sToast?.show()
                }
            }
        }

        private fun makeCustomAndShow(@StringRes resId: Int, duration: Int = Toast.LENGTH_SHORT) {
            if (sView == null) {
                sView = LayoutInflater.from(sContext).inflate(R.layout.layout_toast, null)
                sText = sView?.findViewById(R.id.text_toast)
            }
            cancel()
            sHandler?.post {
                synchronized(sObject!!) {
                    sToast = Toast(sContext)
                    sToast?.setGravity(Gravity.CENTER, 0, 0)
                    sToast?.duration = duration
                    sText?.setText(resId)
                    sToast?.view = sView
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