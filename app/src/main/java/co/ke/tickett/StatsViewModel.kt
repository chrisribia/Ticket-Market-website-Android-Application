package co.ke.tickett

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.ke.tickett.data.db.entity.Stats
import co.ke.tickett.data.repository.EventsRespository
import co.ke.tickett.utils.Coroutines

class StatsViewModel(
    private val repository : EventsRespository
) : ViewModel() {

    private var _currentBalance= MutableLiveData<Stats>()

    val currentBalance: LiveData<Stats>
        get() = _currentBalance






    fun findEmployee(): LiveData<Stats> {
        Coroutines.io{
            repository.fetchTicketBalance()
        }
        val bal = repository.getbalance()
        bal.observeForever {
            _currentBalance.postValue(it)
        }
        return bal
    }
}
