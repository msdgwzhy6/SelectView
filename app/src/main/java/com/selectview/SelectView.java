package com.selectview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


/**
 * Created by wujun on 2017/9/13.
 * 7个选择点
 *
 * @author madreain
 * @desc
 */

public class SelectView extends View {
    //实心
    Paint solidPaint;
    //空心
    Paint hollowPaint;
    private int solidnum;
    private int hollownum;

    //宽高
    int mwidth, mheight;
    float radius;
    Context mcontext;

    public SelectView(Context context) {
        super(context);
        mcontext = context;
        init(context);
    }

    public SelectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mcontext = context;
        initType(context,attrs);
        init(context);
    }

    public SelectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mcontext = context;
        initType(context,attrs);
        init(context);
    }

    private void initType(Context context,AttributeSet attrs){
        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.SelectView);
        solidnum=typedArray.getInteger(R.styleable.SelectView_solidnum,0);
        hollownum=typedArray.getInteger(R.styleable.SelectView_hollownum,0);
        typedArray.recycle();
    }

    private void init(Context context) {
        solidPaint = new Paint();
        solidPaint.setAntiAlias(true);
        solidPaint.setColor(Color.rgb(50,193,164));
        solidPaint.setStyle(Paint.Style.FILL);

        hollowPaint = new Paint();
        hollowPaint.setAntiAlias(true);
        hollowPaint.setColor(Color.rgb(50,193,164));
        hollowPaint.setStyle(Paint.Style.STROKE);

        radius = DisplayUtil.dip2px(context, 3.5f);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //宽高
        mwidth = w;
        mheight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //先计算总量 每一个20
        int size = solidnum + hollownum;
        if (size > 0) {
            float statrx = (mwidth - DisplayUtil.dip2px(mcontext, 20) * size) / 2;
            float y=mheight/2;
            for(int i=0;i<size;i++){
                float x=statrx+DisplayUtil.dip2px(mcontext, 20)*i+DisplayUtil.dip2px(mcontext, 3.5f);
                //画实心
                if(i<solidnum){
                    canvas.drawCircle(x,y,radius,solidPaint);
                    //画空心
                }else {
                    canvas.drawCircle(x,y,radius,hollowPaint);
                }
            }
        }
    }

    /***
     *
     * @param solidnum 实心
     * @param hollownum  空心
     */
    public void setSelect(int solidnum, int hollownum) {
        this.solidnum = solidnum;
        this.hollownum = hollownum;
        invalidate();
    }

    /**
     * 支持设置颜色
     * @param red
     * @param green
     * @param blue
     */
    public void setColor(int red, int green, int blue){
        solidPaint.setColor(Color.rgb(red,green,blue));
        hollowPaint.setColor(Color.rgb(red,green,blue));
        invalidate();
    }

}
