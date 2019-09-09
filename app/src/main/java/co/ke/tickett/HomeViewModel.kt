package co.ke.tickett

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import co.ke.tickett.ui.HomeFragment.HomeFragmentDirections

class HomeViewModel : ViewModel() {
fun onCamera(view : View){
    val action = HomeFragmentDirections.actionHomeFragmentToQrFragment()
    Navigation.findNavController(view).navigate(action)
}

}
