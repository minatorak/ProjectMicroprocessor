package add.project.micro.co.th.projectmicroprocessor.custom;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;

import add.project.micro.co.th.projectmicroprocessor.R;

public class CustomSwipeRefresh extends SwipeRefreshLayout {

    public CustomSwipeRefresh(Context context) {
        super(context);
        init();
    }

    public CustomSwipeRefresh(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void init() {
        setColorSchemeResources(R.color.title, R.color.year);
    }
}
