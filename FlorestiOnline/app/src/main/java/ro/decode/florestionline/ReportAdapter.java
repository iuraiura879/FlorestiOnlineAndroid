package ro.decode.florestionline;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ReportAdapter extends ArrayAdapter<Article> {

    public ReportAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public ReportAdapter(Context context, int resource, List<Article> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater vi;
        vi = LayoutInflater.from(getContext());
        View v = vi.inflate(R.layout.report_listview_item, null);


        Typeface custom_font = Typeface.createFromAsset(getContext().getAssets(), "fonts/sosa.ttf");

        TextView contulMeu_icon=(TextView) v.findViewById(R.id.textView10);
        contulMeu_icon.setTypeface(custom_font);

      //  ( (TextView) v.findViewById(R.id.textView24)).setText(getItem(position).getName());


        return v;
    }




}