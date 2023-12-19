fun main() {
    val triangle = inputTriangle()
    val point = inputPoint()

    if (isInsideTriangle(triangle, point)) {
        println("Точка находится внутри треугольника")
    } else {
        println("Точка находится вне треугольника")
    }
}

data class Point(val x: Double, val y: Double)
data class Triangle(val A: Point, val B: Point, val C: Point)

fun inputTriangle(): Triangle {
    println("Введите координаты вершин треугольника:")
    val A = inputPoint("A")
    val B = inputPoint("B")
    val C = inputPoint("C")
    return Triangle(A, B, C)
}

fun inputPoint(name: String = ""): Point {
    var x: Double
    var y: Double
    while (true) {
        try {
            print("Введите координаты точки $name (x y): ")
            val input = readLine()!!.split(" ")
            require(input.size == 2) { "Введите две координаты через пробел" }
            x = input[0].toDouble()
            y = input[1].toDouble()
            break
        } catch (e: Exception) {
            println("Ошибка: ${e.message}. Попробуйте еще раз.")
        }
    }
    return Point(x, y)
}

fun isInsideTriangle(triangle: Triangle, point: Point): Boolean {
    val d1 = sign(point, triangle.A, triangle.B)
    val d2 = sign(point, triangle.B, triangle.C)
    val d3 = sign(point, triangle.C, triangle.A)
    val hasNegative = (d1 < 0)  (d2 < 0)  (d3 < 0)
    val hasPositive = (d1 > 0)  (d2 > 0)  (d3 > 0)
    return !(hasNegative && hasPositive)
}

fun sign(p1: Point, p2: Point, p3: Point): Double {
    return (p1.x - p3.x) * (p2.y - p3.y) - (p2.x - p3.x) * (p1.y - p3.y)
}
