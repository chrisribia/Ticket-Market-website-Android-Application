package co.ke.tickett.ui.SellFragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import co.ke.tickett.R
import co.ke.tickett.data.db.entity.Sell
import co.ke.tickett.utils.Coroutines
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.sell_fragment.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class SellFragment : Fragment(), KodeinAware {

    override val kodein by kodein()

    private lateinit var viewModel: SellViewModel


    private val factory: SellViewModelFactory by instance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sell_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, factory).get(SellViewModel::class.java)
        bindUI()
    }


    private fun bindUI() = Coroutines.main {

        viewModel.quotes.await().observe(this, Observer {

            initRecyclerView(it.toQuoteItem())
        })
    }

    private fun initRecyclerView(quoteItem: List<SelItem>) {

        val mAdapter = GroupAdapter<ViewHolder>().apply {
            addAll(quoteItem)
        }

        recyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = mAdapter
        }


    }
    private fun List<Sell>.toQuoteItem() : List<SelItem>{
        return this.map {
            SelItem(it)
        }
    }

}
