fun main() {
    val color = readln().uppercase()
    for (enum in Rainbow.values()) {
        if (color == enum.name) println(enum.ordinal + 1)
    }
}
enum class Rainbow {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}