package co.ke.tickett

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.ke.tickett.data.db.entity.Events
import co.ke.tickett.data.repository.EventsRespository
import co.ke.tickett.data.repository.SummeryRepository
import co.ke.tickett.utils.Coroutines

class CodeViewModel(private val repository: EventsRespository) :
    ViewModel() {



    private val _employees = MutableLiveData<List<Events>>()

    init {
        Coroutines.io {
            _employees.postValue(
                repository.getEvents()
            )
        }
    }

    val employees: LiveData<List<Events>>
        get() = _employees
    fun fetchTickets(){
        Coroutines.io{
            repository.fetchTickets()
        }
    }

    fun onSearchTextChange(query: CharSequence) {
        Log.d("SQuery", query.toString())
        Coroutines.io {
            if (query.isEmpty()) {
                _employees.postValue(
                    repository.getEvents()
                )
                return@io
            }

            _employees.postValue(
                repository.findEventBycode(query.toString())
            )
        }
    }
}

