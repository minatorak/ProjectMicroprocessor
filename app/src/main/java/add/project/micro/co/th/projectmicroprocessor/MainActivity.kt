package add.project.micro.co.th.projectmicroprocessor

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout


class MainActivity : AppCompatActivity() {
    private var mRecyclerView : RecyclerView?= null
    private var mAdapter: RecyclerView.Adapter<*>? = null
    private var mLayoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRecyclerView = findViewById(R.id.my_recycler_view)
        mRecyclerView?.setHasFixedSize(true)
        mLayoutManager = LinearLayoutManager(this)
        mRecyclerView?.layoutManager = mLayoutManager

    }
}
