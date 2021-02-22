import kotlin.math.sqrt
import kotlin.math.pow

data class Location(val x : Double, val y: Double)

data class Velocity(val dx : Double, val dy : Double)

fun move(start: Location, velocity: Velocity) =
    Location(start.x + velocity.dx, start.y + velocity.dy)

fun distance(l1: Location, l2: Location) =
        sqrt((l1.x - l2.x).pow(2) + (l1.y - l2.y).pow(2))
