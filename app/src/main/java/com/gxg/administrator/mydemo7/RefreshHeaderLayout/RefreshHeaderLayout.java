package com.gxg.administrator.mydemo7.RefreshHeaderLayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lvliheng on 2017/8/14 at 19:10.
 */

public class RefreshHeaderLayout  extends ViewGroup {
    public RefreshHeaderLayout(Context paramContext)
    {
        this(paramContext, null);
    }

    public RefreshHeaderLayout(Context paramContext, AttributeSet paramAttributeSet)
    {
        this(paramContext, paramAttributeSet, 0);
    }

    public RefreshHeaderLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
        super(paramContext, paramAttributeSet, paramInt);
    }

    private void getMeasure()
    {
        getMeasuredWidth();
        int k = getMeasuredHeight();
        int n = getPaddingLeft();
        int m = getPaddingTop();
        getPaddingRight();
        getPaddingBottom();
        if (getChildCount() > 0)
        {
            View localView = getChildAt(0);
            int i = localView.getMeasuredWidth();
            int j = localView.getMeasuredHeight();
            ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
            n += localMarginLayoutParams.leftMargin;
            k = localMarginLayoutParams.topMargin + m - (j - k);
            localView.layout(n, k, n + i, k + j);
        }
    }

    protected ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new LayoutParams(-1, -1);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
    {
        return new LayoutParams(getContext(), paramAttributeSet);
    }

    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
        return new LayoutParams(paramLayoutParams);
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
        getMeasure();
    }

    protected void onMeasure(int paramInt1, int paramInt2)
    {
        if (getChildCount() > 0)
        {
            int i = View.MeasureSpec.makeMeasureSpec(0, 0);
            measureChildWithMargins(getChildAt(0), paramInt1, 0, i, 0);
        }
        super.onMeasure(paramInt1, paramInt2);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams
    {
        public LayoutParams(int paramInt1, int paramInt2)
        {
            super(paramInt1,paramInt2);
        }

        public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
        {
            super(paramContext,paramAttributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
        {
            super(paramLayoutParams);
        }
    }
}
