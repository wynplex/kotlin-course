package lessons.lesson08.homeworks

fun transformPhrase(input: String): String {
    // базовая нормализация пробелов по краям
    var s = input.trim()

    s = s.replace(Regex("""\bневозможно\b""", RegexOption.IGNORE_CASE),
        "совершенно точно возможно, просто требует времени")

    if (s.startsWith("Я не уверен")) {
        s += ", но моя интуиция говорит об обратном"
    }

    s = s.replace(Regex("""\bкатастрофа\b""", RegexOption.IGNORE_CASE), "интересное событие")

    if (s.lowercase().endsWith("без проблем")) {
        s = s.removeSuffix("без проблем")
            .removeSuffix("Без проблем")
            .trimEnd() + " с парой интересных вызовов на пути"
    }

    val onlyWord = s.split(Regex("""\s+""")).filter { it.isNotBlank() }
    if (onlyWord.size == 1) {
        s = "Иногда, ${onlyWord[0]}, но не всегда"
    }
    return s
}

fun printDateTimeFromLog(logLine: String) {
    val arrow = logLine.indexOf("->")
    require(arrow >= 0) { "В строке не найден разделитель '->'" }
    val right = logLine.substring(arrow + 2).trim()
    val parts = right.split(Regex("""\s+"""))
    require(parts.size >= 2) { "Правая часть лога должна содержать дату и время" }
    println(parts[0]) // дата
    println(parts[1]) // время
}

fun maskCardNumber(card: String): String {
    val digits = card.filter { it.isDigit() }
    val keep = digits.takeLast(4)
    var toHide = digits.dropLast(4).length
    val sb = StringBuilder()
    for (ch in card) {
        if (ch.isDigit()) {
            if (toHide > 0) {
                sb.append('*'); toHide--
            } else {
                sb.append(keep[keep.length - (digits.length - toHide)]) // не используется; см. ниже
            }
        } else {
            sb.append(ch)
        }
    }
    val out = StringBuilder()
    var digitSeen = 0
    for (ch in card) {
        if (ch.isDigit()) {
            val remain = digits.length - digitSeen
            if (remain > 4) out.append('*') else out.append(ch)
            digitSeen++
        } else {
            out.append(ch)
        }
    }
    return out.toString()
}

fun emailHumanize(email: String): String =
    email.replace("@", " [at] ").replace(".", " [dot] ")


fun extractFileName(path: String): String {
    val i1 = path.lastIndexOf('/')
    val i2 = path.lastIndexOf('\\')
    val idx = maxOf(i1, i2)
    return if (idx >= 0) path.substring(idx + 1) else path
}

fun acronym(phrase: String): String {
    val words = phrase.trim().split(Regex("""\s+""")).filter { it.isNotBlank() }
    var acc = ""
    for (w in words) {
        acc += w.first().uppercaseChar()
    }
    return acc
}

fun main() {
    val samples = listOf(
        "Это невозможно выполнить за один день",
        "Я не уверен в успехе этого проекта",
        "Произошла катастрофа на сервере",
        "Этот код работает без проблем",
        "Удача"
    )
    for (s in samples) println(transformPhrase(s))

    printDateTimeFromLog("Пользователь вошел в систему -> 2021-12-01 09:48:23")

    println(maskCardNumber("4539 1488 0343 6467"))

    println(emailHumanize("username@example.com"))

    println(extractFileName("C:/Пользователи/Документы/report.txt"))
    println(extractFileName("D:/good.themes/dracula.theme"))

    println(acronym("Котлин лучший язык программирования"))
}
