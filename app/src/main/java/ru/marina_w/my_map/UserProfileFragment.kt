package ru.marina_w.my_map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class UserProfileFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_account_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myProfileText: TextView= view.findViewById(R.id.my_profile)
        val iconProfile: ImageView= view.findViewById(R.id.user_avatar)
        val nameUserText: TextView= view.findViewById(R.id.account_name)
        val numberPhoneUser: TextView= view.findViewById(R.id.number_phone)
        val statusSong: TextView= view.findViewById(R.id.song_status)
        val buttonMapLike: Button= view.findViewById(R.id.button_map_like)
    }
}