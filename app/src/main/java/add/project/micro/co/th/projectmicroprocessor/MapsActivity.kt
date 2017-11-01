package add.project.micro.co.th.projectmicroprocessor

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var tvlatitude: TextView
    private lateinit var tvlongtitude: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        tvlatitude = findViewById(R.id.tv_lati)
        tvlongtitude = findViewById(R.id.tv_longti)

        tvlatitude.text = latitude.toString()
        tvlongtitude.text = longtitude.toString()
    }
    val latitude = 13.905869
    val longtitude = 100.529626

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val latitude = 13.905869
        val longtitude = 100.529626
        // Add a marker in Sydney and move the camera
        val imstay = LatLng(latitude, longtitude)
        mMap.addMarker(MarkerOptions().position(imstay).title("Marker in Thailand"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(imstay))
        mMap.animateCamera(CameraUpdateFactory.zoomIn())
        mMap.animateCamera(CameraUpdateFactory.zoomTo(10F), 2000, null)

    }
}
