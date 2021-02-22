data class Game(val balls : List<Ball>, val racket : Racket, val brick : List<Brick>, val state : GameState )

enum class GameState { NOT_STARTED, STARTED }

fun initializeGame() : Game {
    val newRacket : Racket = initializeRacket()
    val newBalls : List<Ball> = listOf<Ball>()
    val newBricks : List<Brick> = levelBricks

    return  Game(newBalls, newRacket, newBricks, GameState.NOT_STARTED)
}

fun createBall(game: Game) : List<Ball>{
    val newList = game.balls + Ball(Location(500.0,500.0),Location(500.0,500.0), initialVelocity )
    return newList
}

fun computeNextBalls(game: Game): List<Ball> {

    val movedballs = game.balls.map {
        val movedBall = moveBall(it)
        when {
            offLimitsX(movedBall) -> invertVelocityX(movedBall)
            offLimitsY(movedBall) -> invertVelocityY(movedBall)
            detectBallLeftS1(it, game.racket) && isDeflectedByRacket(it,game.racket) -> reflectBallLeftS1(it)
            detectBallLeftS2(it, game.racket) && isDeflectedByRacket(it,game.racket)  -> reflectBallLeftS2(it)
            detectBallRightS1(it, game.racket) && isDeflectedByRacket(it,game.racket)  ->  reflectBallRightS1(it)
            detectBallRightS2(it, game.racket) && isDeflectedByRacket(it,game.racket)  -> reflectBallRightS2(it)
            detectBallMiddleSector(it, game.racket) && isDeflectedByRacket(it,game.racket)  -> reflectBallMiddle(it)

            else -> movedBall
        }
    }.filter {
        ballInsideArena(it)
    }
    return movedballs
}

fun computeNextBricks(game: Game){
    val selectedBalls = game.balls.filter {

    }
    val newBricks = game.balls.mapNotNull {
        game.brick.mapNotNull {

        }
    }
}


fun computeNextGame(game: Game) : Game =
    Game(computeNextBalls(game), game.racket, computeNextBricks(game), game.state)

