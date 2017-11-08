package add.project.micro.co.th.projectmicroprocessor


import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import butterknife.BindView
import butterknife.ButterKnife
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_main.*

class MainFragment : Fragment() {
    var baseR = FirebaseDatabase.getInstance().getReference()
    var tempR = baseR.child("Temp")
    var logR = baseR.child("log")
    var positionR = baseR.child("position")
    var statusR = baseR.child("status")
    @Nullable @BindView(R.id.image_washing) lateinit var imageView  : ImageView
    @Nullable @BindView(R.id.tv_real_time) lateinit var leftTime: TextView
    @Nullable @BindView(R.id.tv_real_status) lateinit var status: TextView
    @Nullable @BindView(R.id.tv_topic) lateinit var topic : TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)!!
        ButterKnife.bind(this, view)
        setToolBar()
        dataLog()
        dataStatus()
        return view

    }

<<<<<<< HEAD
    fun getMainActivity() : MainActivity { return activity as MainActivity}
=======
    private fun setToolBar() {
        getMainActivity().tv_topic.text = "Washing Machine"
        getMainActivity().supportActionBar?.show()
        getMainActivity().supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

>>>>>>> df58ca7cc704104bcaef0296adf532efe0c5cd38
    private fun dataTemp() {
        tempR.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
            val celsius = dataSnapshot.child("Celcius").getValue(Float::class.java)
            val huminity = dataSnapshot.child("Huminity").getValue(Float::class.java)
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }

        })
    }

    private fun dataLog() {
        logR.addValueEventListener(object : ValueEventListener {
            @SuppressLint("SetTextI18n")
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val count = dataSnapshot.child("countDown").getValue(Int::class.java)
                leftTime.text = count.toString()

            }

            override fun onCancelled(error: DatabaseError) {
            }
        })

    }

    private fun dataPosition() {
        positionR.addValueEventListener(object :ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
            val latitude = dataSnapshot.child("latitude").getValue(Double::class.java)
            val longitude = dataSnapshot.child("lng").getValue(Double::class.java)
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }

        })
    }

    private fun dataStatus() {
        statusR.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val statusData = dataSnapshot.child("running").value
                if (statusData.toString().equals("0") ) {
                    try {
                        imageView?.setColorFilter(ContextCompat.getColor(context, R.color.green))
                        status.text = "free"
                    }catch (e: NullPointerException) {

                    }

                }else {
                    try {
                        imageView?.setColorFilter(ContextCompat.getColor(context, R.color.red))
                        status.text = "running"

                    }catch (e: NullPointerException) {

                    }
                }

            }
            override fun onCancelled(error: DatabaseError) {
            }
        })
        }
    fun getMainActivity(): MainActivity { return activity as MainActivity }

    companion   object {
        fun newInstance(): MainFragment {
            val bundle = Bundle()
            val fragment = MainFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

}