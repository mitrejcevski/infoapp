package nl.jovmit.infoapp.guides

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

class GuidesViewModelFactory(
        private val repository: GuidesRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GuidesViewModel(repository) as T
    }
}