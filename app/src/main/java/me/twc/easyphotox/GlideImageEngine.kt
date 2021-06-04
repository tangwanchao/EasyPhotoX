package me.twc.easyphotox

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.huantansheng.easyphotos.engine.ImageEngine

/**
 * @author 唐万超
 * @date 2021/06/04
 */
object GlideImageEngine : ImageEngine {
    override fun loadPhoto(context: Context, uri: Uri, imageView: ImageView) {
        Glide.with(context)
            .load(uri)
            .into(imageView)
    }

    override fun loadGifAsBitmap(context: Context, gifUri: Uri, imageView: ImageView) {
        Glide.with(context)
            .asBitmap()
            .load(gifUri)
            .into(imageView)
    }

    override fun loadGif(context: Context, gifUri: Uri, imageView: ImageView) {
        Glide.with(context)
            .asGif()
            .load(gifUri)
            .into(imageView)

    }

    override fun getCacheBitmap(context: Context, uri: Uri, width: Int, height: Int): Bitmap? = null
}