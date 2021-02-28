import pt.isel.canvas.MouseEvent

data class Ball(val start: Location, val current: Location, val velocity: Velocity)


const val BALL_RADIUS = 7

val initialVelocity = Velocity(0.0, -4.0)

/**
 * This function will add the determined velocity to the ball, making the ball move
 * @param ball Ball that is going to be moved
 */

fun moveBall(ball: Ball) = Ball(
        ball.start,
        move(ball.current, ball.velocity),
        ball.velocity
)

/**
 * The following function will create a ball inside the set parameters.
 * @param x X coordinate where the ball is going to be created
 * @param y Y coordinate where the ball is going to be created
 */

fun createBall(x : Double, y : Double) : Ball{
    return Ball(
            start = Location(x, y),
            current = Location(x, y),
            velocity = Velocity(.0,.0)
    )
}

/**
 * The following function will create a live inside the set parameters.
 * @param x X coordinate where the ball is going to be created
 * @param y Y coordinate where the ball is going to be created
 */

fun createLives(x : Double, y : Double) : Ball{
    return Ball(
            start = Location(x, y),
            current = Location(x, y),
            velocity = Velocity(.0,.0)
    )
}

/**
 * The following functions will determine true if the ball has reached a certain point in the arena
 * @param ball Ball that is going to be analysed
 */


fun offLimitsRightX(ball: Ball): Boolean =
        ball.current.x + BALL_RADIUS >= ARENA_WIDTH

fun offLimitsLeftX(ball: Ball): Boolean =
       ball.current.x - BALL_RADIUS <= 0.0

fun offLimitsY(ball: Ball): Boolean =
        ball.current.y <= BALL_RADIUS

fun ballInsideArena(ball: Ball): Boolean =
        ball.current.y + BALL_RADIUS <= ARENA_HEIGHT





