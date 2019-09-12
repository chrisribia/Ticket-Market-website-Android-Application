package co.ke.tickett.ui.CodeFragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import co.ke.tickett.CodeViewModel

import co.ke.tickett.R
import co.ke.tickett.databinding.CodeFragmentBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class CodeFragment : Fragment()  , KodeinAware{

    override val kodein by kodein()
    private lateinit var viewModel: CodeViewModel


    private val factory: CodeViewModelFactory by instance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : CodeFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.code_fragment, container, false)
        viewModel = ViewModelProviders.of(this,factory).get(CodeViewModel::class.java)
        binding.viewmodel = viewModel
        return binding.root
    }


}
