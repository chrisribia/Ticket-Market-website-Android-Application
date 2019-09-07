package co.ke.tickett.ui.ScannFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import co.ke.tickett.ScanViewModel
import co.ke.tickett.data.repository.EventsRespository


@Suppress("UNCHECKED_CAST")
class ScanViewModelFactory(
    private val repository: EventsRespository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ScanViewModel(repository) as T
    }
}