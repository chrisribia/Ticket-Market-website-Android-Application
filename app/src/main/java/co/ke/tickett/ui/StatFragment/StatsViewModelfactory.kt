package co.ke.tickett.ui.StatFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import co.ke.tickett.StatsViewModel
import co.ke.tickett.data.repository.EventsRespository
import co.ke.tickett.data.repository.SummeryRepository

@Suppress("UNCHECKED_CAST")
class StatsViewModelFactory(
    private val repository: SummeryRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return StatsViewModel(repository) as T
    }
}