package f.r.parttest.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels

import dagger.hilt.android.AndroidEntryPoint
import f.r.parttest.R
import f.r.parttest.databinding.FragmentTwoBinding
import f.r.parttest.model.ModelTwoFragment
import f.r.parttest.viewModel.ViewModelTwoFragment


import javax.inject.Inject

@AndroidEntryPoint
class TwoFragment : Fragment() {

    private lateinit var binding: FragmentTwoBinding
    private val viewModel: ViewModelTwoFragment by viewModels()

    @Inject
    lateinit var model: ModelTwoFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_two,
            container,
            false
        )

        model = ModelTwoFragment()
        binding.lifecycleOwner = this



        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }



}