import java.util.*

fun ClosedRange<Int>.random(): Int {
    return Random().nextInt(endInclusive - start) + start
}