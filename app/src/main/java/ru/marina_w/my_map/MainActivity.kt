package ru.marina_w.my_map

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yandex.mapkit.MapKitFactory
import ru.marina_w.my_map.auth.UserRepository
import ru.marina_w.my_map.room.BdUserHolder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            MapKitFactory.initialize(this)
            BdUserHolder.getInstance().init(this)
            UserRepository.getInstance().bind(this)
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MapFragment()).commit()
        }
    }

    override fun onDestroy() {
        UserRepository.getInstance().realise()
        super.onDestroy()
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
    }

    override fun onStop() {
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }
}