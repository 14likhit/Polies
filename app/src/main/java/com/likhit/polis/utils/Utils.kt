package com.likhit.polis.utils

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.view.View
import android.view.inputmethod.InputMethodManager

import java.net.URI
import java.net.URISyntaxException

object Utils {

    fun pxToDp(context: Context, px: Float): Float {
        return px / context.resources.displayMetrics.density
    }

    fun dpToPx(context: Context, dp: Float): Float {
        return dp * context.resources.displayMetrics.density
    }

    /**
     * Checks for network connection
     *
     * @param context->For fetching context
     * @return ->true/false
     */
    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo !=
                null && activeNetworkInfo.isConnected
    }

    fun hideSoftKeyboard(activity: Activity) {
        val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        var focusView = activity.currentFocus
        if (focusView == null) {
            focusView = View(activity)
        }
        imm.hideSoftInputFromWindow(focusView.windowToken, 0)
    }

    fun getUrlWithoutParameters(url: String): String {
        try {
            val uri = URI(url)
            return URI(uri.scheme,
                    uri.authority,
                    uri.path, null, // Ignore the query part of the input url
                    uri.fragment).toString()
        } catch (e: URISyntaxException) {
            return url
        }

    }


}
