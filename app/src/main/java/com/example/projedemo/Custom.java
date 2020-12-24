package com.example.projedemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Custom extends Fragment {

    private static String medicineName;
    private static String medicine;
    private Button sound, repeat;

    public static Custom newInstance(String s) {

        Bundle args = new Bundle();
        args.putString("ilacI", medicineName);
        args.putString("ilac",medicine);
        Custom fragment = new Custom();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        medicineName = getArguments().getString("ilacI");
        medicine = getArguments().getString("ilac");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.layout_once, container, false);
        TextView med = view.findViewById(R.id.tv_name);
        med.setText(medicineName);
        EditText emp = view.findViewById(R.id.et_med);
        emp.setText(medicine);

        Button button = (Button) view.findViewById(R.id.bt_sound);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()){
                    case R.id.bt_sound: {
                        Intent intent = new Intent(getActivity(), Sounds.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.bt_repeat: {
                        Intent intent = new Intent(getActivity(), Repeat.class);
                        startActivity(intent);
                        break;
                    }
                }


            }
        });

        return view;
    }
}
