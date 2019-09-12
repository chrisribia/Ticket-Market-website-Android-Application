package co.ke.tickett.ui.StatFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders

import co.ke.tickett.R
import co.ke.tickett.StatsViewModel
import co.ke.tickett.databinding.StatsFragmentBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class StatsFragment : Fragment() , KodeinAware {
    override val kodein by kodein()

    private lateinit var viewModel: StatsViewModel

    private val factory: StatsViewModelFactory by instance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : StatsFragmentBinding =  DataBindingUtil.inflate(inflater,R.layout.stats_fragment, container, false)
        viewModel = ViewModelProviders.of(this, factory).get(StatsViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }



}
