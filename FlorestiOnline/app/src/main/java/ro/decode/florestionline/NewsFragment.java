package ro.decode.florestionline;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    List<Article> articleList;

    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);


        final EditText editText = ( EditText ) view.findViewById(R.id.editText);

        editText.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
        editText.setSingleLine(true);

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                    InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    v.clearFocus();
                    //performSearch();
                    return true;
                }
                return false;
            }
        });


        ////



        ListView articleListView=(ListView) view.findViewById(R.id.lv_nonscroll_list);

        //later to be replaced with controller class
        articleList = new ArrayList<Article>();

        //Create test thermostats with ids
        Article temp = new Article();
        //temp.setName("Test1");
        articleList.add(temp);



        //Create test thermostats with ids
        temp = new Article();
        //temp.setName("Test1");
        articleList.add(temp);

//Create test thermostats with ids
        temp = new Article();
        //temp.setName("Test1");
        articleList.add(temp);

//Create test thermostats with ids
        temp = new Article();
        //temp.setName("Test1");
        articleList.add(temp);

//Create test thermostats with ids
        temp = new Article();
        //temp.setName("Test1");
        articleList.add(temp);




        // Create The Adapter with passing ArrayList as 3rd parameter
        ArticleAdapter arrayAdapter =
                new ArticleAdapter(getActivity(), R.layout.article_listview_item, articleList);

        // Set The Adapter
        articleListView.setAdapter(arrayAdapter);


        articleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getActivity(), ViewArticle.class);
                startActivity(intent);

            }
        });





        return view;
    }


}
