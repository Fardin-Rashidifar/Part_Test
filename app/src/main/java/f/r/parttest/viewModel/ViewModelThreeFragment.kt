package f.r.parttest.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import f.r.parttest.model.ModelThreeFragment
import javax.inject.Inject

@HiltViewModel
class ViewModelThreeFragment @Inject constructor(
    @ApplicationContext
    private val context: Context,
    private val model: ModelThreeFragment
) : ViewModel() {
}