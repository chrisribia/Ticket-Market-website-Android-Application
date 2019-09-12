package co.ke.tickett.ui.CodeFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import co.ke.tickett.CodeViewModel
import co.ke.tickett.data.repository.EventsRespository
import co.ke.tickett.data.repository.SummeryRepository

class CodeViewModelFactory(private val repository: SummeryRepository):
ViewModelProvider.NewInstanceFactory()
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CodeViewModel(repository) as T
    }
}