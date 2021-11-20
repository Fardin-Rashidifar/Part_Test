package f.r.parttest.helper

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Build
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageDownloader @Inject constructor() {

    fun initGlide(context: Context, uri: String, image: ImageView) {
        Glide
            .with(context)
            .load(uri)
            .into(image)
        // .placeholder(R.id.)
        //.error()
    }

    companion object{
        fun initGlideForImage(activity: Activity, uri: String, img: ImageView) {
            Glide.with(activity).load(
                uri
            ).into(object : SimpleTarget<Drawable?>() {
                override fun onResourceReady(
                    resource: Drawable,
                    transition: Transition<in Drawable?>?
                ) {
                    Glide.with(activity).asBitmap()
                        .load(
                            uri
                        ).into(object : CustomTarget<Bitmap?>() {
                            override fun onResourceReady(
                                resource: Bitmap,
                                transition: Transition<in Bitmap?>?
                            ) {
                                img.setImageBitmap(resource)
                            }

                            override fun onLoadCleared(placeholder: Drawable?) {

                            }

                        })


                }
            })
        }

    }

}