import kotlin.math.ceil


class Content{
    fun main() {
        // Частина 1

        // Дано рядок у форматі "Student1 - Group1; Student2 - Group2; ..."

        val studentsStr = "Дмитренко Олександр - ІП-84; Матвійчук Андрій - ІВ-83; Лесик Сергій - ІО-82; Ткаченко Ярослав - ІВ-83; Аверкова Анастасія - ІО-83; Соловйов Даніїл - ІО-83; Рахуба Вероніка - ІО-81; Кочерук Давид - ІВ-83; Лихацька Юлія - ІВ-82; Головенець Руслан - ІВ-83; Ющенко Андрій - ІО-82; Мінченко Володимир - ІП-83; Мартинюк Назар - ІО-82; Базова Лідія - ІВ-81; Снігурець Олег - ІВ-81; Роман Олександр - ІО-82; Дудка Максим - ІО-81; Кулініч Віталій - ІВ-81; Жуков Михайло - ІП-83; Грабко Михайло - ІВ-81; Иванов Володимир - ІО-81; Востриков Нікіта - ІО-82; Бондаренко Максим - ІВ-83; Скрипченко Володимир - ІВ-82; Кобук Назар - ІО-81; Дровнін Павло - ІВ-83; Тарасенко Юлія - ІО-82; Дрозд Світлана - ІВ-81; Фещенко Кирил - ІО-82; Крамар Віктор - ІО-83; Иванов Дмитро - ІВ-82"

        // Завдання 1
        // Заповніть словник, де:
        // - ключ – назва групи
        // - значення – відсортований масив студентів, які відносяться до відповідної групи

        val studentsGroups = HashMap<String, MutableList<String>>()
        val students = studentsStr.split("; ")
        for (student in students) {
            val nameAndGroup = student.split(" - ")
            val name = nameAndGroup[0]
            val group = nameAndGroup[1]
            var groupId = studentsGroups[group]
            if (groupId === null) {
                groupId = ArrayList()
            }
            groupId.add(name)
            studentsGroups[group] = groupId
        }
        for(entry in studentsGroups){
            entry.value.sort()
        }


        println("Завдання 1")
        println(studentsGroups)
        println()

        // Дано масив з максимально можливими оцінками

        val points = arrayOf(12, 12, 12, 12, 12, 12, 12, 16)

        // Завдання 2
        // Заповніть словник, де:
        // - ключ – назва групи
        // - значення – словник, де:
        //   - ключ – студент, який відносяться до відповідної групи
        //   - значення – масив з оцінками студента (заповніть масив випадковими значеннями, використовуючи функцію `randomValue(maxValue: Int) -> Int`)

        fun randomValue (maxValue: Int): Int {
            return when((0..6).random()) {
                1 -> (ceil(maxValue.toDouble()) * 0.7).toInt()

                2 -> (ceil(maxValue.toDouble()) * 0.9).toInt()

                3, 4, 5 -> maxValue

                else -> 0
            }
        }

        val studentPoints = HashMap<String, MutableMap<String, ArrayList<Int>>>()

        studentsGroups.forEach {
            val map = HashMap<String, ArrayList<Int>>()
            it.value.forEach {
                val list = ArrayList<Int>()
                for(point in points){
                    list.add(randomValue(point))
                }
                map[it] = list
            }
            studentPoints[it.key] = map
        }


        println("Завдання 2")
        println(studentPoints)
        println()

        // Завдання 3
        // Заповніть словник, де:
        // - ключ – назва групи
        // - значення – словник, де:
        //   - ключ – студент, який відносяться до відповідної групи
        //   - значення – сума оцінок студента

        val sumPoints = HashMap<String, MutableMap<String, Int>>()

        // Ваш код починається тут
        studentPoints.toMutableMap()
        studentPoints.forEach {
            val map = HashMap<String, Int>()
            it.value.forEach {
                map[it.key] = it.value.sum()
            }
            sumPoints[it.key] = map
        }


        println("Завдання 3")
        println(sumPoints)
        println()


        // Завдання 4
        // Заповніть словник, де:
        // - ключ – назва групи
        // - значення – середня оцінка всіх студентів групи

        val groupAvg = HashMap<String, Double>()

        // Ваш код починається тут
        sumPoints.forEach {
            val allPoints = ArrayList<Int>()
            it.value.forEach {
                allPoints.add(it.value)
            }
            groupAvg[it.key] = allPoints.average()
        }


        println("Завдання 4")
        println(groupAvg)
        println()

        // Завдання 5
        // Заповніть словник, де:
        // - ключ – назва групи
        // - значення – масив студентів, які мають >= 60 балів

        val passedPerGroup = HashMap<String, ArrayList<String>>()

        sumPoints.forEach {
            val topStudent = ArrayList<String>()
            it.value.forEach {
                if(it.value >= 60){
                    topStudent.add(it.key)
                }
            }
            passedPerGroup[it.key] = topStudent
        }


        println("Завдання 5")
        println(passedPerGroup)

    }
}