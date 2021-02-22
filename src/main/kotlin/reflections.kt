fun isDeflectedByRacket(ball: Ball, racket: Racket) =
        ball.current.y - BALL_RADIUS >= racket.location.y - RACKET_HEIGHT && ball.velocity.dy >= 0

fun collisionBallsBricks(balls: List<Ball>, bricks: List<Brick>){
        bricks.mapNotNull { if (ballCollidesBrick(balls,it)) it.touch() else it }
}

fun ballCollidesBrick(ball :Ball, brick: Brick) =
        ball.current.x in brick.position.x -BALL_RADIUS .. brick.position.x+BRICK_WIDTH+BALL_RADIUS &&
                ball.current.y in brick.position.y-BALL_RADIUS .. brick.position.y+BRICK_HEIGHT+BALL_RADIUS








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