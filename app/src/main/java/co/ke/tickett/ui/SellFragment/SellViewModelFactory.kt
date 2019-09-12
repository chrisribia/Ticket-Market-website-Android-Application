package co.ke.tickett.ui.SellFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import co.ke.tickett.data.repository.SellRepository

@Suppress("UNCHECKED_CAST")
class SellViewModelFactory(
    private val repository: SellRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SellViewModel(repository) as T
    }
}