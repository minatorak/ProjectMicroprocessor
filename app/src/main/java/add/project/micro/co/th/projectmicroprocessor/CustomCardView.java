package add.project.micro.co.th.projectmicroprocessor;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.util.TypedValue;


public class CustomCardView extends CardView {
    TypedValue outValue;
    public CustomCardView(Context context) {
        super(context);
        init();
    }

    public CustomCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init() {
        outValue = new TypedValue();

        setClickable(true);
        setRadius(0f);
        setPreventCornerOverlap(false);
        getContext().getTheme().resolveAttribute(android.R.attr.selectableItemBackground, outValue, true);
        setForeground(ContextCompat.getDrawable(getContext(), outValue.resourceId));
    }
}
