package nl.jovmit.infoapp.guides

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_guides.*
import nl.jovmit.infoapp.R
import nl.jovmit.infoapp.extensions.observe
import nl.jovmit.infoapp.extensions.setupDefaultColorScheme
import nl.jovmit.infoapp.guides.data.Error
import nl.jovmit.infoapp.guides.data.Guide
import nl.jovmit.infoapp.guides.data.Progress
import nl.jovmit.infoapp.guides.data.Success

class GuidesActivity : AppCompatActivity() {

    private val guidesAdapter = GuidesAdapter()
    private val guidesViewModel by lazy { createGuidesViewModel(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guides)
        setupLayout()
        setupViewModel()
        if (savedInstanceState == null) {
            guidesViewModel.fetchGuides()
        }
    }

    private fun setupLayout() {
        supportActionBar?.setTitle(R.string.guides)
        guidesSwipeRefreshLayout.setupDefaultColorScheme()
        guidesSwipeRefreshLayout.setOnRefreshListener { guidesViewModel.fetchGuides() }
        guidesRecycler.layoutManager = LinearLayoutManager(this)
        guidesRecycler.adapter = guidesAdapter
    }

    private fun setupViewModel() {
        guidesViewModel.guides.observe(this) {
            when (it) {
                is Progress -> displayLoading(it.loading)
                is Success -> displayGuides(it.guides)
                is Error -> displayError(it.error)
            }
        }
    }

    private fun displayLoading(loading: Boolean) {
        guidesSwipeRefreshLayout.isRefreshing = loading
    }

    private fun displayGuides(guides: List<Guide>) {
        guidesAdapter.setItems(guides)
    }

    private fun displayError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }
}
