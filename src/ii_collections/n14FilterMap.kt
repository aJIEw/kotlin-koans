package ii_collections

fun example1(list: List<Int>) {

    // If a lambda has exactly one parameter, that parameter can be accessed as 'it'
    val positiveNumbers = list.filter { it > 0 }
    println(positiveNumbers)

    val squares = list.map { it * it }
    println(squares)
}

fun main() {
    example1(listOf(0, 1, 2, 3, 4))
}

fun Shop.getCitiesCustomersAreFrom(): Set<City> {
    // Return the set of cities the customers are from
    var cities = mutableSetOf<City>()
    for (customer in customers) {
        cities.add(customer.city)
    }
    return cities

    // or through map
    return customers.map { it.city }.toSet()
}

fun Shop.getCustomersFrom(city: City): List<Customer> {
    // Return a list of the customers who live in the given city
    return customers.filter { it.city == city }
}


