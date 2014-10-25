package GGE.Assets;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Vector;

/**
 * Created by Andreas on 14.08.14.
 */
public class AssetLoader {
    private Vector<Asset> Assets;

    public AssetLoader() {
        Assets = new Vector<Asset>();
    }

    public void addAsset(String Name, URL Path)
    {
        Asset asset = new Asset(Name, Path);
        Assets.add(asset);
    }

    public BufferedImage loadAsset(String Name)
    {
        for(Asset asset : Assets)
        {
            if(asset.getName().equals(Name))
            {
                return asset.getImage();
            }
        }
        return null;
    }
}
