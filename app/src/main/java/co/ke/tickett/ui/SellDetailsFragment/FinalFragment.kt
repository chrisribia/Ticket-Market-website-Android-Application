package co.ke.tickett.ui.SellDetailsFragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import co.ke.tickett.FinalViewModel

import co.ke.tickett.R
import co.ke.tickett.databinding.FinalFragmentBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class FinalFragment : Fragment(), KodeinAware {
    override val kodein by kodein()
    private lateinit var viewModel: FinalViewModel
    private val factory: FinalViewModelFactory by instance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FinalFragmentBinding =    DataBindingUtil.inflate(inflater,R.layout.final_fragment, container, false)
        viewModel = ViewModelProviders.of(this,factory).get(FinalViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        return binding.root

    }



}
