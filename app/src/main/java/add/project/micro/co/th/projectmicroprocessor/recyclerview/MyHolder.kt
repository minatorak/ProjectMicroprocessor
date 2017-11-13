package add.project.micro.co.th.projectmicroprocessor.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

import add.project.micro.co.th.projectmicroprocessor.R


class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
    var image: ImageView
    var statusView: TextView
    var arrowRight: ImageView
    private var itemClickListener: ItemClickListener? = null

    init {
        image = itemView.findViewById(R.id.im_machine)
        statusView = itemView.findViewById(R.id.tv_status_first)
        arrowRight = itemView.findViewById(R.id.im_ic_arrow_right)

        itemView.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        this.itemClickListener!!.onItemClick(v, layoutPosition)

    }

    fun setItemClickListener(ic: ItemClickListener) {
        this.itemClickListener = ic
    }
}
