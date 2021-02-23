import pt.isel.canvas.MouseEvent

data class Ball(val start: Location, val current: Location, val velocity: Velocity)


const val BALL_RADIUS = 7

val initialVelocity = Velocity(0.0, -4.0)

fun moveBall(ball: Ball) = Ball(
        ball.start,
        move(ball.current, ball.velocity),
        ball.velocity
)


fun createBall(x : Double, y : Double) : Ball{
    return Ball(
            start = Location(x, y),
            current = Location(x, y),
            velocity = Velocity(.0,.0)
    )
}
fun createLifes(x : Double, y : Double) : Ball{
    return Ball(
            start = Location(x, y),
            current = Location(x, y),
            velocity = Velocity(.0,.0)
    )
}

fun offLimitsRightX(ball: Ball): Boolean =
        ball.current.x + BALL_RADIUS >= ARENA_WIDTH

fun offLimitsLeftX(ball: Ball): Boolean =
       ball.current.x - BALL_RADIUS <= 0.0

fun offLimitsY(ball: Ball): Boolean =
        ball.current.y <= BALL_RADIUS

fun ballInsideArena(ball: Ball): Boolean =
        ball.current.y + BALL_RADIUS <= ARENA_HEIGHT

fun invertVelocityLeftX(ball: Ball): Ball {

    return Ball(
            ball.start,
            Location(x = BALL_RADIUS.toDouble(), y= ball.current.y),
            Velocity(-ball.velocity.dx, ball.velocity.dy)
    )
}

fun invertVelocityRightX(ball: Ball): Ball {

    return Ball(
            ball.start,
            Location(x = ARENA_WIDTH.toDouble()- BALL_RADIUS, y= ball.current.y),
            Velocity(-ball.velocity.dx, ball.velocity.dy)
    )
}

fun invertVelocityY(ball: Ball): Ball {

    return Ball(ball.start, Location(x=ball.current.x, y= BALL_RADIUS.toDouble()), Velocity(ball.velocity.dx, -ball.velocity.dy))
}



