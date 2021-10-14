package ch.zice.spp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import ch.zice.spp.fragments.DashboardFragment
import ch.zice.spp.fragments.FriendsFragment
import ch.zice.spp.fragments.PartiesFragment
import ch.zice.spp.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

import com.google.android.material.navigation.NavigationBarView




class MainActivity : AppCompatActivity() {

    private val dashboardFragment = DashboardFragment()
    private val partiesFragment = PartiesFragment()
    private val friendsFragment = FriendsFragment()
    private val profileFragment = ProfileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {

        supportActionBar?.hide() // hide the title bar

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(dashboardFragment)


        val bottomNavBar = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavBar.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener { item ->

            when (item.itemId) {
                R.id.ic_dashboard -> {
                    replaceFragment(dashboardFragment)
                    true
                }
                R.id.ic_parties -> {
                    replaceFragment(partiesFragment)
                    true
                }
                R.id.ic_friends -> {
                    replaceFragment(friendsFragment)
                    true
                }
                R.id.ic_profile -> {
                    replaceFragment(profileFragment)
                    true
                }
                else -> false
            }
        })
    }

    private fun replaceFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()

    }
}
