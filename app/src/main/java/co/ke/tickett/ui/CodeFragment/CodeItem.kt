package co.ke.tickett.ui.CodeFragment

import androidx.navigation.Navigation
import co.ke.tickett.R
import co.ke.tickett.data.db.entity.Events
import co.ke.tickett.databinding.LayouteventBinding
import com.xwray.groupie.databinding.BindableItem

class CodeItem(private val events: Events) : BindableItem<LayouteventBinding>(){
    override fun getLayout() = R.layout.layoutevent

    override fun bind(viewBinding: LayouteventBinding, position: Int) {
        viewBinding.setEvent(events)
        viewBinding.root.setOnClickListener {
            val action =
                CodeFragmentDirections.actionCodeFragmentToCodeConfirmFragment(events)
            Navigation.findNavController(it).navigate(action)
        }
    }
}