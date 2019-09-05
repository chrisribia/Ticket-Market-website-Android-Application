package co.ke.tickett

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import co.ke.tickett.data.db.entity.Tickets
import co.ke.tickett.data.repository.TicketRepository
import co.ke.tickett.utils.Coroutines

class HomeFragmentViewModel(
    private val repository: TicketRepository
) : ViewModel() {

 
    private var _currentTicket= MutableLiveData<Tickets>()



    val currentTickets: LiveData<Tickets>
        get() = _currentTicket


    fun findEmployee(qr: String): LiveData<Tickets> {
        Coroutines.io{
            repository.fetchTickets()
        }
        val ticket = repository.findTicket(qr)
        ticket.observeForever {
            _currentTicket.postValue(it)
        }
        return ticket
    }
}
