data class Location(val x : Double, val y: Double)

data class Velocity(val dx : Double, val dy : Double)

fun move(start: Location, velocity: Velocity) =
    Location(start.x + velocity.dx, start.y + velocity.dy)