import pt.isel.*
import pt.isel.canvas.*

private const val LIGHT_RED = 16764107
private const val CORRECTED_BAR = 8



fun drawGame(arena: Canvas, game: Game) {
    arena.erase()
    game.ball.forEach { drawBall(arena, it) }
    drawRacket(arena, game.racket)
    game.bricks.forEach { drawBrick(it.position,it.Colour,arena) }
    game.lifes.forEach { drawBall(arena, it) }
}

private fun drawBall(arena: Canvas, ball: Ball) {
    arena.drawCircle(
            ball.current.x.toInt(),
            ball.current.y.toInt(),
            BALL_RADIUS,
            CYAN
    )
}

private fun drawRacket(arena: Canvas, racket: Racket) {
    arena.drawRect(
            x = (racket.location.x - RACKET_SIZE / 2).toInt(),
            y = (racket.location.y).toInt(),
            width = RACKET_S1,
            height = RACKET_HEIGHT,
            color = RED
    )
    arena.drawRect(
            x = (racket.location.x + RACKET_S1 - RACKET_SIZE / 2).toInt(),
            y = (racket.location.y).toInt(),
            width = RACKET_S2,
            height = RACKET_HEIGHT,
            color = LIGHT_RED
    )
    arena.drawRect(
            x = (racket.location.x + RACKET_S1 + RACKET_S2 - RACKET_SIZE / 2).toInt(),
            y = (racket.location.y).toInt(),
            width = RACKET_S1,
            height = RACKET_HEIGHT,
            color = WHITE
    )
    arena.drawRect(
            x = (racket.location.x + RACKET_S1 + RACKET_S2 + RACKET_S1 - RACKET_SIZE / 2).toInt(),
            y = (racket.location.y).toInt(),
            width = RACKET_S2,
            height = RACKET_HEIGHT,
            color = LIGHT_RED
    )
    arena.drawRect(
            x = (racket.location.x + RACKET_S1 + RACKET_S2 + RACKET_S1 + RACKET_S2 - RACKET_SIZE / 2).toInt(),
            y = (racket.location.y).toInt(),
            width = RACKET_S1,
            height = RACKET_HEIGHT,
            color = RED
    )
    arena.drawRect(
            x = (racket.location.x - RACKET_SIZE / 2).toInt(),
            y = (racket.location.y + RACKET_HEIGHT / 2).toInt(),
            width = RACKET_SIZE.toInt(),
            height = CORRECTED_BAR,
            color = WHITE
    )
}