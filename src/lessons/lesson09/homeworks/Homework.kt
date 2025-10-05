package lessons.lesson09.homeworks

fun main() {
    // Array
    val arr1 = arrayOf(1, 2, 3, 4, 5)
    val arr2 = Array(10) { "" }
    val arr3 = Array(5) { i -> i * 2.0 }
    val arr4 = Array(5) { 0 }
    for (i in arr4.indices) arr4[i] = i * 3
    val arr5 = arrayOf<String?>(null, "Hello", "World")
    val arr6 = arrayOf(1, 2, 3, 4, 5)
    val arr7 = Array(arr6.size) { 0 }
    for (i in arr6.indices) arr7[i] = arr6[i]
    val arr8a = arrayOf(10, 20, 30)
    val arr8b = arrayOf(1, 2, 3)
    val arr8c = Array(arr8a.size) { i -> arr8a[i] - arr8b[i] }
    println(arr8c.joinToString())
    val arr9 = arrayOf(1, 2, 3, 4, 6)
    var index = 0
    var found = -1
    while (index < arr9.size) {
        if (arr9[index] == 5) { found = index; break }
        index++
    }
    println(found)
    val arr10 = arrayOf(1, 2, 3, 4, 5, 6)
    for (x in arr10) {
        val type = if (x % 2 == 0) "чётное" else "нечётное"
        println("$x -> $type")
    }
    findSubstring(arrayOf("Kotlin", "Java", "Python"), "ava")

    // List
    val list1 = listOf<Int>()
    val list2 = listOf("Hello", "World", "Kotlin")
    val list3 = mutableListOf(1, 2, 3, 4, 5)
    list3.addAll(listOf(6, 7, 8))
    val list4 = mutableListOf("Hello", "World", "Kotlin")
    list4.remove("World")
    val list5 = listOf(10, 20, 30)
    for (x in list5) println(x)
    val list6 = listOf("a", "b", "c")
    println(list6[1])
    val list7 = mutableListOf(1, 2, 3, 4)
    list7[2] = 99
    val list8a = listOf("a", "b")
    val list8b = listOf("c", "d")
    val list8c = mutableListOf<String>()
    for (x in list8a) list8c.add(x)
    for (x in list8b) list8c.add(x)
    println(list8c)
    val list9 = listOf(5, 10, 1, 20)
    var min = list9[0]
    var max = list9[0]
    for (x in list9) {
        if (x < min) min = x
        if (x > max) max = x
    }
    println("min=$min max=$max")
    val list10 = listOf(1, 2, 3, 4, 5, 6)
    val listEven = mutableListOf<Int>()
    for (x in list10) if (x % 2 == 0) listEven.add(x)
    println(listEven)

    // Set
    val set1 = setOf<Int>()
    val set2 = setOf(1, 2, 3)
    val set3 = mutableSetOf("Kotlin", "Java", "Scala")
    set3.addAll(listOf("Swift", "Go"))
    val set4 = mutableSetOf(1, 2, 3)
    set4.remove(2)
    val set5 = setOf(100, 200, 300)
    for (x in set5) println(x)
    println(checkStringInSet(set3, "Go"))
    val set6 = setOf("x", "y", "z")
    val listFromSet = mutableListOf<String>()
    for (x in set6) listFromSet.add(x)
    println(listFromSet)
}

fun findSubstring(arr: Array<String>, search: String) {
    for (x in arr) if (x.contains(search)) println(x)
}

fun checkStringInSet(set: Set<String>, str: String): Boolean {
    for (x in set) if (x == str) return true
    return false
}
