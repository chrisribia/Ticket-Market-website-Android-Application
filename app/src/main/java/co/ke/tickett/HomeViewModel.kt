package co.ke.tickett

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import co.ke.tickett.ui.HomeFragment.HomeFragmentDirections

class HomeViewModel : ViewModel() {
fun onCamera(view : View){
    val action = HomeFragmentDirections.actionHomeFragmentToScanFragment()
    Navigation.findNavController(view).navigate(action)
}

    fun onEnterCOde(view : View){
        val action = HomeFragmentDirections.actionHomeFragmentToCodeFragment()
        Navigation.findNavController(view).navigate(action)
    }

}
