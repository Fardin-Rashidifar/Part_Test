package f.r.parttest.helper

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Utils @Inject constructor(){

    companion object{
        fun isOnline(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val netInfo = cm.activeNetworkInfo
            return if (netInfo != null && netInfo.isConnectedOrConnecting) {
                true
            } else {
                Toast.makeText(
                    context,
                    "the device is not connected to the internet", Toast.LENGTH_LONG
                )
                    .show()
                false
            }
        }
    }
}