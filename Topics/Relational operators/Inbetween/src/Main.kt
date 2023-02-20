fun main() {
    val input0 = readln().toInt()
    val input1 = readln().toInt()
    val input2 = readln().toInt()

    if (input1 < input2) {
        println(input0 in input1..input2)
    } else {
        println(input0 in input1 downTo input2)
    }

}