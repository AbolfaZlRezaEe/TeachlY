package com.example.teachely.Views.Activitys.Fragments.SignUpFragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.teachely.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignUpFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "SignUpFragment";
    private TextInputLayout etlFirstName;
    private TextInputLayout etlLastName;
    private TextInputLayout etlAge;
    private TextInputEditText etFirstName;
    private TextInputEditText etLastName;
    private TextInputEditText etAge;
    private MaterialButton btnNext;
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private OnReceiveInformation receiveInformation;
    private RadioGroup rgGender;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        receiveInformation= (OnReceiveInformation) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        initializeGender();
    }

    private void receiveInformation() {
        if (etFirstName.getText().length() > 0 && etLastName.getText().length() > 0 && etAge.getText().length() > 0) {
            firstName = etFirstName.getText().toString();
            lastName = etLastName.getText().toString();
            age = Integer.parseInt(etAge.getText().toString());

        } else if (etFirstName.getText().length() < 0) {
            etlFirstName.setError("لطفا نام خود را وارد نمایید!");
        } else if (etLastName.getText().length() < 0) {
            etlLastName.setError("لطفا نام خانوادگی خود را وارد نمایید");
        } else
            etlAge.setError("لطفا سن خود را وارد نمایید");

    }

    private void initializeGender() {
        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_signUp_male) {
                    gender = "آقا";
                } else {
                    gender = "خانم";

                }
            }
        });
    }

    private void initViews(View view) {
        etlFirstName = view.findViewById(R.id.etl_signUp_FirstName);
        etlLastName = view.findViewById(R.id.etl_signUp_LastName);
        etlAge = view.findViewById(R.id.etl_signUp_age);
        etFirstName = view.findViewById(R.id.et_signUp_FirstName);
        etLastName = view.findViewById(R.id.et_signUp_LastName);
        etAge = view.findViewById(R.id.et_signUp_age);
        btnNext = view.findViewById(R.id.btn_signUp_next);
        rgGender = view.findViewById(R.id.rg_signUp_gender);
        btnNext.setOnClickListener(this);
    }

    private boolean nullTextInputLayout() {
        if (etFirstName.getText().length() > 0 && etLastName.getText().length() > 0 && etAge.getText().length() > 0) {
            return false;
        }
        return true;

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_signUp_next:
                if (nullTextInputLayout()) {
                    receiveInformation();
                } else {
                    receiveInformation();
                    receiveInformation.onReceived(firstName, lastName, age, gender);
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_welcome_container, new GradeFragment());
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                break;
        }
    }

    public interface OnReceiveInformation {
        void onReceived(String firstName, String lastName, int age, String gender);
    }
}
