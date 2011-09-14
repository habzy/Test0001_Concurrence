package com.habzy;

import java.util.Timer;
import java.util.TimerTask;

//import com.habzy.concurrence1.Thread4Lock;
import com.habzy.concurrence2.Thread4BlockingQueue;
import com.habzy.log.Log;

/**
 * 
 * One sentence description Detailed description
 * 
 * @author habzy
 * @version [version, 2011-9-8]
 * @see [relevant class/method]
 * @since [product/module version]
 */
public class TestMain
{
    private static String TAG = "TesMain";
    
    public static void main(String[] args)
    {
        startTimer(10000);
        concurrence1();
        concurrence2();
    }
    
    private static void concurrence1()
    {
//                new Thread4Lock().start();
//                new Thread4Lock().start();
        
        //        new ThreadVolatile(false).start();
        //        new ThreadVolatile(true).start();
        
        //        new Thread4SynchronizedInnerObject().start();
        
        //        new Thread4InterruptOrInterrupted().start();
    }
    
    private static void concurrence2()
    {
//        new ThreadNotifyOrAll();
        
        new Thread4BlockingQueue().start();
        new Thread4BlockingQueue().start();
    }
    
    /**
     * 
     */
    private static void startTimer(final long longTime)
    {
        Thread timerThread = new Thread()
        {
            public void run()
            {
                Log.log(TAG, "*************= Timer for system exit remain:"
                        + longTime / 1000 + " seconds =*************");
                new Timer().schedule(new TimerTask()
                {
                    @Override
                    public void run()
                    {
                        Log.log(TAG, "exit");
                        System.exit(0);
                    }
                }, longTime);
                long i = longTime;
                while (true)
                {
                    try
                    {
                        sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    Log.log(TAG, "*************= Timer for system exit remain:"
                            + (i -= 1000) / 1000 + " seconds =*************");
                }
            };
        };
        timerThread.setDaemon(true);
        timerThread.start();
    }
    
}
