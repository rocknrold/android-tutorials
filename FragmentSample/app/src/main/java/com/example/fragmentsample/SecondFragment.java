package com.example.fragmentsample;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link SecondFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class SecondFragment extends Fragment {

    private static final String COMMON_TAG = "StateIn";
    public static final String FRAGMENT_NAME = SecondFragment.class.getSimpleName();
    public static final String TAG = COMMON_TAG;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG, FRAGMENT_NAME+" is onAttach");
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, FRAGMENT_NAME+" is onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, FRAGMENT_NAME+" is onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, FRAGMENT_NAME+" is onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, FRAGMENT_NAME+" is onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, FRAGMENT_NAME+" is onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, FRAGMENT_NAME+" is onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, FRAGMENT_NAME+" is onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, FRAGMENT_NAME+" is onDetach");
    }
}