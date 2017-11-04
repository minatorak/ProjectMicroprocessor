package add.project.micro.co.th.projectmicroprocessor;

import android.content.Context;
import android.preference.SwitchPreference;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;

public class CustomSwipeRefresh extends SwipeRefreshLayout {

    public CustomSwipeRefresh(Context context) {
        super(context);
    }

    public CustomSwipeRefresh(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    private void init() {
        setColorSchemeResources(R.color.title, R.color.year);
    }
}
