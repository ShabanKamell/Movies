package com.movie.app.shared.util.picasso

import android.graphics.drawable.Drawable
import android.net.Uri
import android.text.TextUtils
import android.widget.ImageView
import com.movie.app.shared.util.CrashlyticsUtil
import com.movie.app.shared.util.app.MyApp
import com.squareup.picasso.Callback
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import okhttp3.OkHttpClient
import org.koin.java.KoinJavaComponent
import java.io.File

/**
 * Created by sha on 03/01/17.
 */

class PicassoUtil {

    companion object {

        fun load(
                url: String?,
                iv: ImageView,
                placeholder: Drawable? = null,
                isRound: Boolean = false,
                fromFile: Boolean = false
        ) {
            try {
                if (TextUtils.isEmpty(url)) {
                    iv.setImageDrawable(null)
                    return
                }

                val picasso = Picasso
                        .Builder(MyApp.context)
                        .downloader(OkHttp3Downloader(KoinJavaComponent.get(OkHttpClient::class.java)))
                        .build()

                val creator = if (fromFile)
                    picasso.load(Uri.fromFile(File(url)))
                else
                    picasso.load(url)

                if (isRound) creator.transform(CircleTransform())

                if (placeholder != null) creator.error(placeholder)


                creator.into(
                        iv,
                         object: Callback {
                             override fun onError(e: Exception?) {
                                 e?.printStackTrace()
                             }

                             override fun onSuccess() {

                             }
                         })

            } catch (e: Exception) {
                e.printStackTrace()
                CrashlyticsUtil.log(e)
            }

        }

        fun round(
                iv: ImageView,
                url: String?,
                placeholder: Drawable? = null
        ) {
            load(url,
                    iv,
                    placeholder,
                    true
            )
        }

    }
}
