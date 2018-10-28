package venturus.org.br.playground.exercises.syntax

enum class Continent {
    ASIA, AFRICA, EUROPE, NORTH_AMERICA, SOUTH_AMERICA, OCEANIA, ANTARCTICA
}

data class Country(var name: String, var continent: Continent)

fun main(args: Array<String>) {

    val countries = listOf(
        Country("Brazil", Continent.SOUTH_AMERICA),
        Country("Wakanda", Continent.AFRICA),
        Country("Suriname", Continent.SOUTH_AMERICA),
        Country("Italy", Continent.EUROPE),
        Country("Japan", Continent.ASIA),
        Country("Australia", Continent.OCEANIA),
        Country("Canada", Continent.NORTH_AMERICA),
        Country("South Korea", Continent.ASIA)
    )

    countries.forEach {
        val name = it.name
        val continente =
                when(it.continent){
                    Continent.ASIA -> "Asia"
                    Continent.AFRICA -> "Africa"
                    Continent.EUROPE -> "Europa"
                    Continent.NORTH_AMERICA -> "America do norte"
                    Continent.SOUTH_AMERICA -> "America do sul"
                    Continent.OCEANIA -> "Oceania"
                    Continent.ANTARCTICA -> "Antartica"
                }
            println("$name - $continente")
    }

//    TODO("Imprimir o nome dos países em inglês e o nome dos continentes em português")
}
