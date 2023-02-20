const val gravityAcc = 9.8
fun main() {
    val fluidDensity = readln().toDouble()
    val heightOfLiquidColumn = readln().toDouble()
    val liquidPressure = fluidDensity * heightOfLiquidColumn * gravityAcc
    println(liquidPressure)
}