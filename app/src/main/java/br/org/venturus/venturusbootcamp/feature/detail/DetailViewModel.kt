package br.org.venturus.venturusbootcamp.feature.detail

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.org.venturus.venturusbootcamp.core.extension.logD
import br.org.venturus.venturusbootcamp.domain.people.GetPeopleUseCase
import br.org.venturus.venturusbootcamp.domain.people.Person
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DetailViewModel(private val getPeopleUseCase: GetPeopleUseCase) : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    val person = MutableLiveData<Person>()

    fun loadPersonInformation(personId: String) {
        logD { "loadPersonInformation called with: personId = [$personId]" }

        val peopleUseCase = getPeopleUseCase.getPerson(personId)
                .subscribeOn(Schedulers.io()) // Executa a chamada na thread de IO
                .observeOn(AndroidSchedulers.mainThread()) // Envia a resposta para a thread do Android
                .subscribe { p: Person ->
                    person.value = p
                }

        // Adiciona o disposable no container de dispobles, para ser limpo afim de evitar um Leak!
        compositeDisposable.add(peopleUseCase)
    }

    override fun onCleared() {
        super.onCleared()
        logD { "onCleared called" }
        compositeDisposable.clear()
    }
}
