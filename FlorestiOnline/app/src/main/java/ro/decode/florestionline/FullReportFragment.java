package ro.decode.florestionline;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;


/**
 * A simple {@link Fragment} subclass.
 */
public class FullReportFragment extends Fragment {


    DisplayImageOptions options;
    private ImageLoader imageLoader;

    public FullReportFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_full_report, container, false);


        imageLoader = ImageLoader.getInstance();

//        set options for image display
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.place_holder)
                .showImageForEmptyUri(R.drawable.hand)
                .showImageOnFail(R.drawable.big_problem)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();

        final GridView gridview = (GridView) v.findViewById(R.id.gridView);
        gridview.setAdapter(new ImageAdapter(getActivity(),imageLoader,options));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                gridview.getAdapter().getItem(position);
                Intent intent = new Intent(getActivity(), ImagePreview.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });


        return v;
    }



    @Override
    public void onResume() {
        super.onResume();
        MainActivity.state = 3;
        Toolbar toolbarTop = (Toolbar) getActivity().findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbarTop.findViewById(R.id.toolbar_title);
        mTitle.setText("REPORT");

    }

}
