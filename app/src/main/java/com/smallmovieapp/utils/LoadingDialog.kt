package com.smallmovieapp.utils


import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.annotation.StringRes
import com.smallmovieapp.R

class LoadingDialog private constructor(
    context: Context,
    message: String,
    cancelable: Boolean,
    cancelListener: DialogInterface.OnCancelListener?
) : AlertDialog(context) {

    private val size: Int = 0
    private var message: CharSequence? = null

    class Builder {
        private var context: Context? = null
        private var message: String = ""
        private var messageId: Int = 0
        private var cancelable = true // default dialog behaviour
        private var cancelListener: DialogInterface.OnCancelListener? = null

        fun setContext(context: Context): Builder {
            this.context = context
            return this
        }

        fun setMessage(message: String): Builder {
            this.message = message
            return this
        }

        fun setMessage(@StringRes messageId: Int): Builder {
            this.messageId = messageId
            return this
        }

        fun setCancelable(cancelable: Boolean): Builder {
            this.cancelable = cancelable
            return this
        }

        fun setCancelListener(cancelListener: DialogInterface.OnCancelListener): Builder {
            this.cancelListener = cancelListener
            return this
        }

        fun build(): AlertDialog {
            return LoadingDialog(
                context!!,
                if (messageId != 0) context!!.getString(messageId) else message,
                cancelable,
                cancelListener
            )
        }
    }

    init {
        this.message = message

        setCancelable(cancelable)
        if (cancelListener != null) setOnCancelListener(cancelListener)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window!!.setBackgroundDrawableResource(android.R.color.transparent)
        setContentView(R.layout.loading_dialog_layout)
        setCanceledOnTouchOutside(false)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun setMessage(message: CharSequence) {
        this.message = message

    }

    companion object {

        private val DELAY = 150
        private val DURATION = 1500
    }

}