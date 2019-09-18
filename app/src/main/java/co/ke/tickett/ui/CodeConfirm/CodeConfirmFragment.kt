package co.ke.tickett.ui.CodeConfirm

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import co.ke.tickett.CodeConfirmViewModel

import co.ke.tickett.R
import co.ke.tickett.data.db.entity.Events
import co.ke.tickett.data.db.entity.User
import co.ke.tickett.databinding.CodeConfirmFragmentBinding
import co.ke.tickett.ui.login.AuthListener
import co.ke.tickett.utils.hide
import co.ke.tickett.utils.hidex
import co.ke.tickett.utils.toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.code_confirm_fragment.*
import kotlinx.android.synthetic.main.code_confirm_fragment.btnCon
import kotlinx.android.synthetic.main.code_confirm_fragment.statez
import kotlinx.android.synthetic.main.scan_fragment.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance
import javax.security.auth.callback.Callback

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
        viewModel.fetchTickets()
        binding.lifecycleOwner = this
        arguments?.let {
            val arg = CodeConfirmFragmentArgs.fromBundle(it)
            eventz= arg.event
        }
        eventz?.let {
        viewModel.findEmployee(it.ticket_code!!)
            viewModel.ticket_code = it.ticket_code

            var status = it.attended
             if (status == "Confirmed"){
                 binding.btnCon.setText("Already Confirmed")
                 binding.btnCon.hidex()

             }else{
                 binding.btnCon.setText("Please Click here to Confirm")
             }

        }



        return  binding.root
    }







    override fun onStarted() {
      }

    override fun onSuccess(user: User) {
     }

    override fun onFailure(message: String) {
        context?.toast(message)
       }


}
