package com.corefield.arch.Fragment;


import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.corefield.arch.DATABASE.DatabaseHelper;
import com.corefield.arch.DATABASE.DatabaseManager;
import com.corefield.arch.R;



import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {
    private View mRootview;
    private DatabaseManager dbManager;
    private SimpleCursorAdapter adapter;

    final String[] from = new String[]
            {

            DatabaseHelper._ID,
            DatabaseHelper.NAME,
            String.valueOf(DatabaseHelper.MARKS)
            };

    final int[] to = new int[]
            {
                    R.id.id,
                    R.id.name,
                    R.id.mark
            };

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)

    {

        // Inflate the layout for this fragment
        mRootview = inflater.inflate(R.layout.fragment_list, container, false);


        ArrayList<String> arrayList = new ArrayList<>();

        dbManager = new DatabaseManager(getActivity());
        dbManager.open();
        Cursor cursor = dbManager.fetch();
        final ListView list = mRootview.findViewById(R.id.list_view);

        // list.setEmptyView(mRootview.findViewById(R.id.empty));
        adapter = new SimpleCursorAdapter(getActivity(), R.layout.listview_custom, cursor, from, to, 0);
        adapter.notifyDataSetChanged();
        list.setAdapter(adapter);
        return mRootview;
    }

}
