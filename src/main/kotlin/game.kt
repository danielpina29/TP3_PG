data class Game(val balls : List<Ball>, val racket : Racket, val brick : List<Brick>, val state : GameState )

enum class GameState { NOT_STARTED, STARTED }

fun initializeGame() : Game {
    val newRacket : Racket = initializeRacket()
    val newBalls : List<Ball> = listOf<Ball>()
    val newBricks : List<Brick> = levelBricks

    return  Game(newBalls, newRacket, newBricks, GameState.NOT_STARTED)
}

fun addBallOnRacket(game: Game) : Game {
    val newBalls = listOf<Ball>(createBall(game.racket.location.x,game.racket.location.y - BALL_RADIUS,initialVelocity))
    return Game(newBalls,game.racket, game.brick, GameState.NOT_STARTED)
}

fun startTheGame(game:Game) : Game {
    if (game.state == GameState.NOT_STARTED) {
        val newState = GameState.STARTED
        return Game(game.balls, game.racket, game.brick, newState)
    }
    else  {
        val newBalls = game.balls.filter {
            it.current == Location(game.racket.location.x, game.racket.location.y - BALL_RADIUS)
        }.map {
            addVelocity(it)
        }
        return Game(newBalls, game.racket, game.brick, GameState.STARTED)
    }
}










fun computeNextBalls(game: Game): List<Ball> {

    val movedballs = game.balls.map {
        val movedBall = moveBall(it)

        when {
            offLimitsX(movedBall) -> invertVelocityX(movedBall)
            offLimitsY(movedBall) -> invertVelocityY(movedBall)
            
            else -> movedBall
        }

    }.filter {
        ballInsideArena(it)
    }

    return movedballs
}



fun computeNextGame(game: Game) : Game =
    Game(computeNextBalls(game), game.racket, game.brick, game.state)

