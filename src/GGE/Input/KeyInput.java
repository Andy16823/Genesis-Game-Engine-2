package GGE.Input;

/**
 * Created by Andreas on 24.08.14.
 */
public class KeyInput {
    private int Key;

    public KeyInput(int key) {
        Key = key;
    }

    public KeyInput() {
    }

    public int getKey() {
        return Key;
    }

    public void setKey(int key) {
        Key = key;
    }

    public void releaseKey()
    {
        this.Key = 0;
    }
}
