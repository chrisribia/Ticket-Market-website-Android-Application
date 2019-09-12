package co.ke.tickett

import androidx.lifecycle.ViewModel
import co.ke.tickett.data.repository.EventsRespository
import co.ke.tickett.data.repository.SummeryRepository
import co.ke.tickett.utils.lazyDeferred

class StatsViewModel(
    private val repository : SummeryRepository
) : ViewModel() {

    val quotes by lazyDeferred {
        repository.getBalance()
    }

}
