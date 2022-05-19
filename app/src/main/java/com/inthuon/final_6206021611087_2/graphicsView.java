package com.inthuon.final_6206021611087_2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

class graphicsView extends View implements View.OnTouchListener {

    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

    private String drawType = "Line";
    private String colorText = "RED";

    private Paint mPaint, mPaintStroke;

    public graphicsView(Context context) {
        super(context);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setOnTouchListener(this);
        mPaint = new Paint();
        mPaintStroke = new Paint();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        float x = event.getX();
        float y = event.getY();

        if(x > 0 && x < 200){
            if(y > 0 && y < 100){
                drawType = "Line";
            }
        }
        else if (x > 200 && x < 400){
            if(y > 0 && y < 100){
                drawType = "Rectangle";
            }
        }
        else if (x > 400 && x < 600){
            if(y > 0 && y < 100){
                drawType = "Circle";
            }
        }

        // Color Button
        if( x > screenWidth / 2 -300 && x < screenWidth / 2 - 150){
            colorText = "RED";
        }
        else if (x > screenWidth / 2 - 150  && x < screenWidth / 2){
            colorText = "GREEN";
        }
        else if (x > screenWidth / 2 && x < screenWidth + 150 ){
            colorText = "BLUE";
        }
        invalidate();

        Log.d("TYPE" , drawType);
        Log.d("COLOR" , colorText);
        Log.d("POSITION" , x + " x " + y);
        return true;
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.YELLOW);

        mPaintStroke.setColor(Color.BLACK);
        mPaintStroke.setStyle(Paint.Style.STROKE);
        mPaintStroke.setStrokeWidth(4);

        canvas.drawRect(screenWidth / 2 + 500, 0, screenWidth, 100, mPaint);
        canvas.drawRect(screenWidth / 2 + 500, 0, screenWidth, 100, mPaintStroke);
        mPaint.setTextSize(35);
        mPaint.setColor(Color.BLACK);
        canvas.drawText("62-060216-11087 Inthu-on Sonthisuwan", screenWidth / 2 + 550, 55, mPaint);

        // Line
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0 , 0 , 200 , 100 , mPaint);
        canvas.drawRect(0,0,200,100,mPaintStroke);
        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(40);
        canvas.drawText("LINE" , 50 , 60 , mPaint);

        // Rectangle
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(200 , 0 , 400 , 100 , mPaint);
        canvas.drawRect(200,0,400,100,mPaintStroke);
        mPaint.setTextSize(30);
        mPaint.setColor(Color.BLACK);
        canvas.drawText("Rectangle" , 230 , 60 , mPaint);

        // Circle
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(400 , 0 , 600 , 100 , mPaint);
        canvas.drawRect(400,0,600,100,mPaintStroke);
        mPaint.setTextSize(35);
        mPaint.setColor(Color.BLACK);
        canvas.drawText("Circle" , 440 , 60 , mPaint);

        // Type Rec
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(600 , 0 , 800 , 100 , mPaint);
        canvas.drawRect(600,0,800,100,mPaintStroke);
        mPaint.setTextSize(35);
        mPaint.setColor(Color.RED);
        canvas.drawText(drawType , 630 , 60 , mPaint);

        // Color Red
        mPaint.setColor(Color.RED);
        canvas.drawRect(screenWidth/2 -300 , 0 , screenWidth/2 - 150 , 100 , mPaint);
        canvas.drawRect(screenWidth/2 -300 , 0 , screenWidth/2 - 150 , 100 , mPaintStroke);

        // Color Green
        mPaint.setColor(Color.GREEN);
        canvas.drawRect(screenWidth/2 -150 , 0 , screenWidth/2 , 100 , mPaint);
        canvas.drawRect(screenWidth/2 -150 , 0 , screenWidth/2 , 100 , mPaintStroke);

        // Color Blue
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(screenWidth/2  , 0 , screenWidth/2 + 150 , 100 , mPaint);
        canvas.drawRect(screenWidth/2  , 0 , screenWidth/2 + 150 , 100 , mPaintStroke);

        // Text Color
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(screenWidth/2 + 150  , 0 , screenWidth/2 + 300 , 100 , mPaint);
        canvas.drawRect(screenWidth/2 + 150 , 0 , screenWidth/2 + 300 , 100 , mPaintStroke);
        mPaint.setColor(Color.BLACK);
        canvas.drawText(colorText , screenWidth / 2 + 180 , 60 , mPaint);
    }
}