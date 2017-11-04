package add.project.micro.co.th.projectmicroprocessor

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife

class WashingViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    @BindView(R.id.tv_order_number) lateinit var tvOrderNumber : TextView
    @BindView(R.id.tv_status) lateinit var tvStatus : TextView

    init {
        ButterKnife.bind(this, view)
    }

}