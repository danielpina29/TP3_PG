/**
 * The following functions will determine if the ball has reach a certain spot in the arena,
 * and return a boolean value based on its parameters
 */

fun isDeflectedByRacket(ball: Ball, racket: Racket) =
        ball.current.y - BALL_RADIUS >= racket.location.y - RACKET_HEIGHT && ball.velocity.dy >= 0

fun isDeflectedByWallsLeft(ball: Ball) : Boolean {
       return ball.current.x - BALL_RADIUS <= 0
}

fun isDeflectedByWallsTop(ball: Ball) : Boolean {
        return ball.current.y - BALL_RADIUS <= 0
}

fun isDeflectedByWallsRight(ball: Ball) : Boolean {
        return ball.current.x + BALL_RADIUS >= ARENA_WIDTH
}

/**
 * The following functions will create a new Ball with the specific parameters that are
 * needed to cause a reflection depending where the ball hits.
 */

fun reflectBallLeftS1(ball: Ball) : Ball =
        Ball(
                ball.start,
                Location(ball.current.x,(RACKET_LOCATION_Y - BALL_RADIUS - RACKET_HEIGHT).toDouble()),
                Velocity(dx = ball.velocity.dx - 3, dy = -ball.velocity.dy)
        )

fun reflectBallRightS1(ball: Ball) : Ball =
        Ball(
                ball.start,
                Location(ball.current.x,(RACKET_LOCATION_Y - BALL_RADIUS - RACKET_HEIGHT).toDouble()),
                Velocity(dx = ball.velocity.dx + 3, dy = -ball.velocity.dy)
        )

fun reflectBallLeftS2(ball: Ball) : Ball =
        Ball(
                ball.start,
                Location(ball.current.x,(RACKET_LOCATION_Y - BALL_RADIUS - RACKET_HEIGHT).toDouble()),
                Velocity(dx = ball.velocity.dx - 1, dy = -ball.velocity.dy)
        )

fun reflectBallRightS2(ball: Ball) : Ball =
        Ball(
                ball.start,
                Location(ball.current.x,(RACKET_LOCATION_Y - BALL_RADIUS - RACKET_HEIGHT).toDouble()),
                Velocity(dx = ball.velocity.dx + 1, dy = -ball.velocity.dy)
        )

fun reflectBallMiddle(ball: Ball) : Ball =
        Ball(
                ball.start,
                Location(ball.current.x,(RACKET_LOCATION_Y - BALL_RADIUS - RACKET_HEIGHT).toDouble()),
                Velocity(dx = ball.velocity.dx, dy = -ball.velocity.dy)
        )

fun reflectTopBrick(ball: Ball) : Ball =
        Ball(
                ball.start,
                ball.current,
                Velocity(dx = ball.velocity.dx, dy = -ball.velocity.dy)
        )

fun reflectBottomBrick(ball: Ball, game : Game) : Ball =
        Ball(
                Location(ball.current.x, game.bricks.first { detectHitBottomBrick(ball, it) }.position.y + BRICK_HEIGHT + BALL_RADIUS),
                Location(ball.current.x, game.bricks.first { detectHitBottomBrick(ball, it) }.position.y + BRICK_HEIGHT + BALL_RADIUS),
                Velocity(dx = ball.velocity.dx, dy = -ball.velocity.dy)
        )

fun reflectLeftBrick(ball: Ball) : Ball =
        Ball(
                Location(ball.current.x, ball.current.y + BALL_RADIUS),
                Location(ball.current.x, ball.current.y + BALL_RADIUS),
                Velocity(dx = -ball.velocity.dx, dy = ball.velocity.dy)
        )

fun reflectRightBrick(ball: Ball) : Ball =
        Ball(
                Location(ball.current.x, ball.current.y + BALL_RADIUS),
                Location(ball.current.x, ball.current.y + BALL_RADIUS),
                Velocity(dx = -ball.velocity.dx, dy = ball.velocity.dy)
        )

fun reflectVelocityLeftX(ball: Ball): Ball {
        return Ball(
                ball.start,
                Location(x = BALL_RADIUS.toDouble(), y= ball.current.y),
                Velocity(-ball.velocity.dx, ball.velocity.dy)
        )
}

fun reflectVelocityRightX(ball: Ball): Ball {
        return Ball(
                ball.start,
                Location(x = ARENA_WIDTH.toDouble()- BALL_RADIUS, y= ball.current.y),
                Velocity(-ball.velocity.dx, ball.velocity.dy)
        )
}

fun reflectVelocityY(ball: Ball): Ball {
        return Ball(ball.start, Location(x=ball.current.x, y= BALL_RADIUS.toDouble()), Velocity(ball.velocity.dx, -ball.velocity.dy))
}

