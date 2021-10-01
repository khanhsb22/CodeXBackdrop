package com.example.myapplication3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ru.semper_viventem.backdrop.BackdropBehavior

class MainActivity : AppCompatActivity() {

    companion object {
        private const val ARG_LAST_MENU_ITEM = "last_menu_item"

        private const val MENU_HOME = R.id.menuHome
        private const val MENU_HEADPHONE = R.id.menuHeadPhone
        private const val MENU_DESIGN = R.id.menuDesign
        private const val MENU_CODES = R.id.menuCode
        private const val MENU_SETTINGS = R.id.menuSettings
        private const val MENU_SIGNIN = R.id.menuSignin

        private const val DEFAULT_ITEM = MENU_HOME

        private const val FRAGMENT_CONTAINER = R.id.frontLayout
    }

    private lateinit var backdropBehavior: BackdropBehavior

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        backdropBehavior = frontLayout.findBehavior()

        with(backdropBehavior) {
            attachBackLayout(R.id.appBarLayout)
        }

        with(toolBar) {
            setTitle("Sample")
        }

        navigationView.setNavigationItemSelectedListener { item ->
            GlobalScope.launch (Dispatchers.Default){
                checkMenuPosition(item.itemId)
            }
            backdropBehavior.close()
            true
        }

        val currentItem = savedInstanceState?.getInt(ARG_LAST_MENU_ITEM) ?: DEFAULT_ITEM
        navigationView.setCheckedItem(currentItem)

        GlobalScope.launch (Dispatchers.Default){
            checkMenuPosition(navigationView.checkedItem!!.itemId)
        }

    }

    private suspend fun checkMenuPosition(@IdRes menuItemId: Int) {
        when (menuItemId) {
            MENU_HOME -> showPage(HomeScreen())
            MENU_HEADPHONE -> showPage(HeadPhoneScreen())
            MENU_DESIGN -> Toast.makeText(this@MainActivity, "Design", Toast.LENGTH_SHORT).show()
            MENU_CODES -> Toast.makeText(this@MainActivity, "Codes", Toast.LENGTH_SHORT).show()
            MENU_SETTINGS -> Toast.makeText(this@MainActivity, "Settings", Toast.LENGTH_SHORT).show()
            MENU_SIGNIN -> Toast.makeText(this@MainActivity, "Signin", Toast.LENGTH_SHORT).show()
        }
    }

    fun <T : CoordinatorLayout.Behavior<*>> View.findBehavior(): T = layoutParams.run {
        if (this !is CoordinatorLayout.LayoutParams) throw IllegalArgumentException("View's layout params should be CoordinatorLayout.LayoutParams")

        (layoutParams as CoordinatorLayout.LayoutParams).behavior as? T
            ?: throw IllegalArgumentException("Layout's behavior is not current behavior")
    }

    fun showPage(page: Fragment) {
        supportFragmentManager.beginTransaction().replace(FRAGMENT_CONTAINER, page)
            .commit()
    }
}