package ru.marina_w.my_map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import ru.marina_w.my_map.databinding.FragmentMapBinding

class MapFragment : Fragment() {

    private lateinit var binding: FragmentMapBinding

    //начальная точка/ старт карты
    private val startLocation = Point(59.9402, 30.315)

    // зум карты
    private var zoomValue: Float = 16.5f

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun moveToStartLocation() {
        binding.mapview.map.move(
            CameraPosition(startLocation, zoomValue, 0.0f, 0.0f)
        )
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        binding.mapview.onStart()
    }

    override fun onStop() {
        binding.mapview.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }
}