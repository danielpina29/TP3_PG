import pt.isel.canvas.MouseEvent

data class Ball(val start : Location, val current : Location, val velocity : Velocity)

const val BALL_RADIUS = 7

val initialVelocity = Velocity(4.0,-4.0)

fun createBallOnRacket(game: Game) :  Ball{

    val start = Location(game.racket.location.x, game.racket.location.y + RACKET_HEIGHT / 2)
    val newVelocity = initialVelocity

    return Ball(start, start, newVelocity)
}

fun manageRacketBall(mouse_input : MouseEvent,game: Game) {
    if (game.balls.any { it.current.x != game.racket.location.x + BALL_RADIUS && it.current.y != game.racket.location.y + RACKET_HEIGHT / 2 + BALL_RADIUS }){
        if(mouse_input.down){
            createBallOnRacket(game)
        }
    }
}

fun moveBall(ball:Ball) = Ball(
    ball.start,
    move(ball.current, ball.velocity),
    ball.velocity
)