package com.movie.app.shared.util

import com.movie.app.BuildConfig

/**
 * Created by Sha on 11/20/17.
 */

class BuildUtil {

    interface Type {
        companion object {
            val RELEASE = "release"
            val DEBUG = "debug"

        }
    }

    companion object {
        fun isDebug() = BuildConfig.BUILD_TYPE == Type.DEBUG
    }


    }
