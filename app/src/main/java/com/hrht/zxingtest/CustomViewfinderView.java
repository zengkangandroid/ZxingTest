package com.hrht.zxingtest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.os.Build;
import android.util.AttributeSet;

import com.google.zxing.ResultPoint;
import com.journeyapps.barcodescanner.ViewfinderView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zengkang on 2018/4/16.
 */

public class CustomViewfinderView extends ViewfinderView {

    public int laserLinePosition=0;
    public float[] position=new float[]{0f,0.5f,1f};
    public int[] colors=new int[]{0x00ffffff,0xffffffff,0x00ffffff};
    public LinearGradient linearGradient ;


    public CustomViewfinderView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    /*@SuppressLint("DrawAllocation")
    @Override

    public void onDraw(Canvas canvas) {
        // 把ViewfinderView里的内容拷贝过来，然后把画线和画点的内容全去掉
        refreshSizes();
        if (framingRect == null || previewFramingRect == null) {
            return;
        }

        Rect frame = framingRect;
        Rect previewFrame = previewFramingRect;

        int width = canvas.getWidth();
        int height = canvas.getHeight();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //绘制扫码框4个边角弧形

            //左上角
            Path ltPath1=new Path();
            Path ltPath2=new Path();
            ltPath1.addRect(frame.left,frame.top,frame.left+20,frame.top+20, Path.Direction.CCW);
            ltPath2.addCircle(frame.left+20,frame.top+20,20, Path.Direction.CCW);
            ltPath1.op(ltPath2, Path.Op.DIFFERENCE);
            canvas.drawPath(ltPath1,paint);
            //右上角
            Path rtPath1=new Path();
            Path rtPath2=new Path();
            rtPath1.addRect(frame.right-20,frame.top,frame.right+1,frame.top+20, Path.Direction.CCW);
            rtPath2.addCircle(frame.right-20,frame.top+20,20, Path.Direction.CCW);
            rtPath1.op(rtPath2, Path.Op.DIFFERENCE);
            canvas.drawPath(rtPath1,paint);
            //左下角
            Path lbPath1=new Path();
            Path lbPath2=new Path();
            lbPath1.addRect(frame.left,frame.bottom-20,frame.left+20,frame.bottom+1, Path.Direction.CCW);
            lbPath2.addCircle(frame.left+20,frame.bottom-20,20, Path.Direction.CCW);
            lbPath1.op(lbPath2, Path.Op.DIFFERENCE);
            canvas.drawPath(lbPath1,paint);
            //右下角
            Path rbPath1=new Path();
            Path rbPath2=new Path();
            rbPath1.addRect(frame.right-20,frame.bottom-20,frame.right+1,frame.bottom+1, Path.Direction.CCW);
            rbPath2.addCircle(frame.right-20,frame.bottom-20,20, Path.Direction.CCW);
            rbPath1.op(rbPath2, Path.Op.DIFFERENCE);
            canvas.drawPath(rbPath1,paint);
        }


        // Draw the exterior (i.e. outside the framing rect) darkened
        paint.setColor(resultBitmap != null ? resultColor : maskColor);
        canvas.drawRect(0, 0, width, frame.top, paint);
        canvas.drawRect(0, frame.top, frame.left, frame.bottom + 1, paint);
        canvas.drawRect(frame.right + 1, frame.top, width, frame.bottom + 1, paint);
        canvas.drawRect(0, frame.bottom + 1, width, height, paint);

        if (resultBitmap != null) {
            // Draw the opaque result bitmap over the scanning rectangle
            paint.setAlpha(CURRENT_POINT_OPACITY);
            canvas.drawBitmap(resultBitmap, null, frame, paint);
        } else {

            // Draw a red "laser scanner" line through the middle to show decoding is active
            paint.setColor(laserColor);
            paint.setAlpha(SCANNER_ALPHA[scannerAlpha]);
            scannerAlpha = (scannerAlpha + 1) % SCANNER_ALPHA.length;
            int middle = frame.height() / 2 + frame.top;
            canvas.drawRect(frame.left + 2, middle - 1, frame.right - 1, middle + 2, paint);

            float scaleX = frame.width() / (float) previewFrame.width();
            float scaleY = frame.height() / (float) previewFrame.height();

            List<ResultPoint> currentPossible = possibleResultPoints;
            List<ResultPoint> currentLast = lastPossibleResultPoints;
            int frameLeft = frame.left;
            int frameTop = frame.top;
            if (currentPossible.isEmpty()) {
                lastPossibleResultPoints = null;
            } else {
                possibleResultPoints = new ArrayList<>(5);
                lastPossibleResultPoints = currentPossible;
                paint.setAlpha(CURRENT_POINT_OPACITY);
                paint.setColor(resultPointColor);
                for (ResultPoint point : currentPossible) {
                    canvas.drawCircle(frameLeft + (int) (point.getX() * scaleX),
                            frameTop + (int) (point.getY() * scaleY),
                            POINT_SIZE, paint);
                }
            }
            if (currentLast != null) {
                paint.setAlpha(CURRENT_POINT_OPACITY / 2);
                paint.setColor(resultPointColor);
                float radius = POINT_SIZE / 2.0f;
                for (ResultPoint point : currentLast) {
                    canvas.drawCircle(frameLeft + (int) (point.getX() * scaleX),
                            frameTop + (int) (point.getY() * scaleY),
                            radius, paint);
                }
            }

            // Request another update at the animation interval, but only repaint the laser line,
            // not the entire viewfinder mask.
            postInvalidateDelayed(ANIMATION_DELAY,
                    frame.left - POINT_SIZE,
                    frame.top - POINT_SIZE,
                    frame.right + POINT_SIZE,
                    frame.bottom + POINT_SIZE);
        }
    }*/


