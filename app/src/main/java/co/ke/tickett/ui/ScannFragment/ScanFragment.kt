package co.ke.tickett.ui.ScannFragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import co.ke.tickett.R
import co.ke.tickett.ScanViewModel
import co.ke.tickett.databinding.ScanFragmentBinding
import co.ke.tickett.utils.toast
import com.google.zxing.integration.android.IntentIntegrator

import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class ScanFragment : Fragment() , KodeinAware {
    override val kodein by kodein()



    private lateinit var viewModel: ScanViewModel

    private val factory: ScanViewModelFactory by instance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: ScanFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.scan_fragment, container, false)
        viewModel = ViewModelProviders.of(this, factory).get(ScanViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        scanFromFragment()
        return binding.root
    }


    fun scanFromFragment() {
        IntentIntegrator.forSupportFragment(this).initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)

        if(result != null) {
            if(result.getContents() == null) {
                context?.toast("Cancelled from fragment")
            } else {
                viewModel.findEmployee(result.getContents())
            }


        }

    }

}