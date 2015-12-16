package ro.decode.florestionline;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by iuragutu on 07/12/15.
 */

public class AllNewsAdapter extends RecyclerView.Adapter<AllNewsAdapter.ViewHolder> {
    private List<NewsOrReport> mDataset;
    private Activity mAct;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public RelativeLayout mLay;
        public IMyViewHolderClicks mListener;

        public ViewHolder(RelativeLayout v) {
            super(v);
            mLay = v;
            v.setOnClickListener(this);

        }

        public ViewHolder(RelativeLayout v, IMyViewHolderClicks listener) {

            super(v);
            mLay = v;

            mListener = listener;
            v.setOnClickListener(this);

        }

        public void setmListener(IMyViewHolderClicks mListener) {
            this.mListener = mListener;
        }

        @Override
        public void onClick(View v) {
            mListener.onClick(v);
        }

        public static interface IMyViewHolderClicks {
            int pos = 0;
            public void onClick(View caller);

        }


    }

    @Override
    public int getItemViewType(int position) {
        int viewType = 0;

        if(position > 0 && position < mDataset.size()-1)
            viewType = 1;

        if( position == mDataset.size()-1)
            viewType = 2;
        // add here your booleans or switch() to set viewType at your needed
        // I.E if (position == 0) viewType = 1; etc. etc.
        return viewType;
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public AllNewsAdapter(List<NewsOrReport> myDataset, Activity act) {
        mDataset = myDataset;
        mAct = act;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AllNewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = null;

        if( viewType == 0)
            v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.back_list_item, parent, false);

        if( viewType == 1)
            v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.simple_item_news, parent, false);

        if( viewType == 2)
            v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.simple_item_news_bottom, parent, false);
        // set the view's size, margins, paddings and layout parameters


        ViewHolder vh = new ViewHolder((RelativeLayout) v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        //holder.mTextView.setText(mDataset.get(position));

        ViewHolder.IMyViewHolderClicks listener = new ViewHolder.IMyViewHolderClicks() {
            @Override
            public void onClick(View caller) {
                if(pos > 0)
                {

                    ((MainActivity)mAct).openNewsDetail();

                }
            }

            int pos = position;
        };



        holder.setmListener(listener);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}