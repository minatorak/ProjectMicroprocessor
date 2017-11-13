package add.project.micro.co.th.projectmicroprocessor.recyclerview

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView

import add.project.micro.co.th.projectmicroprocessor.R
import add.project.micro.co.th.projectmicroprocessor.fragment.SecondFragment


class MyAdapter(private val c: Context, private val imgs: IntArray, private val status: Array<String>, private val arrow: IntArray) : RecyclerView.Adapter<MyHolder>() {
    private val listener: AdapterView.OnItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.my_text_view, null)

        return MyHolder(v)
    }


    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.image.setImageResource(imgs[position])
        holder.statusView.text = status[position]
        holder.arrowRight.setImageResource(arrow[position])

        holder.setItemClickListener(object : ItemClickListener {
            override fun onItemClick(v: View, pos: Int) {
                val activity = v.context as AppCompatActivity
                val fragment = SecondFragment()
                activity.supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container, fragment)
                        .addToBackStack(null)
                        .commit()

            }
        })
    }

    override fun getItemCount(): Int {
        return arrow.size
    }


}
