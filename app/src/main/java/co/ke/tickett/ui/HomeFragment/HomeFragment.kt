package co.ke.tickett.ui.HomeFragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import co.ke.tickett.HomeViewModel

import co.ke.tickett.R
import co.ke.tickett.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: HomeFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.home_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        //scanFromFragment()
        return binding.root
    }



}
