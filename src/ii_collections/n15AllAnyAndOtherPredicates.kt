package ii_collections

fun example2(list: List<Int>) {

    val isZero: (Int) -> Boolean = { it == 0 }

    val hasZero: Boolean = list.any(isZero)
    println("hasZero? $hasZero")

    val allZeros: Boolean = list.all(isZero)
    println("allZeros? $allZeros")

    val numberOfZeros: Int = list.count(isZero)
    println("numberOfZeros? $numberOfZeros")

    val firstPositiveNumber: Int? = list.firstOrNull { it > 0 }
    println("firstPositiveNumber? $firstPositiveNumber")
}

fun main() {
    example2(listOf(0, 1, 2, 3, 4))
}

fun Customer.isFrom(city: City): Boolean {
    // Return true if the customer is from the given city
    return city == this.city
}

fun Shop.checkAllCustomersAreFrom(city: City): Boolean {
    // Return true if all customers are from the given city
    return customers.filter { it.city == city }.size == customers.size
}

fun Shop.hasCustomerFrom(city: City): Boolean {
    // Return true if there is at least one customer from the given city
    for (customer in customers) {
        if (customer.isFrom(city)) return true
    }
    return false
}

fun Shop.countCustomersFrom(city: City): Int {
    // Return the number of customers from the given city
    return customers.filter { it.city == city }.size
}

fun Shop.findFirstCustomerFrom(city: City): Customer? {
    // Return the first customer who lives in the given city, or null if there is none
    return customers.firstOrNull { it.city == city }
}
