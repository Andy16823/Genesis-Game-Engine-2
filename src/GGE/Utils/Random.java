package GGE.Utils;

/**
 * Created by Andreas on 30.08.14.
 */
public class Random extends java.util.Random {

    public int nextInt(int min, int max)
    {
        int rndVal = this.nextInt(max - min);
        return min + rndVal;
    }

}
