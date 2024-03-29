package me.twc.easyphotox.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.huantansheng.easyphotos.Builder.AlbumBuilder
import com.huantansheng.easyphotos.setting.Setting
import me.twc.easyphotox.EasyPhotosActivityX
import me.twc.easyphotox.demo.databinding.ActMainBinding
import me.twc.easyphotox.setFileProviderAuthorityX

/**
 * @author 唐万超
 * @date 2021/06/04
 */


class MainActivity : AppCompatActivity() {

    private val mBinding by lazy { ActMainBinding.inflate(layoutInflater) }
    private val mPhotosLauncher = registerForActivityResult(EasyPhotosActivityX.PhotoContract()) {
        logD("output is $it")
    }
    private val mVideosLauncher = registerForActivityResult(EasyPhotosActivityX.PhotoContract()){
        logD("output is $it")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)

        mBinding.photos.setOnClickListener {
            mPhotosLauncher.launch(newAlbumBuilder())
        }

        mBinding.videos.setOnClickListener {
            mVideosLauncher.launch(newVideoAlbumBuilder())
        }
    }

    private fun newAlbumBuilder() = AlbumBuilder
        .createAlbum(this, true, GlideImageEngine)
        .setCameraLocation(Setting.LIST_FIRST)
        .setCount(6)
        .setCleanMenu(false)
        .setFileProviderAuthorityX(this)

    private fun newVideoAlbumBuilder() = AlbumBuilder
        .createAlbum(this, true, GlideImageEngine)
        .onlyVideo()
        .setCount(2)
        .setVideoMinSecond(3)
        .setVideoMaxSecond(30)
        .setCleanMenu(false)
        .setFileProviderAuthorityX(this)
}