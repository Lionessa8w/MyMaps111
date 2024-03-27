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
import ru.marina_w.my_map.auth.AuthorizationViewModel

const val SMS_CODE = 5

class AuthorizationFragment : Fragment() {

    private val smsViewModel= AuthorizationViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_authorization, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val smsEditText: EditText = view.findViewById(R.id.sms_numbers_code)
        val smsButton: Button = view.findViewById(R.id.button_sms_code)
        smsEditText.setText(smsViewModel.getSmsCode())

        smsEditText.doOnTextChanged { text, start, before, count ->
            smsButton.isEnabled = (text?.length ?: 0) > NUMBER_LENGTH
            smsButton.isClickable = (text?.length ?: 0) > NUMBER_LENGTH
            smsViewModel.setCurrentSms(text.toString())

        }

        smsButton.setOnClickListener {
            Log.d("checkResult", "onCreateView: is Work")

        }
    }

}