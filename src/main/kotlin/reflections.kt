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
                Location(ball.current.x,(RACKET_LOCATION_Y - BALL_RADIUS - RACKET_HEIGHT).toDouble()),
                Velocity(dx = ball.velocity.dx, dy = -ball.velocity.dy)
        )

