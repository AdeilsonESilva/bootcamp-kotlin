package venturus.org.br.playground.exercises.reactive

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import java.util.*

private val compositeDisposable: CompositeDisposable = CompositeDisposable()

fun main(args: Array<String>) {

    println("Start!")

    // TODO RxExercises
    // Create a stream that emits 50 random integers between 0 and 1000
    // Ignore the first 20 items
    // Get only the items that is higher than 500
    // The Observer should print the items with the text "A wild N appears!"
    // where N is the number emitted by the Observable, plus 1000

    val disposable = Observable.range(1, 50)
            .map { Random().nextInt(1000) }
            .skip(20)
            .filter { it > 50 }
            .subscribe{println("A wild ${it + 1000} appears!")}


    compositeDisposable.add(disposable)

    println("Done!")
}
