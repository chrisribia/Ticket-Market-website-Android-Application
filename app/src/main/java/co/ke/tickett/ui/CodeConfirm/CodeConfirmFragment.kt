package co.ke.tickett.ui.CodeConfirm

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import co.ke.tickett.R

class CodeConfirmFragment : Fragment() {

    companion object {
        fun newInstance() = CodeConfirmFragment()
    }

    private lateinit var viewModel: CodeConfirmViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.code_confirm_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CodeConfirmViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
