package add.project.micro.co.th.projectmicroprocessor.fragment


import add.project.micro.co.th.projectmicroprocessor.R
import add.project.micro.co.th.projectmicroprocessor.activity.MainActivity
import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.annotation.RequiresApi
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import butterknife.BindView
import butterknife.ButterKnife
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class SecondFragment : Fragment() {
    var baseR = FirebaseDatabase.getInstance().getReference()
    var logR = baseR.child("log")
    var statusR = baseR.child("status")
    var notiR = baseR.child("Noti")
    @Nullable @BindView(R.id.image_washing) lateinit var imageView  : ImageView
    @Nullable @BindView(R.id.tv_real_time) lateinit var leftTime: TextView
    @Nullable @BindView(R.id.tv_real_status) lateinit var status: TextView
    @Nullable @BindView(R.id.edt_e_mail) lateinit var edtMail : EditText
    @Nullable @BindView(R.id.btn_summit) lateinit var btnSummit : Button
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)!!
        ButterKnife.bind(this, view)
        getMainActivity().supportActionBar?.show()
        dataLog()
        dataStatus()
        setEmail()
        return view

    }

    private fun setEmail() {
        btnSummit.setOnClickListener {
            if (edtMail.length() == 0 ) {
                Toast.makeText(context, "กรุณากรอก E-mail ของท่าน", Toast.LENGTH_LONG).show()
            } else if (edtMail.length() != 0){
                baseR.child("Noti").child("Email").setValue(edtMail.text.toString())
                Toast.makeText(context, "ทำการบันทึกสำเร็จ", Toast.LENGTH_LONG).show()
            }
            edtMail.setText("")
        }
    }


    private fun dataLog() {
        logR.addValueEventListener(object : ValueEventListener {
            @SuppressLint("SetTextI18n")
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val count = dataSnapshot.child("countDown").getValue(Int::class.java)
                leftTime.text = count.toString()
//                if (leftTime.text == "0") {
//                    val intent = Intent(ACTION_CHANNEL_NOTIFICATION_SETTINGS)
//                    intent.putExtra(Settings.EXTRA_CHANNEL_ID, mChannel.getId())
//                    intent.putExtra(Settings.EXTRA_APP_PACKAGE, getPackageName())
//                    startActivity(intent)
//                }

            }

            override fun onCancelled(error: DatabaseError) {
            }
        })

    }

    private fun dataStatus() {
        statusR.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val statusData = dataSnapshot.child("running").value
                if (statusData.toString().equals("0") ) {
                    try {
                        imageView.setColorFilter(ContextCompat.getColor(context, R.color.green))
                        status.text = getString(R.string.Blank)
                    }catch (e: NullPointerException) {

                    }

                }else {
                    try {
                        imageView.setColorFilter(ContextCompat.getColor(context, R.color.red))
                        status.text = getString(R.string.isRunning)

                    }catch (e: NullPointerException) {

                    }
                }

            }
            override fun onCancelled(error: DatabaseError) {
            }
        })
        }
    private fun getMainActivity(): MainActivity { return activity as MainActivity
    }

    companion   object {
        fun newInstance(): SecondFragment {
            val bundle = Bundle()
            val fragment = SecondFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

}