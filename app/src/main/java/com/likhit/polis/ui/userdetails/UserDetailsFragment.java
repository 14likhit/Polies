package com.likhit.polis.ui.userdetails;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;

import com.likhit.polis.R;
import com.likhit.polis.base.BaseFragment;
import com.likhit.polis.databinding.FragmentUserDetailsBinding;
import com.likhit.polis.ui.home.HomeFragementListener;
import com.likhit.polis.utils.Utils;

public class UserDetailsFragment extends BaseFragment {

    public static final String TAG = "UserDetailsFragment";

    private FragmentUserDetailsBinding binding;

    private HomeFragementListener fragementListener;

    public static UserDetailsFragment newInstance() {
        return new UserDetailsFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentUserDetailsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof HomeFragementListener) {
            fragementListener = (HomeFragementListener) context;
        }
    }

    @Override
    public void onDetach() {
        fragementListener = null;
        super.onDetach();
    }

    @Override
    protected void initViews(View view) {
        super.initViews(view);
        binding.userDetailsAddressEt.setImeOptions(EditorInfo.IME_ACTION_DONE);
        binding.userDetailsAddressEt.setRawInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
        binding.doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateData()) {
                    fragementListener.launchQA();
                    showMessage("User Detail Submitted");
                } else {
                    Utils.hideSoftKeyboard(getBaseActivity());
                    showMessage("Please fill fields");
                }
            }
        });

        validateDataOnFocus();
    }

    private void validateDataOnFocus() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                switch (v.getId()) {
                    case R.id.user_details_name_et:
                        if (!hasFocus) {
                            validateName();
                        }
                        break;
                    case R.id.user_details_phone_et:
                        if (!hasFocus) {
                            validatePhone();
                        }
                        break;
                    case R.id.user_details_gender_et:
                        if (!hasFocus) {
                            validateGender();
                        }
                        break;
                    case R.id.user_details_age_et:
                        if (!hasFocus) {
                            validateAge();
                        }
                        break;
                    case R.id.user_details_address_et:
                        if (!hasFocus) {
                            validateAddress();
                        }
                        break;
                }
            }
        };

        binding.userDetailsNameEt.setOnFocusChangeListener(onFocusChangeListener);
        binding.userDetailsPhoneEt.setOnFocusChangeListener(onFocusChangeListener);
        binding.userDetailsGenderEt.setOnFocusChangeListener(onFocusChangeListener);
        binding.userDetailsAgeEt.setOnFocusChangeListener(onFocusChangeListener);
        binding.userDetailsAddressEt.setOnFocusChangeListener(onFocusChangeListener);
    }


    private boolean validateData() {
        return validateName() && validatePhone() && validateGender() && validateAge() && validateAddress();
    }

    private boolean validateName() {
        if (getName() == null || getName().isEmpty()) {
            binding.userDetailsNameEt.setError("Please Enter Name");
            return false;
        }
        return true;
    }

    private boolean validatePhone() {
        if (getPhone() == null || getPhone().isEmpty()) {
            binding.userDetailsPhoneEt.setError("Please Enter Phone Number");
            return false;
        }
        return true;
    }


    private boolean validateGender() {
        if (getGender() == null || getGender().isEmpty()) {
            binding.userDetailsGenderEt.setError("Please Enter Gender");
            return false;
        }
        return true;
    }


    private boolean validateAge() {
        if (getAge() == null || getAge().isEmpty()) {
            binding.userDetailsAgeEt.setError("Please Enter Age");
            return false;
        }
        return true;
    }


    private boolean validateAddress() {
        if (getAddress() == null || getAddress().isEmpty()) {
            binding.userDetailsAddressEt.setError("Please Enter Address");
            return false;
        }
        return true;
    }


    private String getName() {
        if (binding.userDetailsNameEt.getText() != null) {
            return binding.userDetailsNameEt.getText().toString().trim();
        }
        return null;
    }

    private String getPhone() {
        if (binding.userDetailsPhoneEt.getText() != null) {
            return binding.userDetailsPhoneEt.getText().toString().trim();
        }
        return null;
    }

    private String getGender() {
        if (binding.userDetailsGenderEt.getText() != null) {
            return binding.userDetailsGenderEt.getText().toString().trim();
        }
        return null;
    }

    private String getAge() {
        if (binding.userDetailsAgeEt.getText() != null) {
            return binding.userDetailsAgeEt.getText().toString().trim();
        }
        return null;
    }

    private String getAddress() {
        if (binding.userDetailsAddressEt.getText() != null) {
            return binding.userDetailsAddressEt.getText().toString().trim();
        }
        return null;
    }

}
