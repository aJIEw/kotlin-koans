package ii_collections

fun example4() {
    val max = listOf(1, 42, 4).max()
    val longestString = listOf("a", "b").maxBy { it.length }
}

fun Shop.getCustomerWithMaximumNumberOfOrders(): Customer? {
    // Return a customer whose order count is the highest among all customers
    return customers.maxBy { it.orders.size }
}

fun Customer.getMostExpensiveOrderedProduct(): Product? {
    // Return the most expensive product which has been ordered
    var mep: Product? = orders[0].products.maxBy { it.price }
    for (order in orders) {
        val temp = order.products.maxBy { it.price }
        if (mep == null) {
            mep = temp
            continue
        }

        if (mep.price < temp?.price!!) {
            mep = temp
        }
    }

    return mep
}
