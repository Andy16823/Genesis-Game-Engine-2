package GGE.Utils;

/**
 * Created by Andreas on 14.08.14.
 */
public class Stopwatch {
    private long StartTimeStamp;
    private long StopTimeStamp;
    private boolean Run;

    public Stopwatch() {

    }

    public void  start()
    {
        if(!Run)
        {
            this.StartTimeStamp = System.currentTimeMillis();
            this.Run = true;
        }
        else
        {
            try {
                throw new Exception("the stopwatch are running");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void stop()
    {
        if(Run)
        {
            this.StopTimeStamp = System.currentTimeMillis();
            this.Run = false;
        }
        else
        {
            try {
                throw new Exception("the stopwatch dosen't run");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void reset()
    {
        this.StartTimeStamp = 0;
        this.StopTimeStamp = 0;
        this.Run = false;
    }

    public long elapsed()
    {
        if(this.Run)
        {
            return System.currentTimeMillis() - this.StartTimeStamp;
        }
        else
        {
            return this.StopTimeStamp - this.StartTimeStamp;
        }
    }

}
