package co.ke.tickett.ui

import android.view.View
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {

    var email : String? = null
    var password : String? = null
    var authListener : AuthListener? = null

    fun onlogin(view : View){
        authListener?.onStarted("welcome")
        if (email.isNullOrEmpty() || password.isNullOrEmpty()){
            authListener?.onFailure("failed")
            return
        }
        authListener?.onSuccess("success")
    }

}