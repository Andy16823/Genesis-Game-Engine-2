package GGE.Core;

/**
 * Created by Andreas on 13.08.14.
 */
public class Timer extends Thread {
    private long Intervall;
    private GamePanel Panel;
    private boolean Run;

    public Timer(long intervall, GamePanel panel) {
        Intervall = intervall;
        Panel = panel;
    }

    public void timerStop()
    {
        this.Run = false;
    }

    @Override
    public void run() {
        this.Run = true;
        while(Run)
        {
            try {
                Thread.sleep(this.Intervall);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.Panel.repaint();
            this.Panel.Update();

        }
    }
}
