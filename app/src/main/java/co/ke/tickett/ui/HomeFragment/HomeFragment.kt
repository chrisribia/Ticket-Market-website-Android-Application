package co.ke.tickett.ui.HomeFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import co.ke.tickett.HomeFragmentViewModel

import co.ke.tickett.R
import co.ke.tickett.databinding.HomeFragmentBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class HomeFragment : Fragment(), KodeinAware {
    override val kodein by kodein()



    private lateinit var viewModel: HomeFragmentViewModel

    private val factory: HomeFragmentViewModelFactory by instance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding: HomeFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        viewModel = ViewModelProviders.of(this, factory).get(HomeFragmentViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }


}
