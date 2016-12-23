package com.weidu.kilos2pounds;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * A placeholder fragment containing a simple view.
 */
public class ConvertActivityFragment extends Fragment {
    float input;
    EditText edittext;
    RadioGroup radioGroup;
    Button button;
    TextView textview;
    double rst;

    public ConvertActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_convert, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        edittext = (EditText)getActivity().findViewById(R.id.editText);
        radioGroup = (RadioGroup)getActivity().findViewById(R.id.RadioGroup);
        radioGroup.check(R.id.radioButton1);
        textview = (TextView)getActivity().findViewById(R.id.textView2);
        button = (Button)getActivity().findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convert();
            }
        });
    }
    private void convert(){
        String str = edittext.getText().toString();

        if(!TextUtils.isEmpty(str)) {
            input = Float.parseFloat(str);
            int selectedButtonId = radioGroup.getCheckedRadioButtonId();
            DecimalFormat tenth = new DecimalFormat("#.##");
            if(selectedButtonId==R.id.radioButton1){
                rst = input/2.2;
                textview.setText(tenth.format(input)+"pounds = "+tenth.format(rst)+"kg");
            }else{
                rst = input*2.2;
                textview.setText(tenth.format(input)+"kg = "+tenth.format(rst)+"pounds");
            }
        } else {
            textview.setText("Please input number.");
        }
}}
