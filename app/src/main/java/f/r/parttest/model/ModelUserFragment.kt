package f.r.parttest.model

import androidx.lifecycle.LiveData
import f.r.parttest.dataClass.Data
import f.r.parttest.local.db.AppDatabase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ModelUserFragment  @Inject constructor(){
    @Inject
    lateinit var db: AppDatabase

    fun getAllUsers(): LiveData<List<Data>> {
        val userListDao = db.userListDao()
        return userListDao.getAllUsers()
    }
}