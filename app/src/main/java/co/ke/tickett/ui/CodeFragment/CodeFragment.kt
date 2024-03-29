package co.ke.tickett.ui.CodeFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import co.ke.tickett.CodeViewModel
import co.ke.tickett.data.db.entity.Events
import co.ke.tickett.databinding.CodeFragmentBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.code_fragment.*
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
        val binding : CodeFragmentBinding = DataBindingUtil.inflate(inflater,
            co.ke.tickett.R.layout.code_fragment, container, false)
        viewModel = ViewModelProviders.of(this,factory).get(CodeViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.fetchTickets()
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, factory).get(CodeViewModel::class.java)
        viewModel.fetchTickets()
        viewModel.employees.observe(this, Observer {
            it?.let {
                initRecyclerView(it.toEmployeeItem())
            }
        })
    }

    private fun initRecyclerView(employee: List<CodeItem>) {

        val mAdapter = GroupAdapter<ViewHolder>().apply {
            addAll(employee)
        }

        recyclerview.apply {

            layoutManager = LinearLayoutManager(
                this.getContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
            adapter = mAdapter
        }

    }


    private fun List<Events>.toEmployeeItem(): List<CodeItem> {
        return this.map {
            CodeItem(it)
        }
    }


}
