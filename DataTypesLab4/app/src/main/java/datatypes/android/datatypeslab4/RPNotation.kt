package datatypes.android.datatypeslab4

import java.lang.ArithmeticException
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.pow

class RPNotation internal constructor(inputString: String){

    var inputString: String? = null
        private set

    private val validValues = "x()+-/*^1234567890"

    init {
        for (char in inputString) {
            if (validValues.contains(char, true)) {
                this.inputString = inputString
            } else {
                throw IllegalArgumentException("The input string has invalid character: $char")
            }
        }
    }

    // 1) Курсор ставится на первый элемент входной строки
    // 2) ЕСЛИ рассматриваемый элемент представляет собой число (или переменную, например, x),
    // этот элемент помещается в выходную строку, ИНАЧЕ
    // 3) ЕСЛИ рассматриваемый элемент "(", то он помещается в стек, ИНАЧЕ
    // 4) ЕСЛИ рассматриваемый элемент ")", то требуется вытолкнуть из стека в выходную строку все элементы,
    // пока не встретим "(" - скобку уничтожаем, ИНАЧЕ
    // 5) ЕСЛИ это знак операции (это может быть имя функции), то
    //      а) если стек пуст (или сверху открывающая скобка), то знак помещается в стек, иначе
    //      б) если стек не пуст, то если приоритет верхнего знака в стеке меньше рассматриваемого знака,
    //          то добавить знак в стек, иначе
    //      в) вытолкнуть верхний знак из стека в выходную строку и повторить шаг 5), не смещая курсора
    // 6) Сместить курсор к следующему элементу входной строки.
    // 7) Если входная строка кончилась, то вытолкнуть знаки из стека в выходную строку
    // Примечание: если перед "(" в стеке лежит функция, то извлекаем функцию
    fun convertToRP() : ArrayList<String> {
        val stack = ArrayDeque<String>()
        val input = inputString
        var resultString = arrayListOf<String>()
        val stringTokenizer = StringTokenizer(input, "+-*/()^")


        var cursor : Int = 0
        while (cursor < input!!.length) {
            if (input[cursor].isDigit() or
                input[cursor].equals('x', true)) {

                val number = stringTokenizer.nextToken()
                resultString.add(number)
                cursor += number.length - 1

            } else if (input[cursor].equals('(')) {
                stack.push(input[cursor].toString())
            } else if (input[cursor].equals(')')) {
                do {
                    resultString.add(stack.pop())
                } while (stack.element().equals('('))
                stack.removeFirst() //remove '(' from stack
            } else {
                if (input[cursor] == '-' && ((cursor == 0) || (!input[cursor-1].isDigit() && input[cursor-1] != ')') )) {
                    //функция Унарный минус
                    stack.push("u-")
                } else if (
                    (input[cursor] == '+') or
                    (input[cursor] == '-') or
                    (input[cursor] == '/') or
                    (input[cursor] == '*') or
                    (input[cursor] == '^')
                ) {
                    while (true) {
                        if ((stack.isEmpty()) or (stack.peekFirst() == "(")) {
                            stack.push(input[cursor].toString())
                            break
                        } else if (getPriority(stack.element()) < getPriority(input[cursor])) {
                            stack.push(input[cursor].toString())
                            break
                        } else {
                            resultString.add(stack.pop())
                        }
                    }
                }


            }
            cursor++
        }
        while (stack.isNotEmpty()) {
            resultString.add(stack.pop())
        }
        return resultString
    }

    private fun getPriority(char: Char) : Int {
        when (char) {
            '(', ')' -> return 0
            '+', '-' -> return 1
            '*', '/' -> return 2
            '^' -> return 3
            else -> return 4
        }
    }

    private fun getPriority(s: String) : Int {
        when (s) {
            "(", ")" -> return 0
            "+", "-" -> return 1
            "*", "/" -> return 2
            "^" -> return 3
            else -> return 4
        }
    }

    fun calculateFromRP(rpString: ArrayList<String>) : Double {
        var result: Double = 0.0
        val stack = ArrayDeque<String>()
        var cursor: Int = 0

        while (cursor < rpString.size) {
            // если под курсором число,
            // то кладем его в стек
            if (rpString[cursor].matches(Regex("\\d+"))) {
                stack.push(rpString[cursor])
            } else {
                // иначе видим знак и извлекаем аргументы от последнего до первого
                // и кладем в стек результат операции
                if (rpString[cursor] == "u-") {
                    result = -stack.pop().toDouble()
                } else {
                    val firstArg = stack.pop().toDouble()
                    val secondArg = stack.pop().toDouble()
                    when(rpString[cursor]) {
                        "+" -> result = secondArg + firstArg
                        "-" -> result = secondArg - firstArg
                        "*" -> result = secondArg * firstArg
                        "/" -> {
                            if (firstArg != 0.0) {
                                result = secondArg / firstArg
                            } else {
                                throw ArithmeticException("В примере есть деление $secondArg на 0")
                            }

                        }
                        "^" -> result = secondArg.pow(firstArg)
                    }
                }
                stack.push(result.toString())
            }
            cursor++
        }

        return stack.pop().toDouble()
    }
}