package ro.decode.florestionline;


import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReportPhoto extends Fragment {


    public ReportPhoto() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_report_photo, container, false);

        Typeface custom_font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/sosa.ttf");

        TextView contulMeu_icon=(TextView) view.findViewById(R.id.textView6);
        contulMeu_icon.setTypeface(custom_font);


        Button location=(Button) view.findViewById(R.id.button3);
        location.setTypeface(custom_font);


        return view;
    }


}
