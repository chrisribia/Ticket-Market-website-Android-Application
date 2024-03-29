package co.ke.tickett.ui.login

import android.view.View
import androidx.lifecycle.ViewModel
import co.ke.tickett.data.repository.UserRepository
import co.ke.tickett.utils.ApiException
import co.ke.tickett.utils.Coroutines
import co.ke.tickett.utils.NoInternetException

class AuthViewModel(
    private val repository: UserRepository
) : ViewModel() {

    var email : String? = null
    var password : String? = null
    var authListener : AuthListener? = null

    fun getLoggedInUser() = repository.getUser()


    fun onlogin(view: View){
        authListener?.onStarted()
        if(email.isNullOrEmpty() || password.isNullOrEmpty()){
            authListener?.onFailure("Invalid email or password")
            return
        }

        Coroutines.main {
            try {
                val authResponse = repository.userLogin(email!!, password!!)
                authResponse.user?.let {
                    authListener?.onSuccess(it)
                    repository.saveUser(it)
                    return@main
                }
                authListener?.onFailure(authResponse.message!!)
            }catch(e: ApiException){
                authListener?.onFailure(e.message!!)
            }catch (e: NoInternetException){
                authListener?.onFailure(e.message!!)
            }
        }

    }

}