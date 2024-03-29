package ru.marina_w.my_map

import android.app.Application
import com.google.firebase.FirebaseApp
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.mapview.MapView

class App: Application() {

//    private lateinit var mapView: MapView

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        MapKitFactory.initialize(this)
//        setContentView(R.layout.map_fragment)
//        mapView = findViewById(R.id.mapview)
        MapKitFactory.setApiKey("58777d91-ee4e-4d91-a65b-2fe73bdcaae5")

    }

}