package co.ke.tickett.ui.HomeFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import co.ke.tickett.data.repository.TicketRepository

class HomeFragmentViewModelFactory(
    private val repository: TicketRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(repository) as T
    }
}