package com.movie.app.shared.util

/**
 * Created by Sha on 10/15/17.
 */

object CrashlyticsUtil {

    fun log(throwable: Throwable) {
        // In production we must uncomment
//        Crashlytics.getInstance().core.logException(throwable)
    }

    fun logAndPrint(throwable: Throwable) {
        // In production we must uncomment
//        throwable.printStackTrace()
//        Crashlytics.getInstance().core.logException(throwable)
    }

    fun logAndPrint(msg: String) {
        // In production we must uncomment
//        Crashlytics.getInstance().core.logException(Throwable(msg))
    }
}
