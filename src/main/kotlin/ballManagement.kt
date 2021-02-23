import pt.isel.canvas.MouseEvent

fun createBallOnRacket(racket: Racket) : Ball{
    val startX = racket.location.x
    val startY = 590.0

    return createBall(startX, startY)

}

fun Ball.moveWithRacket(game: Game): Ball =
        Ball(
                start = Location(game.racket.location.x,game.racket.location.y - BALL_RADIUS),
                current = Location(game.racket.location.x,game.racket.location.y - BALL_RADIUS),
                velocity = Velocity(.0,.0)
        )



fun Ball.addVelocity(game: Game) : Ball {
    return if (game.state == GameState.NOT_STARTED)
        Ball(this.start, this.current, initialVelocity)
    else
        Ball(this.start, this.current, this.velocity)
}
fun collides(ball :Ball, brick: Brick) =
        ball.current.x in brick.position.x-BALL_RADIUS .. brick.position.x+BRICK_WIDTH+BALL_RADIUS &&
                ball.current.y in brick.position.y-BALL_RADIUS .. brick.position.y+BRICK_HEIGHT+BALL_RADIUS

fun Brick.touch() = when( maxHits ) {
    0 -> this
    1 -> null
    else -> copy( maxHits = maxHits - 1)
    }




