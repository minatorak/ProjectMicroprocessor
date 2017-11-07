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
import butterknife.BindView
import butterknife.ButterKnife
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_main.*
import java.util.*
import java.util.concurrent.TimeUnit

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")
class MainFragment : Fragment() {
    var baseR = FirebaseDatabase.getInstance().getReference()
    var tempR = baseR.child("Temp")
    var logR = baseR.child("log")
    var positionR = baseR.child("position")
    var statusR = baseR.child("status")
    var intervalTime =""
    @Nullable @BindView(R.id.image_washing) lateinit var imageView : ImageView
    @Nullable @BindView(R.id.tv_real_time) lateinit var leftTime: TextView
    @Nullable @BindView(R.id.tv_real_status) lateinit var status: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)!!
        ButterKnife.bind(this, view)
        dataLog()
        dataStatus()
        return view

    }
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
                val datetime  = dataSnapshot.child("dateStart").getValue(Long::class.java)
                val calendar = Calendar.getInstance()
                calendar.timeInMillis = datetime!!
                 intervalTime = calendar.get(Calendar.MINUTE).toString()
                leftTime.text = intervalTime

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
                    imageView.setColorFilter(ContextCompat.getColor(context, R.color.green))
                    status.text = "free"
                }else {
                    imageView.setColorFilter(ContextCompat.getColor(context, R.color.red))
                    status.text = "running"

                }

            }
            override fun onCancelled(error: DatabaseError) {
            }
        })
        }


    companion object {
        fun newInstance(): MainFragment {
            val bundle = Bundle()
            val fragment = MainFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

}