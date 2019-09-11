package co.ke.tickett

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.ke.tickett.data.db.entity.Events
import co.ke.tickett.data.repository.EventsRespository
import co.ke.tickett.ui.login.AuthListener
import co.ke.tickett.utils.Coroutines

class ScanViewModel(
    private val repository : EventsRespository
) : ViewModel() {
    lateinit var qr_code : String

    private var _currentEvents= MutableLiveData<Events>()

    var authListener:AuthListener? = null
    val currentTickets: LiveData<Events>
        get() = _currentEvents




    fun findEmployee(qr: String): LiveData<Events> {
        Coroutines.io{
            repository.fetchTickets()
        }
        val ticket = repository.findEvent(qr)
        ticket.observeForever {
            _currentEvents.postValue(it)
        }
        return ticket
    }

    fun toQrScanner(view: View){
        //val action = ScanFragmentDirections.scannerAction()
        // Navigation.findNavController(view).navigate(action)
    }

    fun confirmTicket(view: View){
        authListener?.onStarted()
        Coroutines.io {
            repository.confirmTicket(qr_code)

        }

    }


}
