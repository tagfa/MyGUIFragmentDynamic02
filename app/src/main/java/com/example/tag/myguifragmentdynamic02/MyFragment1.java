package com.example.tag.myguifragmentdynamic02;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by tag on 2017/05/13.
 * 項目一覧を動的に生成する。
 *
 */

public class MyFragment1 extends ListFragment {

    private ListSelectionListener listener = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //項目クリック時の処理
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Toast.makeText(getActivity(),"position="+position,Toast.LENGTH_SHORT);

        listener.onListSelection(position);

    }

    //Android6.0以上では、onAttach(Activity activity)は非推奨
    //Android6.0未満の場合、onAttach(Activity activity)しか呼ばれない
    //
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        listener=(ListSelectionListener)activity;
    }

    //Android6.0以上は
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener=(ListSelectionListener)context;
    }

    //一覧画面の表示
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(getActivity(),R.layout.my_fragment1_item,
                MainActivity.titleArray));

        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);

    }
}

