package co.ke.tickett.ui.StatFragment

import co.ke.tickett.R
import co.ke.tickett.data.db.entity.Summery
import co.ke.tickett.databinding.EventdetailsitemBinding
import com.xwray.groupie.databinding.BindableItem

class SummeryItem(
    private val summery : Summery)

    :BindableItem<EventdetailsitemBinding>()  {
    override fun getLayout() = R.layout.eventdetailsitem

    override fun bind(viewBinding: EventdetailsitemBinding, position: Int) {
        viewBinding.setSummery(summery)

    }
}