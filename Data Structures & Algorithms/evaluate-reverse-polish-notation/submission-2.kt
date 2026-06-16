class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val list = tokens.toMutableList()
        var current = 0

        while (current < list.size) {

            val str = list[current]
            when (str) {
                "+" -> {
                    val active = list[current - 2].toInt() + list[current - 1].toInt()
                    list.removeAt(current)
                    list.removeAt(current - 1)
                    list.removeAt(current - 2)
                    list.add(current - 2, active.toString())
                    current -= 2
                }

                "-" -> {
                    val active = list[current - 2].toInt() - list[current - 1].toInt()
                    list.removeAt(current)
                    list.removeAt(current - 1)
                    list.removeAt(current - 2)
                    list.add(current - 2, active.toString())
                    current -= 2
                }

                "*" -> {
                    val active = list[current - 2].toInt() * list[current - 1].toInt()
                    list.removeAt(current)
                    list.removeAt(current - 1)
                    list.removeAt(current - 2)
                    list.add(current - 2, active.toString())
                    current -= 2
                }

                "/" -> {
                    val active = if(list[current - 1].toInt() != 0) 
                        list[current - 2].toInt() / list[current - 1].toInt()
                    else
                        0

                    list.removeAt(current)
                    list.removeAt(current - 1)
                    list.removeAt(current - 2)
                    list.add(current - 2, active.toString())
                    current -= 2
                }

                else -> {
                    current += 1
                }
            }
        }

        return if (list.size == 0) 0 else list[0].toInt()
    }
}
