package f.r.parttest.model

import androidx.lifecycle.LiveData
import f.r.parttest.dataClass.Data
import f.r.parttest.dataClass.ResponseUserList
import f.r.parttest.local.db.AppDatabase
import f.r.parttest.remote.ApiPresenter
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ModelMainActivity  @Inject constructor(){
    @Inject
    lateinit var apiPresenter: ApiPresenter

    @Inject
    lateinit var db: AppDatabase

    suspend fun getUserList(): Response<ResponseUserList> {
        return apiPresenter.getUserList()
    }
    suspend fun saveUserInDb(data: List<Data>): List<Long> {
        val userListDAO = db.userListDao()
        return userListDAO.insert(data)
    }
    fun getAllUsers(): LiveData<List<Data>> {
        val userListDao = db.userListDao()
        return userListDao.getAllUsers()
    }

}