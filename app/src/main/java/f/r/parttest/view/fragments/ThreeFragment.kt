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
import f.r.parttest.databinding.FragmentThreeBinding
import f.r.parttest.databinding.FragmentTwoBinding
import f.r.parttest.model.ModelThreeFragment
import f.r.parttest.model.ModelTwoFragment
import f.r.parttest.viewModel.ViewModelThreeFragment
import f.r.parttest.viewModel.ViewModelTwoFragment


import javax.inject.Inject

@AndroidEntryPoint
class ThreeFragment : Fragment() {

    private lateinit var binding: FragmentThreeBinding
    private val viewModel: ViewModelThreeFragment by viewModels()

    @Inject
    lateinit var model: ModelThreeFragment

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
            R.layout.fragment_three,
            container,
            false
        )

        model = ModelThreeFragment()
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }



}