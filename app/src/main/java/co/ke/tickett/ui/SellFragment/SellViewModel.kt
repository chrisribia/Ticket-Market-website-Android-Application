package co.ke.tickett.ui.SellFragment

import androidx.lifecycle.ViewModel
import co.ke.tickett.data.repository.SellRepository
import co.ke.tickett.utils.lazyDeferred

class SellViewModel(
    private val repository :SellRepository)
    : ViewModel() {


    val quotes by lazyDeferred {
        repository.getBalance()
    }

}
