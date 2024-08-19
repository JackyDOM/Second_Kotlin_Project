package com.example.secondproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.secondproject.CartScreen.CartFragment
import com.example.secondproject.MenuScreen.MenuFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var buttonDrawerToggle: ImageButton
    private lateinit var navigationView: NavigationView
    private  lateinit var fragment: Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.DrawerLayout)
        buttonDrawerToggle = findViewById(R.id.buttonDrawerToggle)
        navigationView = findViewById(R.id.navigationView)

        buttonDrawerToggle.setOnClickListener{
            drawerLayout.open()
        }


        var headerView: View = navigationView.getHeaderView(0)
        var userImage: ImageView = headerView.findViewById(R.id.userImage)
        var textUsername: TextView = headerView.findViewById(R.id.textUsername)

        userImage.setOnClickListener{
            Toast.makeText(this, textUsername.text, Toast.LENGTH_LONG).show()
        }

        navigationView.setNavigationItemSelectedListener { item ->
            val itemId: Int = item.itemId

            if(itemId == R.id.navMenu){
                loadFragment(MenuFragment(), false)
            }else if(itemId == R.id.navCart){
                loadFragment(CartFragment(), false)
            }else if(itemId == R.id.navFavorite){
                Toast.makeText(this, "Favorite Clicked", Toast.LENGTH_LONG).show()
            }else if(itemId == R.id.navOrder){
                Toast.makeText(this, "Ongoing Order Clicked", Toast.LENGTH_LONG).show()
            }else if(itemId == R.id.navHistory){
                Toast.makeText(this, "History Clicked", Toast.LENGTH_LONG).show()
            }else if(itemId == R.id.navFeedback){
                Toast.makeText(this, "Feedback Clicked", Toast.LENGTH_LONG).show()
            }else if(itemId == R.id.navTerms){
                Toast.makeText(this, "Term and Condition Clicked", Toast.LENGTH_LONG).show()
            }else if(itemId == R.id.navContact){
                Toast.makeText(this, "Contact Clicked", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Shared Clicked", Toast.LENGTH_LONG).show()
            }

            drawerLayout.close()

            true
        }

        // Load the default fragment when the app starts
        loadFragment(MenuFragment(), true)
    }

    private fun loadFragment(fragment: Fragment, isAppInitialized: Boolean) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        if (isAppInitialized) {
            fragmentTransaction.add(R.id.frameLayout, fragment)
        } else {
            fragmentTransaction.replace(R.id.frameLayout, fragment)
        }
        fragmentTransaction.commitAllowingStateLoss()
    }
}