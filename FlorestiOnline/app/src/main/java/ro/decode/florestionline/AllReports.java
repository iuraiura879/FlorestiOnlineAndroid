package ro.decode.florestionline;


import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllReports extends Fragment {

    List<Article> reportList;

    public AllReports() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_reports, container, false);

        Typeface custom_font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/sosa.ttf");

        TextView contulMeu_icon=(TextView) view.findViewById(R.id.textView);
        contulMeu_icon.setTypeface(custom_font);



        ListView articleListView=(ListView) view.findViewById(R.id.lv_nonscroll_list);

        //later to be replaced with controller class
        reportList = new ArrayList<Article>();

        //Create test thermostats with ids
        Article temp = new Article();
        //temp.setName("Test1");
        reportList.add(temp);

        //Create test thermostats with ids
        temp = new Article();
        //temp.setName("Test1");
        reportList.add(temp);


        //Create test thermostats with ids
        temp = new Article();
        //temp.setName("Test1");
        reportList.add(temp);

        //Create test thermostats with ids
        temp = new Article();
        //temp.setName("Test1");
        reportList.add(temp);

        //Create test thermostats with ids
        temp = new Article();
        //temp.setName("Test1");
        reportList.add(temp);

        //Create test thermostats with ids
        temp = new Article();
        //temp.setName("Test1");
        reportList.add(temp);
        // Create The Adapter with passing ArrayList as 3rd parameter
        ReportAdapter arrayAdapter =
                new ReportAdapter(getActivity(), R.layout.report_listview_item, reportList);

        // Set The Adapter
        articleListView.setAdapter(arrayAdapter);


        return view;
    }


}
