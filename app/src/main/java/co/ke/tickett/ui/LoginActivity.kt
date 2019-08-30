package co.ke.tickett.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import co.ke.tickett.R
import co.ke.tickett.data.db.entity.User
import co.ke.tickett.databinding.ActivityLoginBinding
import co.ke.tickett.ui.home.HomeActivity
import co.ke.tickett.utils.toast
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance
class LoginActivity : AppCompatActivity(), AuthListener,KodeinAware{

    override val kodein by kodein()
    private val factory : AuthViewModelFactory by instance()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val binding : ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this,factory).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.authListener = this

        viewModel.getLoggedInUser().observe(this, Observer { user ->
            if(user != null){
                Intent(this, HomeActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
        })
    }


    override fun onStarted(message: String) {
        toast(message)
    }

    override fun onSuccess(user: User) {

    }

    override fun onFailure(message: String) {
        toast(message)
    }
}
