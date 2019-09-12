package co.ke.tickett.ui.SellDetailsFragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import co.ke.tickett.R

class FinalFragment : Fragment() {

    companion object {
        fun newInstance() = FinalFragment()
    }

    private lateinit var viewModel: FinalViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.final_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FinalViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
