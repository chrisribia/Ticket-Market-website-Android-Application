package co.ke.tickett.ui.HomeFragment

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation

class HomeViewModel : ViewModel() {
  fun camera(view : View){
      val action = HomeFragmentDirections.actionHomeFragmentToQrFragment()
      Navigation.findNavController(view).navigate(action)
  }

}
