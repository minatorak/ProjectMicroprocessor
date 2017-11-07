package add.project.micro.co.th.projectmicroprocessor


import android.content.Context
import android.os.Bundle
import android.support.annotation.NonNull
import android.support.v4.app.Fragment
import android.support.v7.widget.CardView
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife


class SecondFragment : Fragment() {
    val imgShow = arrayOf(R.drawable.ic_washing_machine)
    val tusView = arrayOf("Status")
    val tusShow = arrayOf("free")
    val dView = arrayOf("Time")
    val vShow = arrayOf("00:00:00")
    val arrow = arrayOf(R.drawable.ic_arrow_right)
    val test = "test"
    private lateinit var adapter: MyAdapter
    @NonNull @BindView(R.id.myrecycler) lateinit var rv : RecyclerView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        ButterKnife.bind(this,view)
        adapter = MyAdapter(context,imgShow.toIntArray(),tusView,tusShow,dView,vShow,arrow.toIntArray())
        val mLayoutManager = LinearLayoutManager(context)
        rv.layoutManager = mLayoutManager
        rv.itemAnimator = DefaultItemAnimator()
        rv.adapter = adapter

        return view
    }



    companion object {
        fun newInstance() : SecondFragment {
            val bundle = Bundle()
            val fragment = SecondFragment()
            fragment.arguments = bundle
            return fragment

        }
    }

}
