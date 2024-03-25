package ru.marina_w.my_map

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.marina_w.my_map.auth.UserRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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