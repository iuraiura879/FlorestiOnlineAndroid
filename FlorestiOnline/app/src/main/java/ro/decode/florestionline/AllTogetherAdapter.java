package ro.decode.florestionline;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by iuragutu on 06/12/15.
 */


public class AllTogetherAdapter extends ArrayAdapter<NewsOrReport> {

    public AllTogetherAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public AllTogetherAdapter(Context context, int resource, List<NewsOrReport> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());

            if(position % 3 == 0)
                v = vi.inflate(R.layout.news_or_report_green, null);
            else
            if(position % 3 == 1)
                v = vi.inflate(R.layout.news_or_report_gray, null);
            else
                v = vi.inflate(R.layout.news_or_report_brown, null);
        }

        NewsOrReport p = getItem(position);

        if (p != null) {
            TextView year = (TextView) v.findViewById(R.id.year);
            TextView date = (TextView) v.findViewById(R.id.date);
            TextView title = (TextView) v.findViewById(R.id.title);
            TextView description = (TextView) v.findViewById(R.id.description);

            if (year != null) {
                year.setText(Integer.toString(p.getYear()));
            }

            if (date != null) {
                date.setText(String.format("%02d", p.getDate())+"/"+p.getMonth());
            }

            if (title != null) {
                title.setText(p.getTitle());
            }

            if (description != null) {
                description.setText(p.getShortText());
            }

        }

        return v;
    }

}
