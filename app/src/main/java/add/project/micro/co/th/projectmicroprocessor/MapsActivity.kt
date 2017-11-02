package add.project.micro.co.th.projectmicroprocessor

import android.Manifest
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.support.v4.content.ContextCompat


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var tvlatitude: TextView
    private lateinit var tvlongtitude: TextView
    private val imstay: LatLng
        get() = LatLng(latitude, longitude)
    private val latitude = 13.901919
    private val longitude = 100.532734

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        mapInit()
        tvlatitude = findViewById(R.id.tv_lati)
        tvlongtitude = findViewById(R.id.tv_longti)

        tvlatitude.text = latitude.toString()
        tvlongtitude.text = longitude.toString()
    }

    private fun mapInit() {
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }
    private fun openURL() {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?saddr=Current%20Location&daddr=13.905869, 100.529626"))
        browserIntent.setPackage("com.google.android.apps.maps")
        startActivity(browserIntent)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.addMarker(MarkerOptions().position(imstay).title("Marker in Thailand"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(latitude, longitude), 14.0f))
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        } else {
            // Show rationale and request permission.
        }
    }

}
