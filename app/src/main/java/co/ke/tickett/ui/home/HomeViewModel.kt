package co.ke.tickett.ui.home

import androidx.lifecycle.ViewModel
import co.ke.tickett.data.repository.UserRepository


class HomeViewModel(
    private val repository: UserRepository
) : ViewModel() {

    fun logout() = repository.logout()

}