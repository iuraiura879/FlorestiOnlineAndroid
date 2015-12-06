package ro.decode.florestionline;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import ro.decode.florestionline.Article;
import ro.decode.florestionline.R;

public class ArticleAdapter extends ArrayAdapter<Article> {

    public ArticleAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public ArticleAdapter(Context context, int resource, List<Article> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater vi;
        vi = LayoutInflater.from(getContext());
        View v = vi.inflate(R.layout.article_listview_item, null);


      //  ( (TextView) v.findViewById(R.id.textView24)).setText(getItem(position).getName());


        return v;
    }




}