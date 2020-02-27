package iii_conventions

/**
 * MyDate 类，演示了 Kotlin 中的操作符重载，不但可以重载 >< 等，还可以重载 + - .. 等操作符
 * */

/**
 * 实现 Comparable 就可以使用 >=< 来比较大小了
 * */
data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        if (year > other.year) return 1
        if (year < other.year) return -1
        else {
            if (month > other.month) return 1
            if (month < other.month) return -1
            else {
                if (dayOfMonth > other.dayOfMonth) return 1
                return if (dayOfMonth < other.dayOfMonth) -1
                else 0
            }
        }
    }
}

/**
 * 实现 rangeTo 就可以调用 .. 操作符了
 * */
operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

/**
 * 实现 plus 就可以调用 + 操作符了
 * */
operator fun MyDate.plus(interval: TimeInterval): MyDate {
    return addTimeIntervals(interval, 1)
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

/**
 * 允许乘法的 TimeInterval，接收 TimeInterval 与 times
 * */
class RepeatedTimeInterval(val ti: TimeInterval, val times: Int)

/**
 * 实现 times 就可以调用 * 操作符了
 * */
operator fun TimeInterval.times(times: Int): RepeatedTimeInterval {
    return RepeatedTimeInterval(this, times)
}

/**
 * 重载 plus 方法，使得 RepeatedTimeInterval 支持 * 的同时也支持 + 操作
 * */
operator fun MyDate.plus(interval: RepeatedTimeInterval): MyDate {
    return addTimeIntervals(interval.ti, interval.times)
}

/**
 * 实现 Iterator 和 Java 中类似，需要实现 hasNext() 和 next() 方法
 * */
class DateIterator(start: MyDate, private val endInclusive: MyDate) : Iterator<MyDate> {

    /**
     * current date
     * */
    private var current = start

    /**
     * 实现 hasNext() 方法判断是否还有后续的元素
     * */
    override fun hasNext(): Boolean {
        return current <= endInclusive
    }

    /**
     * 实现 next() 方法来移动到下一个
     * */
    override fun next(): MyDate {
        val copy = current
        current = current.nextDay()
        return copy
    }
}

/**
 * 实现 ClosedRange 就可以使用 in 操作符了
 * 实现 Iterable 就可以使用 for loop 了
 * */
class DateRange(override val start: MyDate, override val endInclusive: MyDate) : ClosedRange<MyDate>, Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return DateIterator(start, endInclusive)
    }

//    override fun contains(value: MyDate): Boolean {} // 可以使用默认实现 value >= start && value <= endInclusive
}
