package me.twc.easyphotox.demo

import android.util.Log

/**
 * @author 唐万超
 * @date 2021/06/04
 */
private const val TAG = "EASY_PHOTO_X_LOG"

fun logD(message: String, th: Throwable? = null) {
    Log.d(TAG, message, th)
}