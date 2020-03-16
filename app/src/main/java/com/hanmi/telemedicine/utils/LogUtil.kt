import android.util.Log

/**
 * 日志工具类
 */
class LogUtil {
    init {
        throw UnsupportedOperationException("can not be instantiated")
    }

    companion object {
        private const val TAG = "Telemedicine"

        /**
         * 是否需要打印日志，最好在application的onCreate方法中初始化
         * true：打印日志
         * false：不打印日志
         * 测试环境设置为true，线上环境设置为false
         */
        var isDebug = true

        @JvmStatic
        fun i(msg: String) {
            if (isDebug) {
                Log.i(TAG, msg)
            }
        }

        @JvmStatic
        fun d(msg: String) {
            if (isDebug) {
                Log.d(TAG, msg)
            }
        }

        @JvmStatic
        fun e(msg: String) {
            if (isDebug) {
                Log.e(TAG, msg)
            }
        }

        @JvmStatic
        fun v(msg: String) {
            if (isDebug) {
                Log.v(TAG, msg)
            }
        }

        // 下面是传入自定义tag的函数
        @JvmStatic
        fun i(tag: String, msg: String) {
            if (isDebug) {
                Log.i(tag, msg)
            }
        }

        @JvmStatic
        fun d(tag: String, msg: String) {
            if (isDebug) {
                Log.d(tag, msg)
            }
        }

        @JvmStatic
        fun e(tag: String, msg: String) {
            if (isDebug) {
                Log.e(tag, msg)
            }
        }

        @JvmStatic
        fun v(tag: String, msg: String) {
            if (isDebug) {
                Log.v(tag, msg)
            }
        }
    }
}
