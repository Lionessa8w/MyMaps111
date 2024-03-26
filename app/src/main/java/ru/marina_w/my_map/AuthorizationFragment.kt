package ru.marina_w.my_map

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment

const val SMS_CODE = 5

class AuthorizationFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_authorization, container, false)
        val smsEditText: EditText = view.findViewById(R.id.sms_numbers_code)
        val smsButton: Button = view.findViewById(R.id.button_sms_code)

        smsEditText.doOnTextChanged { text, start, before, count ->
            smsButton.isEnabled = (text?.length ?: 0) > NUMBER_LENGTH
            smsButton.isClickable = (text?.length ?: 0) > NUMBER_LENGTH

        }

        smsButton.setOnClickListener {
            Log.d("checkResult", "onCreateView: is Work")

        }



        return view
    }

}