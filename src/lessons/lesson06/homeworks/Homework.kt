package lessons.lesson06.homeworks

import kotlin.math.floor

// 1. Определение сезона
fun printSeason(month: Int) {
    if (month !in 1..12) {
        println("Некорректный месяц")
        return
    }
    val season = when (month) {
        12, 1, 2 -> "зима"
        3, 4, 5 -> "весна"
        6, 7, 8 -> "лето"
        else -> "осень"
    }
    println(season)
}

// 2. Расчет возраста питомца
fun printDogAgeHumanYears(dogYears: Double) {
    if (dogYears < 0.0) {
        println("Некорректный возраст")
        return
    }
    val humanYears = if (dogYears <= 2.0) {
        dogYears * 10.5
    } else {
        2 * 10.5 + (dogYears - 2.0) * 4.0
    }
    println(humanYears)
}

// 3. Определение способа перемещения
fun printTransportByDistance(distanceKm: Double) {
    if (distanceKm <= 0.0) {
        println("Некорректная дистанция")
        return
    }
    val mode = when {
        distanceKm <= 1.0 -> "пешком"
        distanceKm <= 5.0 -> "велосипед"
        else -> "автотранспорт"
    }
    println(mode)
}

// 4. Расчет бонусных баллов
fun printBonusPoints(amountRub: Double) {
    if (amountRub <= 0.0) {
        println(0)
        return
    }
    val groups = floor(amountRub / 100.0).toInt()
    val pointsPer100 = if (amountRub <= 1000.0) 2 else 3
    val points = groups * pointsPer100
    println(points)
}

// 5. Определение типа документа
fun printDocumentType(fileNameOrExt: String) {
    val raw = fileNameOrExt.trim()
    if (raw.isEmpty()) {
        println("Неизвестный тип")
        return
    }
    val ext = raw.substringAfterLast('.', raw).lowercase()

    val text = setOf("txt", "md", "rtf", "doc", "docx")
    val image = setOf("jpg", "jpeg", "png", "gif", "bmp", "webp", "tiff", "svg", "heic")
    val table = setOf("xls", "xlsx", "xlsm", "csv", "tsv", "ods")

    val kind = when {
        ext in text -> "Текстовый документ"
        ext in image -> "Изображение"
        ext in table -> "Таблица"
        else -> "Неизвестный тип"
    }
    println(kind)
}

// 6. Конвертация температуры
fun printConvertedTemperature(value: Double, unit: Char) {
    val u = unit.uppercaseChar()
    when (u) {
        'C' -> {
            val out = value * 9.0 / 5.0 + 32.0
            print(out)
            print("F")
            println()
        }
        'F' -> {
            val out = (value - 32.0) * 5.0 / 9.0
            print(out)
            print("C")
            println()
        }
        else -> println("Некорректная единица измерения")
    }
}

// 7. Подбор одежды по погоде
fun printClothesByTemperature(tempC: Int) {
    if (tempC < -100 || tempC > 100) {
        println("Некорректная температура")
        return
    }
    if (tempC < -30 || tempC > 35) {
        println("оставайтесь дома")
        return
    }
    val rec = when {
        tempC < 10 -> "куртка и шапка"
        tempC <= 18 -> "ветровка"
        else -> "футболка и шорты"
    }
    println(rec)
}

// 8. Выбор фильма по возрасту
fun categoryByAge(age: Int): String {
    if (age < 0) return "Некорректный возраст"
    return when (age) {
        in 0..9 -> "детские"
        in 10..18 -> "подростковые"
        else -> "18+"
    }
}
