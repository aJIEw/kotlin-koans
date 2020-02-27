package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
    // Return the set of customers who ordered the specified product
    return customers.filter { it.orderedProducts.contains(product) }.toSet()
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    // Return the most expensive product among all delivered products
    // (use the Order.isDelivered flag)

    return orders.partition { order -> order.isDelivered }
            .first.flatMap { it.products }.maxBy { it.price }
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    // Return the number of times the given product was ordered.
    // Note: a customer may order the same product for several times.
    var times = 0
    customers.forEach { it.orders.forEach { order: Order -> order.products.forEach { p -> if (p.name == product.name) times++ } } }
    return times

    // or use flatmap
//    return customers.flatMap { it.orders }.flatMap { it.products }.count { it == product}
}
