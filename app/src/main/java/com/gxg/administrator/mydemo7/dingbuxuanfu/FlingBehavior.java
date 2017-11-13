package com.gxg.administrator.mydemo7.dingbuxuanfu;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by lvliheng on 2017/8/23 at 19:50.
 * 上滑时
 当AppBarLayout由展开到收起时，会依次调用
 onStartNestedScroll()->onNestedScrollAccepted()->onNestedPreScroll()->onStopNestedScroll()
 当AppBarLayout收起后继续向上滑动时，会依次调用
 onStartNestedScroll()->onNestedScrollAccepted()->onNestedPreScroll()->onNestedScroll()->onStopNestedScroll()
 下滑时
 当AppBarLayout全部展开时（即未到顶部时），会依次调用
 onStartNestedScroll()->onNestedScrollAccepted()->onNestedPreScroll()->onNestedScroll()->onStopNestedScroll()
 当AppBarLayout全部展开时（即到顶部时），继续向下滑动屏幕，会依次调用
 onStartNestedScroll()->onNestedScrollAccepted()->onNestedPreScroll()->onNestedScroll()->onStopNestedScroll()
 当有快速滑动时会在onStopNestedScroll()前依次调用
 onNestedPreFling()->onNestedFling()
 所以要修改AppBarLayout的越界行为可以重写onNestedPreScroll()或onNestedScroll()，
 因为AppBarLayout收起时不会调用onNestedScroll()，所以只能选择重写onNestedPreScroll()，具体原因下面会有说明。
 */

public class FlingBehavior extends AppBarLayout.Behavior {
    private static final String TAG = "sss";
    private static final int TOP_CHILD_FLING_THRESHOLD = 1;
    private static final float OPTIMAL_FLING_VELOCITY = 3500;
    private static final float MIN_FLING_VELOCITY = 20;

    boolean shouldFling = false;
    float flingVelocityY = 0;
    private int searchPaneHeight = 0;//搜索框的高度
    private Context   ctx ;
    public FlingBehavior() {
    }

