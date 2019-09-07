package co.ke.tickett

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.ke.tickett.data.db.entity.Events
import co.ke.tickett.data.repository.EventsRespository
import co.ke.tickett.utils.Coroutines

class ScanViewModel(
    private val repository : EventsRespository
) : ViewModel() {


    private var _currentEvents= MutableLiveData<Events>()



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
}
