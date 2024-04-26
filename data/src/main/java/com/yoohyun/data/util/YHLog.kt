package com.yoohyun.data.util

import android.util.Log
import com.yoohyun.data.BuildConfig

object YHLog {
    private const val postTag = "YH"
    private const val tag = "OPEN_WEATHER_$postTag"
    var debugBuild = BuildConfig.DEBUG
    private const val verbose = 1
    private const val debug = 2
    private const val info = 3
    private const val warn = 4
    private const val error = 5
    private const val noLog = 6
    private var msgLevel = warn
    private var applyProguard = false
    private const val useOneTag = false

    fun setLogMsgStyle(logMsgLevel: Int, proguardMsgStyle: Boolean) {
        msgLevel = logMsgLevel
        applyProguard = proguardMsgStyle
    }

    fun x(tag: String?, msg: String?) {
        // 빈 함수로 구현
    }

    fun v(tag: String, msg: String) {
        if (verbose < msgLevel && !debugBuild) return
        val ste = Throwable().stackTrace
        val totalMsg = makeMsg(msg, ste)
        if (useOneTag) {
            Log.v(this.tag, totalMsg)
        } else {
            Log.v("$tag$postTag", totalMsg)
        }
    }

    fun d(tag: String, msg: String) {
        if (debug < msgLevel && !debugBuild) return
        val ste = Throwable().stackTrace
        val totalMsg = makeMsg(msg, ste)
        if (useOneTag) {
            Log.d(this.tag, totalMsg)
        } else {
            Log.d("$tag$postTag", totalMsg)
        }
    }

    fun i(tag: String, msg: String) {
        if (info < msgLevel && !debugBuild) return
        val ste = Throwable().stackTrace
        val totalMsg = makeMsg(msg, ste)
        if (useOneTag) {
            Log.i(this.tag, totalMsg)
        } else {
            Log.i("$tag$postTag", totalMsg)
        }
    }

    fun w(tag: String, msg: String) {
        if (warn < msgLevel && !debugBuild) return
        val ste = Throwable().stackTrace
        val totalMsg = makeMsg(msg, ste)
        if (useOneTag) {
            Log.w(this.tag, totalMsg)
        } else {
            Log.w("$tag$postTag", totalMsg)
        }
    }

    fun e(tag: String, msg: String) {
        if (error < msgLevel && !debugBuild) return
        val ste = Throwable().stackTrace
        val totalMsg = makeMsg(msg, ste)
        if (useOneTag) {
            Log.e(this.tag, totalMsg)
        } else {
            Log.e("$tag$postTag", totalMsg)
        }
    }

    private fun makeMsg(msg: String, ste: Array<StackTraceElement>): String {
        var strMsg = ""
        if (applyProguard) {
            strMsg += String.format(
                " at %s.%s(%s:%d)\n",
                ste[1].className,
                ste[1].methodName,
                ste[1].fileName,
                ste[1].lineNumber
            )
        }
        strMsg += String.format(
            "      [%s:%d]   [%s()]   [%s]",
            ste[1].fileName,
            ste[1].lineNumber,
            ste[1].methodName,
            msg
        )
        return strMsg
    }
}
