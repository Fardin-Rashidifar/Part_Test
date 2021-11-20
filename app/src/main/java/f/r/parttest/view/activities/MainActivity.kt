package f.r.parttest.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import f.r.parttest.R
import f.r.parttest.databinding.ActivityMainBinding
import f.r.parttest.model.ModelMainActivity
import f.r.parttest.viewModel.ViewModelMainActivity
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var bottomNavigationView: BottomNavigationView

    private val viewModel: ViewModelMainActivity by viewModels()

    @Inject
    lateinit var model: ModelMainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        bottomNavigationView = binding.bottomNavigation

        viewModel.getUserList()
        viewModel.areInsertedPublic.observe(this,{
            setUpNavigation()
        })
    }

    private fun setUpNavigation() {
        bottomNavigationView.post { // wait for NavHostFragment to inflate
            val navController = findNavController(R.id.container)
            val options = NavOptions.Builder()
                .setLaunchSingleTop(true)
                .setEnterAnim(R.anim.push_down_in)
                .setExitAnim(R.anim.push_down_out)
                .setPopEnterAnim(R.anim.push_up_in)
                .setPopExitAnim(R.anim.push_up_out)
                .setPopUpTo(navController.graph.startDestination, false)
                .build()
            bottomNavigationView.setupWithNavController(navController)
            bottomNavigationView.setOnNavigationItemSelectedListener { item: MenuItem ->
                //navController.navigate(item.itemId)
                when (item.itemId) {
                    R.id.user -> {
                        navController.navigate(R.id.user, null, options)
                    }
                    R.id.two -> {
                        navController.navigate(R.id.two, null, options)
                    }
                    R.id.three -> {
                        navController.navigate(R.id.three, null, options)
                    }
                }
                true
            }
            bottomNavigationView.setOnNavigationItemReselectedListener { item ->
                return@setOnNavigationItemReselectedListener
            }
        }
    }
}