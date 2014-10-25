package GGE.Animation;

/**
 * Created by Andreas on 17.08.14.
 */
public class AsyncAnimationPlayer extends Thread {
    private Animation AnimationSource;
    private boolean play;
    private boolean allive;

    public AsyncAnimationPlayer(Animation animationSource) {
        AnimationSource = animationSource;
    }

    public void stopAnimation()
    {
        if(this.play)
        {
            this.play = false;
            this.allive = false;
        }
    }

    public boolean isAllive() {
        return allive;
    }

    @Override
    public void run() {
        super.run();
        this.play = true;
        this.allive = true;
        while(this.play)
        {
            if(this.play && this.AnimationSource.getAnimationImageIndex() < this.AnimationSource.getAnimationImages().size())
            {
                this.AnimationSource.getAnimationTarget().setTexture(this.AnimationSource.getAnimationImages().get(this.AnimationSource.getAnimationImageIndex()));
                this.AnimationSource.setAnimationImageIndex(this.AnimationSource.getAnimationImageIndex() +1);
                if(this.AnimationSource.getAnimationImageIndex() == this.AnimationSource.getAnimationImages().size() && this.AnimationSource.getPlayMode() == PlayModes.RandomPlay)
                {
                    this.AnimationSource.setAnimationImageIndex(0);
                }
            }
        }
    }
}
