package co.ke.tickett.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import co.ke.tickett.R
import co.ke.tickett.databinding.ActivityLoginBinding
import co.ke.tickett.utils.toast

class LoginActivity : AppCompatActivity(), AuthListener{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val binding : ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.authListener = this


    }


    override fun onStarted(message: String) {
        toast(message)
    }

    override fun onSuccess(message: String) {
        toast(message)
    }

    override fun onFailure(message: String) {
        toast(message)
    }
}
