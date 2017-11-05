package add.project.micro.co.th.projectmicroprocessor

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class WashingAdapter constructor(val context: Context) : RecyclerView.Adapter<WashingViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): WashingViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.my_text_view, parent, false)
        return WashingViewHolder(view)
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: WashingViewHolder?, position: Int) {

    }

}
