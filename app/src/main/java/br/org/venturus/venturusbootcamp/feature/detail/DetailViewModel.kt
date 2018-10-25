package br.org.venturus.venturusbootcamp.feature.detail

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.org.venturus.venturusbootcamp.R
import br.org.venturus.venturusbootcamp.core.extension.logD
import br.org.venturus.venturusbootcamp.core.extension.logE
import br.org.venturus.venturusbootcamp.domain.people.GetPeopleUseCase
import br.org.venturus.venturusbootcamp.domain.people.Person
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class DetailViewModel(private val getPeopleUseCase: GetPeopleUseCase) : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun loadPersonInformation(personId: String) {
        logD { "loadPersonInformation called with: personId = [$personId]" }


    }

    override fun onCleared() {
        super.onCleared()
        logD { "onCleared called" }
        compositeDisposable.clear()
    }
}
