package ro.decode.florestionline;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by iuragutu on 15/12/15.
 */




//    our custom adapter
class ImageAdapter extends BaseAdapter {

    DisplayImageOptions options;
    private ImageLoader imageLoader;
    Activity context;

    ImageAdapter( Activity ctx, ImageLoader ldr, DisplayImageOptions opt){
        context= ctx;
        options = opt;
        imageLoader = ldr;

    }
    @Override
    public int getCount() {
        return 2;//mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView,
                        ViewGroup parent) {
        View view = convertView;
        final ViewHolder gridViewImageHolder;
//            check to see if we have a view
        if (convertView == null) {
//                no view - so create a new one
            view = context.getLayoutInflater().inflate(R.layout.thumb, parent, false);
            gridViewImageHolder = new ViewHolder();
            gridViewImageHolder.imageView = (ImageView) view.findViewById(R.id.image);
            gridViewImageHolder.imageView.setMaxHeight(80);
            gridViewImageHolder.imageView.setMaxWidth(80);
            view.setTag(gridViewImageHolder);
        } else {
//                we've got a view
            gridViewImageHolder = (ViewHolder) view.getTag();
        }
        imageLoader.displayImage("http://www.keenthemes.com/preview/metronic/theme/assets/global/plugins/jcrop/demos/demo_files/image1.jpg"
                ,gridViewImageHolder.imageView
                ,options);

        return view;
    }
}

