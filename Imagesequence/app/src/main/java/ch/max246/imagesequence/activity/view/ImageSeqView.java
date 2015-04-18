package ch.max246.imagesequence.activity.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by christian on 18/04/15.
 */
public class ImageSeqView extends View {

    private int[] mAnimation;
    private int mTotalFrames = 0;
    private int mIndex = 0;

    private Bitmap mBitmap;

    private boolean doDraw  = false;
    private boolean doNext = false;

    private int mHeight, mWidth;
    private Rect mRectDest;
    private Rect mRectSrc;

    private Paint mPaint;

    public ImageSeqView(Context context) {
        super(context);

    }

    public ImageSeqView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public ImageSeqView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }

    private void init() {
        mHeight = getHeight();
        mWidth = getWidth();
        mRectDest = new Rect(0,0,mWidth,mHeight);
        if (mHeight > 0) doDraw = true;
    }

    public void loadAnimation(int res[]) {

        mAnimation = res;
        mIndex = 0;
        mTotalFrames = mAnimation.length;
        doNext = true;

        mPaint = new Paint();

    }

    private void nextDrawable() {
        if (mBitmap != null) {
            mBitmap.recycle();
            mBitmap = null;
        }
        mBitmap = BitmapFactory.decodeResource(getResources(), mAnimation[mIndex]);
        mIndex++;
        if (mIndex >= mTotalFrames) {
            mIndex = mTotalFrames - 1;
            doNext = false;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //Do init until the canvas is not ready

        if (mWidth == 0) init();
        //Skip the draw until its ready
        if (!doDraw)
            return;


        if (mTotalFrames > 0) {
            //Get the next frame
            if (doNext) nextDrawable();
            if (mBitmap != null) { //Draw animations
                if (mBitmap.getWidth() > mWidth || mBitmap.getHeight() > mHeight) {
                    mRectSrc = new Rect(0, 0, mBitmap.getWidth(), mBitmap.getHeight());
                    if (mWidth >  mBitmap.getWidth()) {
                        mRectDest.right = mBitmap.getWidth();
                    }
                    if (mHeight > mBitmap.getHeight()) {
                        mRectDest.bottom = mBitmap.getHeight();
                    }

                    canvas.drawBitmap(mBitmap, mRectSrc, mRectDest, mPaint);
                } else
                    canvas.drawBitmap(mBitmap, 0, 0, mPaint);
            }
            invalidate();
        }

        try {
            Thread.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void recycle() {
        if (mBitmap != null) {
            mBitmap.recycle();
            mBitmap = null;
        }
    }
}
