package add.project.micro.co.th.projectmicroprocessor

import android.support.annotation.Nullable
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife

class WashingViewHolder(view : View) : RecyclerView.ViewHolder(view),View.OnClickListener {
    override fun onClick(p0: View?) {

    }

    @Nullable @BindView(R.id.im_machine) lateinit var image : ImageView
    @Nullable @BindView(R.id.tv_status_first) lateinit var statusView : TextView
    @Nullable @BindView(R.id.im_ic_arrow_right) lateinit var arrowRight : ImageView

    init {
        ButterKnife.bind(this, view)
    }

}