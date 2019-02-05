package ru.startandroid.p1091_listfragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainList extends ListFragment {
    String data[] = new String[] { "one", "two", "three", "four" };

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_multiple_choice, data);
//layout.simple_list_item_activated_1
//layout.simple_list_item_1
//simple_list_item_single_choice
//simple_list_item_multiple_choice

        setListAdapter(adapter);
        getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        //CHOICE_MODE_MULTIPLE
        //CHOICE_MODE_SINGLE
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment, null);
    }
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
   
        Toast.makeText(getActivity(), "position = " + getListView().getItemAtPosition(position), Toast.LENGTH_SHORT).show();
    }
}