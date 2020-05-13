package com.example.my2dgame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class CharacterSprite {
    private Bitmap image;
    private int y, x;
    private int xVelocity = 10;
    private int yVelocity = 5;
    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

    public CharacterSprite(Bitmap bmp) {
        image = bmp;
        x = 100;
        y = 100;
    }

    public void draw(Canvas canvas) {
        if (image != null) {
            canvas.drawBitmap(image, x, y, null);
        } else {
            canvas.drawColor(Color.WHITE);
            Paint paint = new Paint();
            paint.setColor(Color.rgb(10, 100, 150));
            canvas.drawRect(0, 0, 200 + y, 200 + y, paint);

        }
    }

    public void update() {

        if (x < 0 && y < 0) {
            x = screenWidth / 2;
            y = screenHeight / 2;
        } else {
            x += xVelocity;
            y += yVelocity;

            if ((x > screenWidth - image.getWidth()) || (x < 0)) {
                xVelocity = xVelocity * -1;
            }
            if ((y > screenHeight - image.getHeight()) || (y < 0)) {
                yVelocity = yVelocity * -1;
            }

        }

    }

/*    public void draw(Canvas canvas) {
        if (image != null) {
            canvas.drawBitmap(image, 0, 0, null);
        } else {
            canvas.drawColor(Color.WHITE);
            Paint paint = new Paint();
            paint.setColor(Color.rgb(10, 100, 150));
            canvas.drawRect(0,  0, 200+y, 200+y, paint);

        }
    }
    public  void update(){
        y++;
    };*/
}
