package lessons.lesson07.homeworks

fun main() {

    // Циклы for
    // Прямой диапазон
    for (i in 1..5) {
        println(i)
    }

    for (i in 2..10 step 2) {
        println(i)
    }

    // Обратный диапазон
    for (i in 5 downTo 1) {
        println(i)
    }

    for (i in 10 downTo 1 step 2) {
        println(i)
    }

    // С шагом
    for (i in 1..9 step 2) {
        println(i)
    }

    for (i in 1..20 step 3) {
        println(i)
    }

    // until
    val size = 12
    for (i in 3 until size step 2) {
        println(i)
    }

    // Циклы while
    var i = 1
    while (i <= 5) {
        println(i * i)
        i++
    }

    var n = 10
    while (n >= 5) {
        println(n)
        n--
    }

    // Циклы do while
    var j = 5
    do {
        println(j)
        j--
    } while (j >= 1)

    var k = 5
    do {
        println(k)
        k++
    } while (k < 10)

    //  break 
    for (m in 1..10) {
        if (m == 6) break
        println(m)
    }

    var x = 1
    while (true) {
        println(x)
        if (x == 10) break
        x++
    }

    // continue
    for (c in 1..10) {
        if (c % 2 == 0) continue
        println(c)
    }

    var y = 1
    while (y <= 10) {
        if (y % 3 == 0) {
            y++
            continue
        }
        println(y)
        y++
    }
}
