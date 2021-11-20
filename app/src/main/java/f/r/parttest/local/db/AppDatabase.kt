package f.r.parttest.local.db

import android.service.autofill.UserData
import androidx.room.Database
import androidx.room.RoomDatabase
import f.r.parttest.BuildConfig
import f.r.parttest.dataClass.Data
import f.r.parttest.local.db.dao.UserDAO

@Database(entities = [Data::class], version = BuildConfig.VERSION_CODE)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userListDao(): UserDAO

}