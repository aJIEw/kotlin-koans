package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
    // Return the set of customers who ordered the specified product
    return customers.filter { it.orders.any { order -> order.products.any { p -> p.name == product.name } } }.toSet()
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    // Return the most expensive product among all delivered products
    // (use the Order.isDelivered flag)

    var result: Product? = null
    orders.partition { order -> order.isDelivered }
            .first.forEach {
        val temp = it.products.maxBy { product -> product.price }
        if (result == null || (temp != null && temp.price > result!!.price)) result = temp
    }
    return result
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    // Return the number of times the given product was ordered.
    // Note: a customer may order the same product for several times.
    var times = 0
    customers.forEach { it.orders.forEach{ order: Order -> order.products.forEach { p -> if (p.name == product.name) times++ } } }
    return times
}
