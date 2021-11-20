package f.r.parttest.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import f.r.parttest.dataClass.Data
import f.r.parttest.model.ModelTwoFragment
import f.r.parttest.model.ModelUserFragment
import javax.inject.Inject

@HiltViewModel
class ViewModelUserFragment @Inject constructor(
    @ApplicationContext
    private val context: Context,
    private val model: ModelUserFragment
) : ViewModel() {

    fun getAllUsers(): LiveData<List<Data>> {
        return model.getAllUsers()
    }
}