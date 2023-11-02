import java.lang.IllegalArgumentException

// ф-ция чтобы вычислить плозадь треугольника
fun calculateTriangleArea(x1: Double, y1: Double, x2: Double, y2: Double, x3: Double, y3: Double): Double {
    return (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2
}

// ерить находится ли точка в теуглольнике фунция чтобы пров
fun isPointInsideTriangle(x1: Double, y1: Double, x2: Double, y2: Double, x3: Double, y3: Double, x: Double, y: Double): Boolean {
    val triangleArea = calculateTriangleArea(x1, y1, x2, y2, x3, y3)
    val area1 = calculateTriangleArea(x, y, x2, y2, x3, y3)
    val area2 = calculateTriangleArea(x1, y1, x, y, x3, y3)
    val area3 = calculateTriangleArea(x1, y1, x2, y2, x, y)

    return triangleArea == area1 + area2 + area3
}

fun main() {
    try {
        println("введите координаты вершин треугольника:")
        print("вершина 1 (x1 y1): ")
        val x1 = readLine()!!.toDouble()
        val y1 = readLine()!!.toDouble()

        print("вершина 2 (x2 y2): ")
        val x2 = readLine()!!.toDouble()
        val y2 = readLine()!!.toDouble()

        print("вершина 3 (x3 y3): ")
        val x3 = readLine()!!.toDouble()
        val y3 = readLine()!!.toDouble()

        println("введите координаты точки:")
        print("точка (x y): ")
        val x = readLine()!!.toDouble()
        val y = readLine()!!.toDouble()

        val isInside = isPointInsideTriangle(x1, y1, x2, y2, x3, y3, x, y)
        if (isInside) {
            println("точка внутри треугольника")
        } else {
            println("точка вне труегольника")
        }
    } catch (e: IllegalArgumentException) {
        println("введите цифры пожалуйста")
    } catch (e: NullPointerException) {
        println("введите новые координаты")
    }
}