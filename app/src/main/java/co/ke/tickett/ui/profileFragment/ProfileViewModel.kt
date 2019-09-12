package co.ke.tickett.ui.profileFragment

import androidx.lifecycle.ViewModel;
import co.ke.tickett.data.repository.UserRepository

class ProfileViewModel(
    repository: UserRepository
) : ViewModel() {

    val user = repository.getUser()

}
