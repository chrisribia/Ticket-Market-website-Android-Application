package co.ke.tickett.ui.QrReaderFragment

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import co.ke.tickett.R
import co.ke.tickett.utils.toast
import com.google.zxing.integration.android.IntentIntegrator

class QrFragment : Fragment() {

    companion object {
        fun newInstance() = QrFragment()
    }

    private lateinit var viewModel: QrViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.qr_fragment, container, false)
        scanFromFragment()
        return view
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
                context?.toast(result.getContents())
            }


        }

    }

}
