package com.example.tag.myguifragmentdynamic02;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by tag on 2017/05/13.
 * 選択された項目の詳細を動的に生成する。
 *
 */

public class MyFragment2 extends Fragment {

    private TextView textView = null;

    //詳細画面の文字列を設定
    public void setContentAtIndex(int newIndex){
        textView.setText(MainActivity.contentArray[newIndex]);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.my_fragment2,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        textView = (TextView)getActivity().findViewById(R.id.fragment2);

    }
}
