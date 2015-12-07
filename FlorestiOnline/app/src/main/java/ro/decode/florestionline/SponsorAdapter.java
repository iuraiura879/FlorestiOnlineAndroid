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


public class SponsorAdapter extends ArrayAdapter<Sponsor> {

    public SponsorAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public SponsorAdapter(Context context, int resource, List<Sponsor> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());


                v = vi.inflate(R.layout.sponsored_green, null);

        }

        Sponsor p = getItem(position);

        if (p != null) {
            TextView title = (TextView) v.findViewById(R.id.title);
            TextView adress = (TextView) v.findViewById(R.id.adress);
            TextView phone = (TextView) v.findViewById(R.id.phone);

            if (title != null) {
                title.setText(p.getName());
            }

            if (adress != null) {
                adress.setText(p.getAdreess());
            }

            if (phone != null) {
                phone.setText(p.getPhoneNumber());
            }



        }

        return v;
    }

}
