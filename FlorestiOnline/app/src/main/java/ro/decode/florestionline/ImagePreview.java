package ro.decode.florestionline;

/**
 * Created by clive on 11-Jun-14.
 */

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by clive on 03-Jun-14.
 * www.101apps.co.za
 */
public class ImagePreview extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_preview);

        int position = getIntent().getIntExtra("position", -1);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);


        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage("http://www.keenthemes.com/preview/metronic/theme/assets/global/plugins/jcrop/demos/demo_files/image1.jpg"
                ,imageView);

    }
}