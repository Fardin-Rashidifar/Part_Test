package f.r.parttest.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import f.r.parttest.dataClass.ResponseUserList


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiPresenter @Inject constructor() {

    @Inject
    lateinit var api: ApiServices

    suspend fun getUserList(): Response<ResponseUserList> =
        api.getApi().getUserList()



}