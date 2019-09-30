package co.ke.tickett.ui.CodeConfirm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import co.ke.tickett.CodeConfirmViewModel
import co.ke.tickett.R
import co.ke.tickett.data.db.entity.Events
import co.ke.tickett.data.db.entity.User
import co.ke.tickett.databinding.CodeConfirmFragmentBinding
import co.ke.tickett.ui.login.AuthListener
import co.ke.tickett.utils.hide
import co.ke.tickett.utils.toast
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class CodeConfirmFragment : Fragment(),KodeinAware,AuthListener {


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

        viewModel.fetchTickets()

        arguments?.let {
            val arg = CodeConfirmFragmentArgs.fromBundle(it)
            eventz= arg.event
        }

        eventz?.let {
        viewModel.findEmployee(it.ticket_code!!)
            viewModel.ticket_code = it.ticket_code

            viewModel.fetchTickets()
           if (it.attended == "Confirmed"){
                 binding.btnCon.hide()
            }else{
                binding.btnCon.setText("Please click To Confirm")

            }


        }


        return  binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.fetchTickets()
    }


    override fun onStarted() {
      }

    override fun onSuccess(user: User) {
     }

    override fun onFailure(message: String) {
        context?.toast(message)
       }


}
