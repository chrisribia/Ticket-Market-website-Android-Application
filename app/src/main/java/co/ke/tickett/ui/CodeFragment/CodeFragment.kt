package co.ke.tickett.ui.CodeFragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import co.ke.tickett.R

class CodeFragment : Fragment() {

    companion object {
        fun newInstance() = CodeFragment()
    }

    private lateinit var viewModel: CodeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.code_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CodeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
