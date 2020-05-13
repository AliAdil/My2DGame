package com.example.my2dgame;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread extends Thread {
    private SurfaceHolder surfaceHolder;
    private GameView gameView;
    private boolean running;
    public static Canvas canvas;

    public MainThread(SurfaceHolder surfaceHolder, GameView gameView) {
        super();
        this.surfaceHolder = surfaceHolder;
        this.gameView = gameView;
    }
    public  void  setRunning (Boolean isRunning){
        running = isRunning;
    }

    @Override
    public void run(){
        while (running){
            canvas = null;
            try {
                // locking canvas it prevent more than one threads from attempting to draw on it 
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder){
                    this.gameView.update();
                    this.gameView.draw(canvas);

                }
            }
            catch (Exception e){


            }
            finally{
                if(canvas != null){
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

