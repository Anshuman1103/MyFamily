package com.example.myfamily2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.Manifest
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {

    private val permissions = arrayOf(
        Manifest.permission.ACCESS_FINE_LOCATION
    )

    private val permissionCode = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomBar = findViewById<BottomNavigationView>(R.id.bottom_bar)

        askForPermission()

        bottomBar.setOnItemSelectedListener { menuItem ->

            when (menuItem.itemId) {
                R.id.nav_guard -> {
                    inflateFragment(GuardFragment.newInstance())
                }

                R.id.nav_home -> {
                    inflateFragment(HomeFragment.newInstance())
                }

                R.id.nav_dashboard -> {
                    inflateFragment(MapsFragment())
                }

                R.id.nav_profile -> {
                    inflateFragment(ProfileFragment.newInstance())
                }
            }


            true
        }
        bottomBar.selectedItemId = R.id.nav_home
    }

    private fun askForPermission() {
        ActivityCompat.requestPermissions(this,permissions, permissionCode)
    }


    private fun inflateFragment(newInstance : Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, newInstance)
        transaction.commit()

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(allPermissionGranted()){
            //do thing when all permission is granted
        }
        else{
            
        }
    }

    private fun allPermissionGranted(): Boolean {
        for(item in permissions ){
            if (ContextCompat.checkSelfPermission(this, item) != PackageManager.PERMISSION_GRANTED){
                return false
            }
        }
        return true

    }
}




