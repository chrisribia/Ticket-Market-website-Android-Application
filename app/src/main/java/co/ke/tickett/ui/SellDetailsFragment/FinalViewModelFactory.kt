package co.ke.tickett.ui.SellDetailsFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import co.ke.tickett.FinalViewModel
import co.ke.tickett.data.repository.SellRepository

class FinalViewModelFactory(  private val repository: SellRepository): ViewModelProvider.NewInstanceFactory()

{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FinalViewModel(repository) as T
    }
}