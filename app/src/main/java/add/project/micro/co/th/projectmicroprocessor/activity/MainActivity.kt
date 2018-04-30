package add.project.micro.co.th.projectmicroprocessor.activity

import add.project.micro.co.th.projectmicroprocessor.R
import add.project.micro.co.th.projectmicroprocessor.fragment.FirstFragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import butterknife.ButterKnife
import android.view.MenuItem
import kotlinx.android.synthetic.main.z_tool_bar.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        setToolBar()
        inItFragment()

    }

    private fun setToolBar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        tv_toolbar_title.text = getString(R.string.washingmachine)
    }

    private fun inItFragment() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, FirstFragment.newInstance())
                .commit()
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