    /**
     * 一定要重写这个构造函数。因为CoordinatorLayout源码中parseBehavior()函数中直接反射调用这个构造函数。
     * @param context
     * @param attrs
     */
    public FlingBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.ctx = context;

    }
    /**
     * 当准备开始嵌套滚动时调用
     *
     * @param coordinatorLayout 父布局CoordinatorLayout
     * @param child 使用此Behavior的AppBarLayout
     * @param target 发起嵌套滚动的目标View(即AppBarLayout下面的ScrollView或RecyclerView)
     * @param velocityX 用户在水平方向上滑动的像素数
     * @param velocityY 用户在垂直方向上滑动的像素数
     * @param consumed 输出参数，consumed[0]为水平方向应该消耗的距离，consumed[1]为垂直方向应该消耗的距离
     */
    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target,
                                  int velocityX, int velocityY, int[] consumed) {

        super.onNestedPreScroll(coordinatorLayout, child, target, velocityX, velocityY, consumed);

        //上滑为正，下滑是负  滑动都是先大后小（4 10 100 10 2）（-1 -35  -140  -99  01）
        if (velocityY > MIN_FLING_VELOCITY) {
            shouldFling = true;
            flingVelocityY = velocityY;
        }
//        else if(velocityY<-20){
//
//        }
        else {
            shouldFling = false;
        }

    }
    /**
     * 当CoordinatorLayout的子View尝试发起嵌套滚动时调用
     *
     * @param parent 父布局CoordinatorLayout
     * @param child 使用此Behavior的AppBarLayout
     * @param directTargetChild CoordinatorLayout的子View，或者是包含嵌套滚动操作的目标View
     * @param target 发起嵌套滚动的目标View(即AppBarLayout下面的ScrollView或RecyclerView)
     * @param nestedScrollAxes 嵌套滚动的方向
     * @return 返回true表示接受滚动
     */
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout parent, AppBarLayout child, View directTargetChild, View target, int nestedScrollAxes) {

        Log.e(TAG, "onStartNestedScroll: " );
        return super.onStartNestedScroll(parent, child, directTargetChild, target, nestedScrollAxes);
    }

    /**
     * 这个behavior用于当滚动发生的时候让AppBarLayout发生改变。
     */

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, AppBarLayout child, View dependency) {
        Log.e(TAG, "layoutDependsOn: "+child.getTop()+"   "+child.getBottom() );
        return super.layoutDependsOn(parent, child, dependency);
    }

    /**
     * 这个behavior用于当滚动发生的时候让AppBarLayout发生改变。
     */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, AppBarLayout child, View dependency) {
        Log.e(TAG, "onDependentViewChanged: "+child.getTop()+"   "+child.getBottom() );
        return super.onDependentViewChanged(parent, child, dependency);
    }
    /**
     * 当定制滚动时调用
     *
     * @param coordinatorLayout 父布局CoordinatorLayout
     * @param abl 使用此Behavior的AppBarLayout
     * @param target 发起嵌套滚动的目标View(即AppBarLayout下面的ScrollView或RecyclerView)
     */
    @Override
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout abl, View target) {
        super.onStopNestedScroll(coordinatorLayout, abl, target);
        if (shouldFling) {
            Log.d(TAG, "onStopNestedScroll: " + flingVelocityY);
            onNestedFling(coordinatorLayout, abl, target, 0, flingVelocityY, true);
        }
    }
    /**
     * AppBarLayout布局时调用
     *
     * @param parent 父布局CoordinatorLayout
     * @param abl 使用此Behavior的AppBarLayout
     * @param layoutDirection 布局方向
     * @return 返回true表示子View重新布局，返回false表示请求默认布局
     */
    @Override
    public boolean onLayoutChild(CoordinatorLayout parent, AppBarLayout abl, int layoutDirection) {
        Log.e(TAG, "onLayoutChild: "+abl.getTop()+"   "+abl.getBottom() );
        return super.onLayoutChild(parent, abl, layoutDirection);
    }

    /**
     * 当嵌套滚动已由CoordinatorLayout接受时调用
     *
     * @param coordinatorLayout 父布局CoordinatorLayout
     * @param child 使用此Behavior的AppBarLayout
     * @param directTargetChild CoordinatorLayout的子View，或者是包含嵌套滚动操作的目标View
     * @param target 发起嵌套滚动的目标View(即AppBarLayout下面的ScrollView或RecyclerView)
     * @param nestedScrollAxes 嵌套滚动的方向
     */
    @Override
    public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, AppBarLayout child, View directTargetChild, View target, int nestedScrollAxes) {
        Log.e(TAG, "onNestedScrollAccepted: " );
        super.onNestedScrollAccepted(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
    }


    //1.判断滑动的方向 我们需要垂直滑动
    /**
     * 嵌套滚动时调用
     *
     * @param coordinatorLayout 父布局CoordinatorLayout
     * @param child 使用此Behavior的AppBarLayout
     * @param target 发起嵌套滚动的目标View(即AppBarLayout下面的ScrollView或RecyclerView)
     * @param dxConsumed 由目标View滚动操作消耗的水平像素数
     * @param dyConsumed 由目标View滚动操作消耗的垂直像素数
     * @param dxUnconsumed 由用户请求但是目标View滚动操作未消耗的水平像素数
     * @param dyUnconsumed 由用户请求但是目标View滚动操作未消耗的垂直像素数
     */
    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
//        Log.e(TAG, "onNestedScroll: " );
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        //进行滑动事件处理
    }
    /**
     * 当嵌套滚动的子View准备快速滚动时调用
     *
     * @param coordinatorLayout 父布局CoordinatorLayout
     * @param child 使用此Behavior的AppBarLayout
     * @param target 发起嵌套滚动的目标View(即AppBarLayout下面的ScrollView或RecyclerView)
     * @param velocityX 水平方向的速度
     * @param velocityY 垂直方向的速度
     * @return 如果Behavior消耗了快速滚动返回true
     */
    @Override
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, float velocityX, float velocityY) {
        Log.e(TAG, "onNestedPreFling: "+velocityY );
        return super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY);

    }
    /**
     * 当嵌套滚动的子View快速滚动时调用
     *
     * @param coordinatorLayout 父布局CoordinatorLayout
     * @param child 使用此Behavior的AppBarLayout
     * @param target 发起嵌套滚动的目标View(即AppBarLayout下面的ScrollView或RecyclerView)
     * @param velocityX 水平方向的速度
     * @param velocityY 垂直方向的速度
     * @param consumed 如果嵌套的子View消耗了快速滚动则为true
     * @return 如果Behavior消耗了快速滚动返回true
     */
    @Override
    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target,
                                 float velocityX, float velocityY, boolean consumed) {
        //当进行快速滑动
        Log.e(TAG, "onNestedFling:  velocityY  "+velocityY+"   ");
        if (target instanceof RecyclerView && velocityY < 0) {
            Log.e(TAG, "onNestedFling: target is recyclerView");
            final RecyclerView recyclerView = (RecyclerView) target;
            final View firstChild = recyclerView.getChildAt(0);

            final int childAdapterPosition = recyclerView.getChildAdapterPosition(firstChild);

            consumed = childAdapterPosition > TOP_CHILD_FLING_THRESHOLD;
            Log.e(TAG, " childAdapterPosition  "+childAdapterPosition+ "   "+consumed);
        }

        // prevent fling flickering when going up
        if (target instanceof NestedScrollView && velocityY > 0) {
            Log.e(TAG, "onNestedFling: target is NestedScrollView");
            consumed = true;
        }

        if (Math.abs(velocityY) < OPTIMAL_FLING_VELOCITY) {
            velocityY = OPTIMAL_FLING_VELOCITY * (velocityY < 0 ? -1 : 1);
        }
        Log.d(TAG, "onNestedFling: velocityY - " + velocityY + ", consumed - " + consumed);

        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
    }

    /**

     * dp转px

     *

     * @param context


     * @return

     */

    public static int dp2px(Context context, float dpVal)

    {

        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,

                dpVal, context.getResources().getDisplayMetrics());

    }

}
