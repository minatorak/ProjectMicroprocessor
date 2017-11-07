package add.project.micro.co.th.projectmicroprocessor


import android.content.Context
import android.os.Bundle
import android.support.annotation.NonNull
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.CardView
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class SecondFragment : Fragment() {
    val imgShow = arrayOf(R.drawable.ic_washing_machine)
    val tusView = arrayOf("Washing Machine")
    val arrow = arrayOf(R.drawable.ic_arrow_right)
    private lateinit var adapter: MyAdapter
    var baseR = FirebaseDatabase.getInstance().getReference()
    var tempR = baseR.child("Temp")
    @NonNull @BindView(R.id.myrecycler) lateinit var rv : RecyclerView
    @NonNull @BindView(R.id.tv_real_celsius) lateinit var tvCelsius : TextView
    @NonNull @BindView(R.id.tv_real_humdity) lateinit var tvHumidity : TextView
        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        ButterKnife.bind(this,view)
        adapter = MyAdapter(context,imgShow.toIntArray(),tusView,arrow.toIntArray())
        val mLayoutManager = LinearLayoutManager(context)
        rv.layoutManager = mLayoutManager
        rv.itemAnimator = DefaultItemAnimator()
        rv.adapter = adapter
        dataTemp()

        return view
    }

    private fun dataTemp() {
        tempR.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val celsius = dataSnapshot.child("Celcius").getValue(Float::class.java)
                val huminity = dataSnapshot.child("Huminity").getValue(Float::class.java)
                tvCelsius.text = celsius.toString()
                tvHumidity.text = huminity.toString()

            }

            override fun onCancelled(databaseError: DatabaseError) {

            }

        })
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
