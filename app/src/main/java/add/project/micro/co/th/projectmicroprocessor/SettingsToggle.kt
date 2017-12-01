package add.project.micro.co.th.projectmicroprocessor

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.google.firebase.database.FirebaseDatabase


@Suppress("DEPRECATION")
class SettingsToggle : RelativeLayout, View.OnClickListener {
    private val baseR = FirebaseDatabase.getInstance().reference
    private lateinit var layout: FrameLayout
    private lateinit var toggleCircle: View
    private lateinit var backGroundOvalOff: View
    private lateinit var backGroundOvalOn: View
    private lateinit var textView: TextView
    private var dimen: Int = 0

    private var _crossfadeRunning: Boolean? = false
    private var _sp: SharedPreferences? = null
    private var _oaLeft: ObjectAnimator? = null
    private var _oaRight: ObjectAnimator? = null
    private var _prefName: String? = null

    constructor(context: Context) : super(context)

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val text: String?
        val textColor: String?
        val bgDrawableOff: String?
        val bgDrawableOn: String?
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.settings_toggle, this, true)
        val a = getContext().obtainStyledAttributes(attrs, R.styleable.SettingsToggle)
        bgDrawableOff = a.getString(R.styleable.SettingsToggle_oval_background_off)
        bgDrawableOn = a.getString(R.styleable.SettingsToggle_oval_background_on)
        _prefName = a.getString(R.styleable.SettingsToggle_prefName)
        text = a.getString(R.styleable.SettingsToggle_text)
        textColor = a.getString(R.styleable.SettingsToggle_textColor)
        a.recycle()
        backGroundOvalOff = findViewById(R.id.backGroundOvalOff)
        backGroundOvalOn = findViewById(R.id.backGroundOvalOn)
        toggleCircle = findViewById(R.id.toggleCircle)
        textView = findViewById<View>(R.id.text) as TextView
        layout = findViewById<View>(R.id.layout) as FrameLayout
        if (bgDrawableOff != null) {
            val id = resources.getIdentifier(bgDrawableOff, "drawable", context.packageName)
            backGroundOvalOff.background = resources.getDrawable(id)
        }
        if (bgDrawableOn != null) {
            val id = resources.getIdentifier(bgDrawableOn, "drawable", context.packageName)
            backGroundOvalOn.background = resources.getDrawable(id)
        }

        textView.text = text
        if (textColor != null) textView.setTextColor(Color.parseColor(textColor))
        layout.setOnClickListener(this)

        dimen = resources.getDimensionPixelSize(R.dimen.settings_toggle_width)
        _oaLeft = ObjectAnimator.ofFloat(toggleCircle, "x", (dimen/2).toFloat(), 0f).setDuration(250)
        _oaRight = ObjectAnimator.ofFloat(toggleCircle, "x", 0f,(dimen/2).toFloat()).setDuration(250)

        _sp = context.getSharedPreferences(context.getString(R.string.summit), Context.MODE_PRIVATE)

    }


    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    override fun onClick(view: View) {

        if (_oaLeft!!.isRunning || _oaRight!!.isRunning || _crossfadeRunning!!) return

        val editor = _sp!!.edit()
        val pref = _sp!!.getBoolean(_prefName, false)
        if (pref) {
            _oaLeft!!.start()
            crossFadeViews(backGroundOvalOn, backGroundOvalOff, 110)
            baseR.child("status").child("power").setValue(0)
        } else {
            _oaRight!!.start()
            crossFadeViews(backGroundOvalOff, backGroundOvalOn, 400)
            baseR.child("status").child("power").setValue(1)
        }

        editor.putBoolean(_prefName, !pref)
        editor.apply()
    }

    private fun crossFadeViews(begin: View, end: View, duration: Int) {
        _crossfadeRunning = true

        end.alpha = 0f
        end.visibility = View.VISIBLE
        end.animate().alpha(1f).setDuration(duration.toLong()).setListener(null)
        begin.animate().alpha(0f).setDuration(duration.toLong()).setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                begin.visibility = View.GONE
                _crossfadeRunning = false
            }
        })
    }
}
