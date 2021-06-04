package me.twc.easyphotox

import android.content.Context
import com.huantansheng.easyphotos.Builder.AlbumBuilder
/**
 * @author 唐万超
 * @date 2021/06/03
 *
 * @see [AlbumBuilder]
 */

fun AlbumBuilder.setSettingParamsReflex(){
    val javaClass = this.javaClass
    val method = javaClass.getDeclaredMethod("setSettingParams")
    method.isAccessible = true
    method.invoke(this)
}

fun AlbumBuilder.setFileProviderAuthorityX(context:Context):AlbumBuilder{
    return this.setFileProviderAuthority("${context.packageName}.easyphotox.provider")
}


