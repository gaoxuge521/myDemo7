package com.gxg.administrator.mydemo7.RefreshHeaderLayout;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by lvliheng on 2017/8/14 at 19:30.
 */

public class CustomViewPager  extends ViewPager {
    private boolean scrollEnable = true;


    public CustomViewPager(Context paramContext)
    {
        super(paramContext);
    }

    public CustomViewPager(Context paramContext, AttributeSet paramAttributeSet)
    {
        super(paramContext, paramAttributeSet);
    }

    public boolean getScrollEnable()
    {
        return this.scrollEnable;
    }

    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
        if (this.scrollEnable) {
            return super.onInterceptTouchEvent(paramMotionEvent);
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
        if (this.scrollEnable) {
            return super.onTouchEvent(paramMotionEvent);
        }
        return false;
    }

    public void scrollTo(int paramInt1, int paramInt2)
    {
        super.scrollTo(paramInt1, paramInt2);
    }

    public void setScrollEnable(boolean paramBoolean)
    {
        this.scrollEnable = paramBoolean;
    }
}
