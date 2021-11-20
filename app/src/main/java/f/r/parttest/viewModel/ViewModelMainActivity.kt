package f.r.parttest.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import f.r.parttest.androidWrapper.G
import f.r.parttest.dataClass.Data
import f.r.parttest.helper.Utils
import f.r.parttest.model.ModelMainActivity
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.util.HashMap
import javax.inject.Inject

@HiltViewModel
class ViewModelMainActivity  @Inject constructor(
    @ApplicationContext
    private val context: Context,
    private val model: ModelMainActivity
) : ViewModel() {

    private val areInserted = MutableLiveData<Boolean>()
    val areInsertedPublic: LiveData<Boolean>
        get() = areInserted

    fun getUserList() = viewModelScope.launch {
        if (Utils.isOnline(G.instance) && getAllUsers().value?.size == 0) {
            val response = model.getUserList()
            val data = response.body()
            if (data != null) {
                    val isUserListInserted =
                        async { model.saveUserInDb(data.data) }
                isUserListInserted.await()
                    areInserted.value = true

            }
        }else{
            areInserted.value = true
        }
    }

    fun getAllUsers(): LiveData<List<Data>> {
        return model.getAllUsers()
    }

}