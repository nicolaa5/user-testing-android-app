package com.samla.app

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import com.samla.sdk.Samla

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val samla = Samla(this);

    override fun onCreate(savedInstanceState: Bundle?) {
        samla.withLifeCycle(lifecycle);

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        samla.funnelManager.reachedWayPoint(1);

        floatingActionButton.setOnClickListener { view ->
            samla.funnelManager.reachedWayPoint(3);
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        samla.funnelManager.reachedWayPoint(2);
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when(item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
