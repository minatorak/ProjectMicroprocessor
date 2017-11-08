package add.project.micro.co.th.projectmicroprocessor

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife


class MainActivity : AppCompatActivity() {
    @Nullable @BindView(R.id.my_toolbar) lateinit var toolBar : Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        setSupportActionBar(toolBar)
        initFragment()

    }
    fun initFragment() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, SecondFragment.newInstance())
                .commit()
    }
    fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, SecondFragment.newInstance())
                .addToBackStack(null)
                .commit()
    }
}
