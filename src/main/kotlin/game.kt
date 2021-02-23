data class Game(val ball : List<Ball>, val lifes : List<Ball>, val racket : Racket, val bricks : List<Brick>, val state : GameState )

enum class GameState { NOT_STARTED, STARTED }

fun initializeGame() : Game {
    val newRacket : Racket = initializeRacket()
    val newBalls : List<Ball> = listOf(createBallOnRacket(newRacket))
    val newLifes : List<Ball> = listOf(
            createLifes(208.0, 580.0),
            createLifes(187.0, 580.0),
            createLifes(166.0, 580.0),
            createLifes(229.0, 580.0),
            createLifes(250.0,580.0)
    )
    val newBricks : List<Brick> = levelBricks

    return  Game(newBalls, newLifes, newRacket, newBricks, GameState.NOT_STARTED)
}

fun Game.startGame(game: Game) : Game =
    Game(this.ball.map { it.addVelocity(game) }, this.lifes, this.racket, this.bricks, GameState.STARTED)

fun computeNextBall(game: Game): List<Ball> {

        val movedball = game.ball.map {
            val movedBall = moveBall(it)
            when {
                game.state == GameState.NOT_STARTED -> it.moveWithRacket(game)
                offLimitsLeftX(movedBall) && isDeflectedByWallsLeft(movedBall) -> invertVelocityLeftX(it)
                offLimitsRightX(movedBall) && isDeflectedByWallsRight(movedBall) -> invertVelocityRightX(it)
                offLimitsY(movedBall) && isDeflectedByWallsTop(movedBall) -> invertVelocityY(it)
                detectBallLeftS1(it, game.racket) && isDeflectedByRacket(it, game.racket) -> reflectBallLeftS1(it)
                detectBallLeftS2(it, game.racket) && isDeflectedByRacket(it, game.racket) -> reflectBallLeftS2(it)
                detectBallRightS1(it, game.racket) && isDeflectedByRacket(it, game.racket) -> reflectBallRightS1(it)
                detectBallRightS2(it, game.racket) && isDeflectedByRacket(it, game.racket) -> reflectBallRightS2(it)
                detectBallMiddleSector(it, game.racket) && isDeflectedByRacket(it, game.racket) -> reflectBallMiddle(it)


                else -> movedBall
            }

        }.filter {
            ballInsideArena(it)
        }
    return movedball
    }


fun computeNextLifesAndBall(game: Game) : Game{
    return if(game.state == GameState.STARTED && game.ball.isEmpty())
        Game(listOf(createBallOnRacket(game.racket)),game.lifes - game.lifes.last(), game.racket, game.bricks, GameState.NOT_STARTED )
    else
        Game(game.ball, game.lifes, game.racket, game.bricks, game.state)
}

fun finishGame(game: Game) : Boolean =
        game.state == GameState.STARTED && game.lifes.isEmpty() && game.ball.isEmpty()


fun computeNextBricks(ball :Ball, bricks :List<Brick>) =
        bricks.mapNotNull { if (collides(ball,it)) it.touch() else it }

fun computeNextGame(game: Game) : Game =
    Game(computeNextBall(game), game.lifes, game.racket, computeNextBricks(game.ball.first(), game.bricks), game.state)

