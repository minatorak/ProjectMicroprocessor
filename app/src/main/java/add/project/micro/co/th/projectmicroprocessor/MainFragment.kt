package add.project.micro.co.th.projectmicroprocessor


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.google.firebase.database.FirebaseDatabase
import java.util.*
import android.content.ContentValues.TAG
import android.widget.Toast
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener



class MainFragment : Fragment() {
    var baseR = FirebaseDatabase.getInstance().getReference()
    var logR = baseR.child("log")
    var Valuex = arrayListOf<ModelMapper>()
    @BindView(R.id.im_washing) lateinit var imageView : ImageView
    @BindView(R.id.tv_real_time) lateinit var LeftTime : TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        getSet()
        return view
    }

    private fun getSet() {
        logR.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue(String::class.java)

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
