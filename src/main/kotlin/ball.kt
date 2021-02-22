import pt.isel.canvas.MouseEvent

data class Ball(val start: Location, val current: Location, val velocity: Velocity)


const val BALL_RADIUS = 7

val initialVelocity = Velocity(0.0, -4.0)

fun initializeBall(game: Game): Ball {
    val start = Location(game.racket.location.x, game.racket.location.y + RACKET_HEIGHT / 2)
    val newVelocity = initialVelocity

    return Ball(start, start, newVelocity)
}

fun addVelocity(ball: Ball) : Ball{
    return Ball(ball.start,ball.current, Velocity(0.0,-4.0))
}

fun createBall(x:Double, y : Double, velocity: Velocity) : Ball {
    return Ball(Location(x,y),Location(x,y), velocity)
}



fun moveBall(ball: Ball) = Ball(
        ball.start,
        move(ball.current, ball.velocity),
        ball.velocity
)


fun offLimitsX(ball: Ball): Boolean =
        ball.current.x + BALL_RADIUS >= ARENA_WIDTH || ball.current.x - BALL_RADIUS <= 0

fun offLimitsY(ball: Ball): Boolean =
        ball.current.y + BALL_RADIUS <= 0

fun ballInsideArena(ball: Ball): Boolean =
        ball.current.y + BALL_RADIUS <= ARENA_HEIGHT

fun invertVelocityX(ball: Ball): Ball {

    return Ball(ball.start, ball.current, Velocity(-ball.velocity.dx, ball.velocity.dy))
}

fun invertVelocityY(ball: Ball): Ball {

    return Ball(ball.start, ball.current, Velocity(ball.velocity.dx, -ball.velocity.dy))
}

fun invertVelocityLeftSideS1(ball: Ball): Ball {

    return Ball(ball.start, ball.current, Velocity(ball.velocity.dx - 3, -ball.velocity.dy))
}

fun invertVelocityRightSideS1(ball: Ball): Ball {

    return Ball(Location(ball.current.x, (RACKET_LOCATION_Y + RACKET_HEIGHT).toDouble()), ball.current, Velocity(ball.velocity.dx + 3, -ball.velocity.dy))
}

fun invertVelocityLeftSideS2(ball: Ball): Ball {

    return Ball(Location(ball.current.x, (RACKET_LOCATION_Y + RACKET_HEIGHT).toDouble()), ball.current, Velocity(ball.velocity.dx - 1, -ball.velocity.dy))
}

fun invertVelocityRightSideS2(ball: Ball): Ball {

    return Ball(Location(ball.current.x, (RACKET_LOCATION_Y + RACKET_HEIGHT).toDouble()), ball.current, Velocity(ball.velocity.dx + 1, -ball.velocity.dy))
}

