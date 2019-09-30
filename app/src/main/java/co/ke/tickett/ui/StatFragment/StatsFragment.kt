package co.ke.tickett.ui.StatFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import co.ke.tickett.R
import co.ke.tickett.StatsViewModel
import co.ke.tickett.data.db.entity.Summery
import co.ke.tickett.utils.Coroutines
import co.ke.tickett.utils.hide
import co.ke.tickett.utils.show
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.stats_fragment.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class StatsFragment : Fragment() , KodeinAware {
    override val kodein by kodein()

    private lateinit var viewModel: StatsViewModel

    private val factory: StatsViewModelFactory by instance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.stats_fragment, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this, factory).get(StatsViewModel::class.java)
        bindUI()
    }

    private fun bindUI() = Coroutines.main {

        viewModel.quotes.await().observe(this, Observer {

            initRecyclerView(it.toQuoteItem())
        })
    }

    private fun initRecyclerView(quoteItem: List<SummeryItem>) {

        val mAdapter = GroupAdapter<ViewHolder>().apply {
            addAll(quoteItem)
        }

        recyclerview.apply {
            layoutManager = LinearLayoutManager(context)

            setHasFixedSize(true)
            adapter = mAdapter
        }


    }
    private fun List<Summery>.toQuoteItem() : List<SummeryItem>{
        return this.map {
            SummeryItem(it)
        }
    }



}
