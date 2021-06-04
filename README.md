# EasyPhotosX

EasyPhotosX 是 [EasyPhotos](https://github.com/HuanTanSheng/EasyPhotos) 友好拓展

# 特点

- 自带 FileProvider(通过 setFileProviderAuthorityX 设置自带FileProvider)
- 支持 ActivityResultContract

# 使用

```kotlin
private val mPhotosLauncher = registerForActivityResult(EasyPhotosActivityX.PhotoContract()) {
    logD("output is $it")
}
```