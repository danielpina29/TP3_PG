/**
 * The following function will create a Ball on the top of the Racket
 * @param racket Racket where the ball will be created
 */

fun createBallOnRacket(racket: Racket) : Ball{
    val startX = racket.location.x
    val startY = 590.0

    return createBall(startX, startY)

}

/**
 * The following function will move the ball has the racket moves.
 */

fun Ball.moveWithRacket(game: Game): Ball =
        Ball(
                start = Location(game.racket.location.x,game.racket.location.y - BALL_RADIUS),
                current = Location(game.racket.location.x,game.racket.location.y - BALL_RADIUS),
                velocity = Velocity(.0,.0)
        )

/**
 * This following functions will determine where the Ball hits the Brick,
 * and return true when the ball has hit the determined part of the brick
 */

fun collidingBottomBricks(bricks: List<Brick>, ball: Ball): Boolean {
    return bricks.any { detectHitBottomBrick(ball, it)}

}


fun collidingTopBricks(bricks: List<Brick>, ball: Ball): Boolean {
    return bricks.any { detectHitTopBrick(ball, it)}

}

fun collidingRightBricks(bricks: List<Brick>, ball: Ball): Boolean {
    return bricks.any { detectHitRightSideBrick(ball, it)}

}

fun collidingLeftBricks(bricks: List<Brick>, ball: Ball): Boolean {
    return bricks.any { detectHitLeftSideBrick(ball, it) }

}

/**
 * This function will add speed to the Ball if the Game has not been started
 */

fun Ball.addVelocity(game: Game) : Ball {
    return if (game.state == GameState.NOT_STARTED)
        Ball(this.start, this.current, initialVelocity)
    else
        Ball(this.start, this.current, this.velocity)
}

/**
 * This function will return true if the Ball is inside of a Brick
 * @param ball Ball that is going to be analysed
 * @param brick Brick that is going to be analysed
 */

fun collides(ball :Ball, brick: Brick) =
        ball.current.x in brick.position.x-BALL_RADIUS .. brick.position.x+BRICK_WIDTH+BALL_RADIUS &&
                ball.current.y in brick.position.y-BALL_RADIUS .. brick.position.y+BRICK_HEIGHT+BALL_RADIUS

/**
 * This function will reduce the hits of the brick if has more than one, remove the brick if has one hit
 * or create the same exact brick if it has zero hits
 */

fun Brick.touch() = when( hits ) {
    0 -> Brick(this.position, 0, this.colour, this.valueScore)
    1 -> null
    else -> Brick(this.position, this.hits - 1, this.colour, this.valueScore)
    }




