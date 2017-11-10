package add.project.micro.co.th.projectmicroprocessor

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.content.Context
import android.content.SharedPreferences
import android.content.res.TypedArray
import android.graphics.Color
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.RelativeLayout
import android.widget.TextView


@Suppress("DEPRECATION")
class SettingsToggle : RelativeLayout, View.OnClickListener {
    internal lateinit var layout: FrameLayout
    internal lateinit var toggleCircle: View
    internal lateinit var background_oval_off: View
    internal lateinit var background_oval_on: View
    internal lateinit var textView: TextView
    internal  var dimen: Int = 0

    private var _crossfadeRunning: Boolean? = false
    private var _sp: SharedPreferences? = null
    private var _oaLeft: ObjectAnimator? = null
    private var _oaRight: ObjectAnimator? = null
    private var _prefName: String? = null

    constructor(context: Context) : super(context) {}

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
        background_oval_off = findViewById(R.id.background_oval_off)
        background_oval_on = findViewById(R.id.background_oval_on)
        toggleCircle = findViewById(R.id.toggleCircle)
        textView = findViewById<View>(R.id.text) as TextView
        layout = findViewById<View>(R.id.layout) as FrameLayout
        if (bgDrawableOff != null) {
            val id = resources.getIdentifier(bgDrawableOff, "drawable", context.packageName)
            background_oval_off.background = resources.getDrawable(id)
        }
        if (bgDrawableOn != null) {
            val id = resources.getIdentifier(bgDrawableOn, "drawable", context.packageName)
            background_oval_on.background = resources.getDrawable(id)
        }

        textView.text = text
        if (textColor != null) textView.setTextColor(Color.parseColor(textColor))
        layout.setOnClickListener(this)

        //get a pixel size for a particular dimension - will differ by device according to screen density
        dimen = resources.getDimensionPixelSize(R.dimen.settings_toggle_width)
        _oaLeft = ObjectAnimator.ofFloat(toggleCircle, "x", 44f, 0f).setDuration(250)
        _oaRight = ObjectAnimator.ofFloat(toggleCircle, "x", 0f,44f ).setDuration(250)

        _sp = context.getSharedPreferences(context.getString(R.string.summit), Context.MODE_PRIVATE)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
    }

    override fun onClick(view: View) {

        if (_oaLeft!!.isRunning || _oaRight!!.isRunning || _crossfadeRunning!!) return

        val editor = _sp!!.edit()
        val pref = _sp!!.getBoolean(_prefName, false)
        if (pref) {
            _oaLeft!!.start()
            _crossfadeViews(background_oval_on, background_oval_off, 110)
        } else {
            _oaRight!!.start()
            _crossfadeViews(background_oval_off, background_oval_on, 400)
        }

        editor.putBoolean(_prefName, !pref)
        editor.apply()
    }

    fun setState() {
        if (isInEditMode) return  //isInEditMode(): if being rendered in IDE preview, skip code that will break

        if (_sp!!.getBoolean(_prefName, false)) {
            toggleCircle.x = (dimen / 2).toFloat()
            _crossfadeViews(background_oval_off, background_oval_on, 1)
        } else {
            toggleCircle.x = 0f
            _crossfadeViews(background_oval_on, background_oval_off, 1)
        }
    }

    private fun _crossfadeViews(begin: View, end: View, duration: Int) {
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
