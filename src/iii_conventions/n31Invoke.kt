package iii_conventions

import util.TODO


class Invokable {
    var invocations = 0
    fun getNumberOfInvocations(): Int {
        return invocations
    }

    operator fun invoke(): Invokable {
        invocations++
        return this
    }
}

fun todoTask31(): Nothing = TODO(
        """
        Task 31.
        Change the class 'Invokable' to count the number of invocations:
        for 'invokable()()()()' it should be 4.
    """,
        references = { invokable: Invokable -> })

fun task31(invokable: Invokable): Int {
    return invokable()()()().getNumberOfInvocations()
}
