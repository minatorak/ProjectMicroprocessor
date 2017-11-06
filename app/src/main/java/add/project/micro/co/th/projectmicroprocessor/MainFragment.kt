package add.project.micro.co.th.projectmicroprocessor


import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
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


class MainFragment : Fragment() {
    var baseR = FirebaseDatabase.getInstance().getReference()
    var logR = baseR.child("log")
    var positionR = baseR.child("position")
    var statusR = baseR.child("status")
    var values: ArrayList<ModelMapper?> = ArrayList()
    @Nullable @BindView(R.id.im_washing) lateinit var imageView : ImageView
    @Nullable @BindView(R.id.tv_real_time) lateinit var LeftTime : TextView
    @Nullable @BindView(R.id.tv_real_status) lateinit var Status : TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)!!
        ButterKnife.bind(this, view)
        dataLog()
        dataStatus()
        return view
    }

    private fun dataLog() {
        logR.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val datatime  = dataSnapshot.child("count").value
                LeftTime.text = datatime.toString()


            }

            override fun onCancelled(error: DatabaseError) {


            }
        })

    }

    fun dataStatus() {
        statusR.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val status = dataSnapshot.child("running").value
                if (status.toString().equals("0") ) {
                    Status.text = "free"
                }else {
                    Status.text = "running"
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
