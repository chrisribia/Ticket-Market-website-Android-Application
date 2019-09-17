package co.ke.tickett.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import co.ke.tickett.R
import co.ke.tickett.ui.login.LoginActivity
import co.ke.tickett.utils.Coroutines
import kotlinx.android.synthetic.main.activity_home.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class HomeActivity : AppCompatActivity(), KodeinAware {
    override val kodein by kodein()
    private val factory: HomeViewModelFactory  by instance()



    private lateinit var navController: NavController
    private lateinit var viewModel: HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        viewModel = ViewModelProviders.of(this, factory).get(HomeViewModel::class.java)

        val navController = Navigation.findNavController(this,R.id.fragment)
        NavigationUI.setupWithNavController(nav_view,navController)

        NavigationUI.setupActionBarWithNavController(this,navController,drawer_layout)

    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            Navigation.findNavController(this,R.id.fragment),
            drawer_layout
        )
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_logout -> {
                AlertDialog.Builder(this).also { alertDialogBuilder ->
                    alertDialogBuilder.setTitle("Are you sure you want to Logout?")
                    alertDialogBuilder.setPositiveButton("Yes") { _, _ ->
                        Coroutines.io{
                            viewModel.logout()
                            Intent(this@HomeActivity, LoginActivity::class.java).also {
                                it.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                                startActivity(it)
                            }
                        }

                    }
                    alertDialogBuilder.setNegativeButton("Cancel") { _, _ -> }
                }.create().show()
                return true
            }
            else -> {
                return false
            }
        }
    }
}
