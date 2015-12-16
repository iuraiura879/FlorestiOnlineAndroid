package ro.decode.florestionline;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReportListFragment extends Fragment {

    RecyclerView mRecyclerView;
    LinearLayoutManager mLayoutManager;
    AllReportsAdapter mAdapter;
    List<NewsOrReport> myDataset;

    public ReportListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_article_list, container, false);


        mRecyclerView = (RecyclerView) v.findViewById(R.id.my_recicler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);


        myDataset = new ArrayList<NewsOrReport>();
        // get data from the table by the ListAdapter

        NewsOrReport temp = new NewsOrReport();
        temp.setYear(2015);
        temp.setDate(05);
        temp.setMonth(10);
        temp.setTitle("Lorem isprum dolor sit");
        temp.setShortText("Vivamus consequat fringilla  lorem, at accumsan leo  Posuere id.");
        myDataset.add(temp);
        myDataset.add(temp);
        myDataset.add(temp);
        myDataset.add(temp);

        // specify an adapter (see also next example)
        mAdapter = new AllReportsAdapter(myDataset, getActivity());
        mRecyclerView.setAdapter(mAdapter);


        return v;
    }


    @Override
    public void onResume() {
        super.onResume();

        MainActivity.state = 2;
        Toolbar toolbarTop = (Toolbar) getActivity().findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbarTop.findViewById(R.id.toolbar_title);
        mTitle.setText("RAPORTURI");

    }

}
