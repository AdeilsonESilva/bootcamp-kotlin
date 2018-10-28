package venturus.org.br.playground.exercises.syntax

fun printInformation(name: String = "N/A", birthday: String = "N/A", document: String = "N/A") =
            println("Nome $name, data: $birthday, documento: $document")

fun main(args: Array<String>) {

    printInformation("Rafael", document = "87348759834")
    printInformation("Igor", "15-04-1993", "438957389")
    printInformation("Alex")
    printInformation("Jean", document = "879879878")

//    TODO("Criar o método 'printInformation' que imprima as infomações das pessoas e 'N/A' se algum argumento não for preenchido")
}

