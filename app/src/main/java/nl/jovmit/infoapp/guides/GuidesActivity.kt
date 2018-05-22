package nl.jovmit.infoapp.guides

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import nl.jovmit.infoapp.R

class GuidesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guides)
        setupLayout()
    }

    private fun setupLayout() {
        supportActionBar?.setTitle(R.string.guides)
    }
}
