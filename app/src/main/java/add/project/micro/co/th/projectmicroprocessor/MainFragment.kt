package add.project.micro.co.th.projectmicroprocessor


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.ImageViewCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.google.firebase.database.FirebaseDatabase

class MainFragment : Fragment() {
    var mRootRef = FirebaseDatabase.getInstance().reference
    var mLogRef = mRootRef.child("log")
    var mPositionRef = mRootRef.child("position")
    var mStatusRef = mRootRef.child("status")
    @BindView(R.id.im_washing) lateinit var imageView : ImageView
    @BindView(R.id.tv_real_time) lateinit var LeftTime : TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        ButterKnife.bind(this,view)
        return view
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
