package co.ke.tickett.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import co.ke.tickett.data.repository.UserRepository
import co.ke.tickett.ui.AuthViewModel

class HomeViewModelFactory(
    private val repository: UserRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(repository) as T
    }
}