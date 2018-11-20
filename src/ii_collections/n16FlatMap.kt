package ii_collections

fun example() {

    val result = listOf("abc", "12").flatMap { it.toList() }

    result == listOf('a', 'b', 'c', '1', '2')
}

val Customer.orderedProducts: Set<Product> get() {
    // Return all products this customer has ordered
    val result = mutableSetOf<Product>()
    orders.flatMap { result.addAll(it.products); result }
//    orders.forEach { result.addAll(it.products) } // same as using forEach
    return result
}

val Shop.allOrderedProducts: Set<Product> get() {
    // Return all products that were ordered by at least one customer
    val result = mutableSetOf<Product>()
    customers.flatMap { result.addAll(it.orderedProducts); result }
//    customers.forEach { result.addAll(it.orderedProducts) }
    return result
}

fun main(args: Array<String>) {
}
