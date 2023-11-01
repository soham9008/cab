package topfree.fightgame.cab

fun main(args: Array<String>) {
    val rows = 5
    var k = 0

    for (i in 1..5) {
        for (space in 1..5 - i) {
            print("  ")
        }

        while (k != 2 * i -1) {
            print("* ")
            ++k
        }

        println()
        k = 0
    }
}