package f.r.parttest.androidWrapper

import android.app.Application

import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class G : Application() {
    companion object {
        lateinit var instance: G
    }

    override fun onCreate() {
        super.onCreate()


        instance = this

    }
}