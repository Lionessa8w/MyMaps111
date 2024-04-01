package ru.marina_w.my_map

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.marina_w.my_map.auth.UserRepository
import ru.marina_w.my_map.room.BdUserHolder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        BdUserHolder.getInstance().init(this)
        UserRepository.getInstance().bind(this)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, RegistrationFragment()).commit()
        }
    }

    override fun onDestroy() {
        UserRepository.getInstance().realise()
        super.onDestroy()
    }
}