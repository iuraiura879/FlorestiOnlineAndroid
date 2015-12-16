package ro.decode.florestionline;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainFragment extends Fragment {


    public MainFragment() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.content_main, container, false);


        //Layout, to be a fragment

        ListView yourListView = (ListView) v.findViewById(R.id.listView);
        yourListView.setFocusable(false);
        List<NewsOrReport> l = new ArrayList<NewsOrReport>();
        // get data from the table by the ListAdapter

        NewsOrReport temp = new NewsOrReport();
        temp.setYear(2015);
        temp.setDate(05);
        temp.setMonth(10);
        temp.setTitle("Lorem isprum dolor sit");
        temp.setShortText("Vivamus consequat fringilla  lorem, at accumsan leo  Posuere id.");
        l.add(temp);
        l.add(temp);
        l.add(temp);

        AllTogetherAdapter customAdapter = new AllTogetherAdapter(getContext(), R.layout.news_or_report_gray, l);

        yourListView .setAdapter(customAdapter);
        yourListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if( position == 0 )
                    ((MainActivity)getActivity()).openNewsDetail();
                else
                    ((MainActivity)getActivity()).openReportDetail();



            }
        });


        ////


        yourListView = (ListView) v.findViewById(R.id.listView2);
        yourListView.setFocusable(false);
        List<Sponsor> li = new ArrayList<Sponsor>();
        // get data from the table by the ListAdapter

        Sponsor temp2 = new Sponsor();
        temp2.setName("Gradina Floresti");
        temp2.setPhoneNumber("+40 0748 836 524");
        temp2.setAdreess("strada Eroilor, nr 145B");
        li.add(temp2);
        li.add(temp2);
        li.add(temp2);

        SponsorAdapter customAdapter2 = new SponsorAdapter(getContext(), R.layout.sponsored_green, li);

        yourListView .setAdapter(customAdapter2);
        yourListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    ((MainActivity) getActivity()).openServiceDetail();



            }
        });

        return v;
    }


    @Override
    public void onResume() {
        super.onResume();

        MainActivity.state = 1;

        Toolbar toolbarTop = (Toolbar) getActivity().findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbarTop.findViewById(R.id.toolbar_title);
        mTitle.setText(this.getString(R.string.main_name));

    }
}
