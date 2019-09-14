package co.ke.tickett.ui.CodeConfirm

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import co.ke.tickett.CodeConfirmViewModel

import co.ke.tickett.R
import co.ke.tickett.data.db.entity.Events
import co.ke.tickett.databinding.CodeConfirmFragmentBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class CodeConfirmFragment : Fragment(),KodeinAware {

    override val kodein by kodein()


    private lateinit var viewModel: CodeConfirmViewModel
    var eventz : Events? = null
    private val factory: CodeConfirmViewModelFactory by instance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : CodeConfirmFragmentBinding =DataBindingUtil.inflate(inflater,R.layout.code_confirm_fragment, container, false)
        viewModel = ViewModelProviders.of(this,factory).get(CodeConfirmViewModel::class.java)
        binding.event = viewModel
        binding.lifecycleOwner = this
        arguments?.let {
            val arg = CodeConfirmFragmentArgs.fromBundle(it)
            eventz= arg.event
        }

        eventz?.let {
        viewModel.findEmployee(it.ticket_code!!)
        }
        return  binding.root
    }


}
