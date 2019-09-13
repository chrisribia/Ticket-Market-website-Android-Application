package co.ke.tickett.ui.SellFragment

import androidx.navigation.Navigation
import co.ke.tickett.R
import co.ke.tickett.data.db.entity.Sell
import co.ke.tickett.databinding.SellitemBinding
import com.xwray.groupie.databinding.BindableItem

class SelItem(private val sell : Sell) : BindableItem<SellitemBinding>() {
    override fun getLayout() = R.layout.sellitem

    override fun bind(viewBinding: SellitemBinding, position: Int) {
        viewBinding.setSell(sell)

            viewBinding.root.setOnClickListener {
            val action = SellFragmentDirections.actionSellFragmentToFinalFragment(sell)
            Navigation.findNavController(it).navigate(action)

        }
    }
}