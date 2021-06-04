package me.twc.easyphotox

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.huantansheng.easyphotos.Builder.AlbumBuilder
import com.huantansheng.easyphotos.EasyPhotos
import com.huantansheng.easyphotos.engine.ImageEngine
import com.huantansheng.easyphotos.models.album.entity.Photo
import com.huantansheng.easyphotos.ui.EasyPhotosActivity

/**
 * @author 唐万超
 * @date 2021/06/04
 */

class EasyPhotosActivityX {

    data class Output(
        /**
         * 用户选择的图片集合
         */
        val list: List<Photo> = emptyList(),
        /**
         * 是否选择了原图
         */
        val original: Boolean = false
    )

    /**
     * 启动图片选择合约
     */
    class PhotoContract : ActivityResultContract<AlbumBuilder, Output?>() {
        override fun createIntent(context: Context, input: AlbumBuilder): Intent {
            input.setSettingParamsReflex()
            return Intent(context, EasyPhotosActivity::class.java)
        }

        override fun parseResult(resultCode: Int, intent: Intent?): Output? {
            val photos: ArrayList<Photo>? =
                intent?.getParcelableArrayListExtra(EasyPhotos.RESULT_PHOTOS)
            val original: Boolean? =
                intent?.getBooleanExtra(EasyPhotos.RESULT_SELECTED_ORIGINAL, false)
            if (photos != null && original != null) {
                return Output(photos, original)
            }
            return null
        }
    }
}

