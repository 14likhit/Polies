package com.likhit.polis.ui.userdetails


import android.content.Context
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo

import com.likhit.polis.R
import com.likhit.polis.base.BaseFragment
import com.likhit.polis.databinding.FragmentUserDetailsBinding
import com.likhit.polis.ui.home.HomeFragementListener
import com.likhit.polis.utils.Utils

class UserDetailsFragment : BaseFragment() {

    private var binding: FragmentUserDetailsBinding? = null

    private var fragementListener: HomeFragementListener? = null


    private val name: String?
        get() = if (binding!!.userDetailsNameEt.text != null) {
            binding!!.userDetailsNameEt.text!!.toString().trim { it <= ' ' }
        } else null

    private val phone: String?
        get() = if (binding!!.userDetailsPhoneEt.text != null) {
            binding!!.userDetailsPhoneEt.text!!.toString().trim { it <= ' ' }
        } else null

    private val gender: String?
        get() = if (binding!!.userDetailsGenderEt.text != null) {
            binding!!.userDetailsGenderEt.text!!.toString().trim { it <= ' ' }
        } else null

    private val age: String?
        get() = if (binding!!.userDetailsAgeEt.text != null) {
            binding!!.userDetailsAgeEt.text!!.toString().trim { it <= ' ' }
        } else null

    private val address: String?
        get() = if (binding!!.userDetailsAddressEt.text != null) {
            binding!!.userDetailsAddressEt.text!!.toString().trim { it <= ' ' }
        } else null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentUserDetailsBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is HomeFragementListener) {
            fragementListener = context
        }
    }

    override fun onDetach() {
        fragementListener = null
        super.onDetach()
    }

    override fun initViews(view: View) {
        super.initViews(view)
        binding!!.userDetailsAddressEt.imeOptions = EditorInfo.IME_ACTION_DONE
        binding!!.userDetailsAddressEt.setRawInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES)
        binding!!.doneBtn.setOnClickListener {
            if (validateData()) {
                fragementListener!!.launchQA()
                showMessage("User Detail Submitted")
            } else {
                Utils.hideSoftKeyboard(baseActivity!!)
                showMessage("Please fill fields")
            }
        }

        validateDataOnFocus()
    }

    private fun validateDataOnFocus() {
        val onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
            when (v.id) {
                R.id.user_details_name_et -> if (!hasFocus) {
                    validateName()
                }
                R.id.user_details_phone_et -> if (!hasFocus) {
                    validatePhone()
                }
                R.id.user_details_gender_et -> if (!hasFocus) {
                    validateGender()
                }
                R.id.user_details_age_et -> if (!hasFocus) {
                    validateAge()
                }
                R.id.user_details_address_et -> if (!hasFocus) {
                    validateAddress()
                }
            }
        }

        binding!!.userDetailsNameEt.onFocusChangeListener = onFocusChangeListener
        binding!!.userDetailsPhoneEt.onFocusChangeListener = onFocusChangeListener
        binding!!.userDetailsGenderEt.onFocusChangeListener = onFocusChangeListener
        binding!!.userDetailsAgeEt.onFocusChangeListener = onFocusChangeListener
        binding!!.userDetailsAddressEt.onFocusChangeListener = onFocusChangeListener
    }


    private fun validateData(): Boolean {
        return validateName() && validatePhone() && validateGender() && validateAge() && validateAddress()
    }

    private fun validateName(): Boolean {
        if (name == null || name!!.isEmpty()) {
            binding!!.userDetailsNameEt.error = "Please Enter Name"
            return false
        }
        return true
    }

    private fun validatePhone(): Boolean {
        if (phone == null || phone!!.isEmpty()) {
            binding!!.userDetailsPhoneEt.error = "Please Enter Phone Number"
            return false
        }
        return true
    }


    private fun validateGender(): Boolean {
        if (gender == null || gender!!.isEmpty()) {
            binding!!.userDetailsGenderEt.error = "Please Enter Gender"
            return false
        }
        return true
    }


    private fun validateAge(): Boolean {
        if (age == null || age!!.isEmpty()) {
            binding!!.userDetailsAgeEt.error = "Please Enter Age"
            return false
        }
        return true
    }


    private fun validateAddress(): Boolean {
        if (address == null || address!!.isEmpty()) {
            binding!!.userDetailsAddressEt.error = "Please Enter Address"
            return false
        }
        return true
    }

    companion object {

        val TAG = "UserDetailsFragment"

        fun newInstance(): UserDetailsFragment {
            return UserDetailsFragment()
        }
    }

}
