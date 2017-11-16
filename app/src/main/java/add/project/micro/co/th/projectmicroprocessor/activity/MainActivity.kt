package add.project.micro.co.th.projectmicroprocessor.activity

import add.project.micro.co.th.projectmicroprocessor.R
import add.project.micro.co.th.projectmicroprocessor.fragment.FirstFragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import android.view.MenuItem


class MainActivity : AppCompatActivity() {
    @Nullable @BindView(R.id.toolbar) lateinit var Mytoolbar : Toolbar
    @Nullable @BindView(R.id.tv_toolbar_title) lateinit var tvTopic : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        setToolBar()
        initFragment()

    }

    private fun setToolBar() {
        setSupportActionBar(Mytoolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        tvTopic.text = getString(R.string.washingmachine)
    }

    fun initFragment() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, FirstFragment.newInstance())
                .commit()
    }
    fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, FirstFragment.newInstance())
                .addToBackStack(null)
                .commit()
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