    /**
     * 重写draw方法绘制自己的扫描框
     * @param canvas
     * */

    @Override
    public void onDraw(Canvas canvas) {
        refreshSizes();
        if (framingRect == null || previewFramingRect == null) {
            return;
        }


        Rect frame = framingRect;
        Rect previewFrame = previewFramingRect;


        int width = canvas.getWidth();
        int height = canvas.getHeight();
        //绘制4个角

        paint.setColor(0xFFFFFFFF);//定义画笔的颜色
        canvas.drawRect(frame.left, frame.top, frame.left+30, frame.top+5, paint);
        canvas.drawRect(frame.left, frame.top, frame.left + 5, frame.top + 30, paint);


        canvas.drawRect(frame.right-30, frame.top, frame.right, frame.top+5, paint);
        canvas.drawRect(frame.right-5, frame.top, frame.right, frame.top+30, paint);


        canvas.drawRect(frame.left, frame.bottom-5, frame.left+30, frame.bottom, paint);
        canvas.drawRect(frame.left, frame.bottom-30, frame.left+5, frame.bottom, paint);


        canvas.drawRect(frame.right-30, frame.bottom-5, frame.right, frame.bottom, paint);
        canvas.drawRect(frame.right-5, frame.bottom-30, frame.right, frame.bottom, paint);
        // Draw the exterior (i.e. outside the framing rect) darkened
        paint.setColor(resultBitmap != null ? resultColor : maskColor);
        canvas.drawRect(0, 0, width, frame.top, paint);
        canvas.drawRect(0, frame.top, frame.left, frame.bottom + 1, paint);
        canvas.drawRect(frame.right + 1, frame.top, width, frame.bottom + 1, paint);
        canvas.drawRect(0, frame.bottom + 1, width, height, paint);


        if (resultBitmap != null) {
            // Draw the opaque result bitmap over the scanning rectangle
            paint.setAlpha(CURRENT_POINT_OPACITY);
            canvas.drawBitmap(resultBitmap, null, frame, paint);
        } else {
            //  paint.setAlpha(SCANNER_ALPHA[scannerAlpha]);
            //  scannerAlpha = (scannerAlpha + 1) % SCANNER_ALPHA.length;
            int middle = frame.height() / 2 + frame.top;
            laserLinePosition=laserLinePosition+5;
            if(laserLinePosition>frame.height())
            {
                laserLinePosition=0;
            }
            linearGradient= new LinearGradient(frame.left + 1, frame.top+laserLinePosition , frame.right -1 , frame.top +10+laserLinePosition, colors, position, Shader.TileMode.CLAMP);
            // Draw a red "laser scanner" line through the middle to show decoding is active


            //  paint.setColor(laserColor);
            paint.setShader(linearGradient);
            //绘制扫描线
            canvas.drawRect(frame.left + 1, frame.top+laserLinePosition , frame.right -1 , frame.top +10+laserLinePosition, paint);
            paint.setShader(null);
            float scaleX = frame.width() / (float) previewFrame.width();
            float scaleY = frame.height() / (float) previewFrame.height();


            List<ResultPoint> currentPossible = possibleResultPoints;
            List<ResultPoint> currentLast = lastPossibleResultPoints;
            int frameLeft = frame.left;
            int frameTop = frame.top;
            if (currentPossible.isEmpty()) {
                lastPossibleResultPoints = null;
            } else {
                possibleResultPoints = new ArrayList<>(5);
                lastPossibleResultPoints = currentPossible;
                paint.setAlpha(CURRENT_POINT_OPACITY);
                paint.setColor(resultPointColor);
                for (ResultPoint point : currentPossible) {
                    canvas.drawCircle(frameLeft + (int) (point.getX() * scaleX),
                            frameTop + (int) (point.getY() * scaleY),
                            POINT_SIZE, paint);
                }
            }
            if (currentLast != null) {
                paint.setAlpha(CURRENT_POINT_OPACITY / 2);
                paint.setColor(resultPointColor);
                float radius = POINT_SIZE / 2.0f;
                for (ResultPoint point : currentLast) {
                    canvas.drawCircle(frameLeft + (int) (point.getX() * scaleX),
                            frameTop + (int) (point.getY() * scaleY),
                            radius, paint);
                }
            }
            postInvalidateDelayed(16,
                    frame.left ,
                    frame.top ,
                    frame.right ,
                    frame.bottom);
            // postInvalidate();


        }
    }
}
