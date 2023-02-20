import kotlin.math.pow
fun main() {
    val operation = readln()
    val value = readln().toInt()

    when (operation) {
        "amount" -> println(interest(amount = value))
        "percent" -> println(interest(percent = value))
        "years" -> println(interest(years = value))
    }
}
fun interest(amount: Int = 1000, percent: Int = 5, years: Int = 10): Int {
    val finalAmount = amount * (1 + percent / 100.0).pow(years)
    return finalAmount.toInt()
}