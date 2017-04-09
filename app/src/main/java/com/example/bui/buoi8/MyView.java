package com.example.bui.buoi8;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import java.util.Calendar;

import static com.example.bui.buoi8.R.id.txtTime;

/**
 * Created by bui on 06-Apr-17.
 */

public class MyView extends View implements Runnable {
    private int hours , minute , secount;
    private Calendar calendar;
    private Paint paint;
    @RequiresApi(api = Build.VERSION_CODES.N)
    public MyView(Context context) {
        super(context);
        init();
    }



    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {

        paint = new Paint();
         paint.setTextSize(100);
        paint.setStrokeWidth(20);
        paint.setColor(Color.BLACK);
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String tex = hours + " : " + minute + " : "+ secount;
        canvas.drawText(tex ,100 , 150 , paint);
    }



    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            calendar = Calendar.getInstance();
            hours = calendar.get(Calendar.HOUR);
            minute = calendar.get(Calendar.MINUTE);
            secount = calendar.get(Calendar.SECOND);
            postInvalidate();


        }
    }
}
