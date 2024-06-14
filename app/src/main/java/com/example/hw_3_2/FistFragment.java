package com.example.hw_3_2;

import static com.example.hw_3_2.R.drawable.ic_background;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FistFragment extends Fragment {
    private Button btn_plus, btn_minos;
    private TextView tv_result;
    private ConstraintLayout conteiner;
    private int count = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fist, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initListener();
        updateText();
    }

    private void initView(View view) {
        btn_plus = view.findViewById(R.id.btn_plusOne);
        btn_minos = view.findViewById(R.id.btn_minosOne);
        tv_result = view.findViewById(R.id.tv_result);
        conteiner = view.findViewById(R.id.conteiner);
    }

    private void initListener() {
        btn_plus.setOnClickListener(v -> {
            count++;
            updateText();
        });
        btn_minos.setOnClickListener(v -> {
            count--;
            updateText();
        });
    }

    private void updateText() {
        if (tv_result != null) {
            tv_result.setText(String.valueOf(count));
            if (count >= 10 && count <= 50) {
                conteiner.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.ic_background)
                );
            } else if(count >= 50) {
                conteiner.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.ic_background_home));


            }
        }
        if (count <= 0) {
            if (tv_result != null) {
                tv_result.setText("0");
            }
        }
    }
}


