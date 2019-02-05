package ru.startandroid.p1091_listfragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainList extends ListFragment {
    String data[] = new String[] { "one", "two", "three", "four" };

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, data);
//layout.simple_list_item_activated_1
//layout.simple_list_item_1


        setListAdapter(adapter);
        getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment, null);
    }
}