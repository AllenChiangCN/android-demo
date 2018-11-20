package cn.allen.snackbar

import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.view.View

class SnackbarUtils private constructor(view: View) {

    private var mView: View? = view

    private var mText: CharSequence? = null

    private var mTextResId: Int = -1

    private var mDuration: Int = Snackbar.LENGTH_SHORT

    private var mActionText: CharSequence? = null

    private var mActionTextResId: Int = -1

    private var mListener: View.OnClickListener? = null

    companion object {

        fun with(view: View): SnackbarUtils {
            return SnackbarUtils(view)
        }
    }

    fun setText(text: CharSequence, duration: Int = Snackbar.LENGTH_SHORT): SnackbarUtils {
        mText = text
        mDuration = duration
        return this
    }

    fun setText(@StringRes resId: Int, duration: Int = Snackbar.LENGTH_SHORT): SnackbarUtils {
        mTextResId = resId
        mDuration = duration
        return this
    }

    fun setAction(text: CharSequence, listener: View.OnClickListener): SnackbarUtils {
        mActionText = text
        mListener = listener
        return this
    }

    fun setAction(@StringRes resId: Int, listener: View.OnClickListener): SnackbarUtils {
        mActionTextResId = resId
        mListener = listener
        return this
    }

    fun show() {
        val mSnackbar: Snackbar
        if (mText != null) {
            mSnackbar = Snackbar.make(mView!!, mText!!, mDuration)
        } else if (mTextResId != -1) {
            mSnackbar = Snackbar.make(mView!!, mTextResId, mDuration)
        } else {
            mSnackbar = Snackbar.make(mView!!, "Text cannot be null", mDuration)
        }
        if (mActionText != null) {
            mSnackbar.setAction(mActionText, mListener)
        } else if (mActionTextResId != -1) {
            mSnackbar.setAction(mActionTextResId, mListener)
        }
        mSnackbar.show()
    }
}