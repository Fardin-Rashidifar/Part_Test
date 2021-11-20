package f.r.parttest.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import f.r.parttest.R
import f.r.parttest.adapter.UserListAdapter
import f.r.parttest.dataClass.Data
import f.r.parttest.databinding.FragmentUserBinding
import f.r.parttest.model.ModelUserFragment
import f.r.parttest.viewModel.ViewModelUserFragment
import kotlinx.android.synthetic.main.fragment_user.*


import java.util.HashMap
import javax.inject.Inject

@AndroidEntryPoint
class UserFragment : Fragment() {

    private lateinit var binding: FragmentUserBinding
    private val viewModel: ViewModelUserFragment by viewModels()

    @Inject
    lateinit var model: ModelUserFragment

    lateinit var adapter: UserListAdapter




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
            R.layout.fragment_user,
            container,
            false
        )

        model = ModelUserFragment()
        binding.lifecycleOwner = this



        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getAllUsers().observe(viewLifecycleOwner, {
            if (it != null) {
                initRecyclerView(it as ArrayList<Data>)

            }
        })
    }


    fun initRecyclerView(userList: ArrayList<Data>) {
        adapter = UserListAdapter(requireActivity(),userList)
        binding.recCircles.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        binding.recCircles.adapter = adapter
    }
}