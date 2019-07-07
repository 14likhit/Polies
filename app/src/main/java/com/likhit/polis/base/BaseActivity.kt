package com.likhit.polis.base

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.Toast

import com.likhit.polis.R
import com.likhit.polis.utils.Utils

@SuppressLint("Registered")
abstract class BaseActivity : AppCompatActivity(), BaseView {

    protected val currentFragment: BaseFragment?
        get() = supportFragmentManager.findFragmentById(R.id.container) as BaseFragment?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }


    fun setupToolbar(title: String?, homeButtonEnable: Boolean) {
        val toolbar = findViewById<Toolbar>(R.id.toolbar) ?: return

        if (!homeButtonEnable) {
            val inset = Utils.dpToPx(this, 16f).toInt()
            toolbar.setContentInsetsAbsolute(inset, inset)
        }

        setSupportActionBar(toolbar)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.title = title
            actionBar.setDisplayHomeAsUpEnabled(homeButtonEnable)
            actionBar.setDisplayShowHomeEnabled(homeButtonEnable)

            //            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            //                @Override
            //                public void onClick(View view) {
            //                    onBackPressed();
            //                }
            //            });
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    // Fragment Related
    protected fun replaceFragment(fragment: Fragment, tag: String, addToBackStack: Boolean) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment, tag)
        if (addToBackStack) {
            transaction.addToBackStack(tag)
        }
        transaction.commit()
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showMessage(messageResId: Int) {
        Toast.makeText(this, getString(messageResId), Toast.LENGTH_SHORT).show()
    }

    override fun onBackPressed() {
        if (currentFragment == null || !currentFragment!!.onBackPressed()) {
            super.onBackPressed()
        }
    }

}


