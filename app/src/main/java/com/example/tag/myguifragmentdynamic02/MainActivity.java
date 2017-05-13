package com.example.tag.myguifragmentdynamic02;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//項目一覧を動的に作成し表示する。
//項目が選択されたら、詳細を動的に作成し表示する。

public class MainActivity extends AppCompatActivity implements ListSelectionListener{

    public static String[] titleArray;
    public static String[] contentArray;

    private FragmentManager fragmentManager;

    //初期状態の画面（一覧）を作成
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //画面表示用文字列を取得
        titleArray   = getResources().getStringArray(R.array.Titles);
        contentArray = getResources().getStringArray(R.array.Contents);

        //(1)FragmentManegerを取得
        fragmentManager = getFragmentManager();

        //(2)fragmentTransactionを開始
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //(3)一覧表示のFragmentオブジェクトを作成
        MyFragment1 myFragment1 = new MyFragment1();

        //(4)一覧をレイアウトの指定位置に設定
        fragmentTransaction.add(R.id.fragment1,myFragment1);

        //(5)Transactionを終了
        fragmentTransaction.commit();

    }

    //項目選択時の処理
    //詳細画面を表示
    @Override
    public void onListSelection(int index) {

        //(2)fragmentTransactionを開始
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //(3)詳細表示のFragmentオブジェクトを作成
        MyFragment2 myFragment2 = new MyFragment2();

        //(4)一覧を詳細に置き換え
        fragmentTransaction.replace(R.id.fragment1,myFragment2);

        //戻るボタンを押したときの処理用に元のトランザクションを保存
        fragmentTransaction.addToBackStack(null);

        //(5)Transactionを終了
        fragmentTransaction.commit();

        //トランザクションを強制実行
        fragmentManager.executePendingTransactions();

        //選択した項目の内容を表示
        myFragment2.setContentAtIndex(index);

    }
}
