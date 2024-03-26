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
import ru.marina_w.my_map.auth.RegistrationPhoneViewModel

const val NUMBER_LENGTH = 10

class RegistrationFragment : Fragment() {

    private val viewModelPhoneNumber= RegistrationPhoneViewModel()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_registration, container, false)
        val numberPhone: EditText = view.findViewById(R.id.phone_number)
        val buttonSMS: Button = view.findViewById(R.id.button_sms)
        numberPhone.setText(viewModelPhoneNumber.getUserNumberPhone())

        numberPhone.doOnTextChanged { text, start, before, count ->
            buttonSMS.isEnabled = (text?.length ?: 0) > NUMBER_LENGTH
            buttonSMS.isClickable = (text?.length ?: 0) > NUMBER_LENGTH
            viewModelPhoneNumber.setCurrentNumber(text.toString())

        }

        buttonSMS.setOnClickListener {
            Log.d("checkResult", "onCreateView: is Work")

        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}