package co.ke.tickett

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import co.ke.tickett.data.db.entity.Sell
import co.ke.tickett.data.repository.SellRepository
import co.ke.tickett.ui.SellDetailsFragment.FinalFragmentDirections
import co.ke.tickett.ui.login.AuthListener
import co.ke.tickett.utils.ApiException
import co.ke.tickett.utils.Coroutines
import co.ke.tickett.utils.NoInternetException
import java.util.*

class FinalViewModel(private val repository : SellRepository)
    : ViewModel() {
 var authListener : AuthListener? = null

    private var _currentQuote= MutableLiveData<Sell>()



    val currentEmployee: LiveData<Sell>
        get() = _currentQuote



    fun findEmployee(id: String): LiveData<Sell> {
        val employee = repository.getDetailsForSale(id)
        employee.observeForever {
            _currentQuote.postValue(it)
        }
        return employee
    }



    var event_name : String? = null
    var event_type : String? = null
    var phone : String? = null
    var email : String? = null
    var code : String = Random().nextInt((8000-10) + 10).toString()

    fun mToast(view: View) {
        if (event_name.isNullOrEmpty() ||
            event_type.isNullOrEmpty() ||
            phone.isNullOrEmpty() ||
            email.isNullOrEmpty() ||
            code.isNullOrEmpty()
        ) {
            
            authListener?.onFailure("please fill all details !!")
            return
        }
        Coroutines.main {
            try {

                val response =
                    repository.makeSales(event_name!!, event_type!!, phone!!, email!!, code)
                    response?.let {
                    val action = FinalFragmentDirections.actionFinalFragmentToSellFragment()
                    Navigation.findNavController(view).navigate(action)


                }
                authListener?.onFailure(response.message!!)
            } catch (e: ApiException) {
                authListener?.onFailure(e.message!!)
            } catch (e: NoInternetException) {
                authListener?.onFailure(e.message!!)
            }

        }
    }

}
