data class Game(val ball : List<Ball>, val lifes : List<Ball>, val racket : Racket, val bricks : List<Brick>, val state : GameState, val score : Int )

enum class GameState { NOT_STARTED, STARTED }

/**
 * The function initializeGame will create every single element in the Game and set it to their initial values
 */

fun initializeGame() : Game {
    val newScore = 0
    val newRacket : Racket = initializeRacket()
    val newBalls : List<Ball> = listOf(createBallOnRacket(newRacket))
    val newLifes : List<Ball> = listOf(
            createLives(208.0, 580.0),
            createLives(187.0, 580.0),
            createLives(166.0, 580.0),
            createLives(229.0, 580.0),
            createLives(250.0,580.0)
    )
    val newBricks : List<Brick> = levelBricks

    return  Game(newBalls, newLifes, newRacket, newBricks, GameState.NOT_STARTED, newScore)
}

/**
 * The function startGame will put the ball in movement and change the game state to STARTED
 * @param game Game that is going to be started
 */

fun Game.startGame(game: Game) : Game =
    Game(this.ball.map { it.addVelocity(game) }, this.lifes, this.racket, this.bricks, GameState.STARTED, game.score)

/**
 * The function addFinalPoints will determine after the game has ended if we give the bonus points for the
 * extra lives or not, and return a new Game with the necessary changes
 * @param game Game that is going to be analysed
 */

fun Game.addFinalPoints() : Game {
   return if (this.lifes.isNotEmpty())
        Game(this.ball, this.lifes, this.racket, this.bricks, this.state, this.score + 10 * this.lifes.size)
    else
        Game(this.ball, this.lifes, this.racket, this.bricks, this.state, this.score)

}

/**
 * The function ComputeNextBall will analyse the game and return a new List Of Balls, making the necessary
 * adjustments to the balls
 * @param game Game that is going to be analysed
 */

fun computeNextBall(game: Game): List<Ball> {

        val movedball = game.ball.map {
            val movedBall = moveBall(it)
            when {
                game.state == GameState.NOT_STARTED -> it.moveWithRacket(game)
                offLimitsLeftX(movedBall) && isDeflectedByWallsLeft(movedBall) -> reflectVelocityLeftX(it)
                offLimitsRightX(movedBall) && isDeflectedByWallsRight(movedBall) -> reflectVelocityRightX(it)
                offLimitsY(movedBall) && isDeflectedByWallsTop(movedBall) -> reflectVelocityY(it)

                detectBallLeftS1(it, game.racket) && isDeflectedByRacket(it, game.racket) -> reflectBallLeftS1(it)
                detectBallLeftS2(it, game.racket) && isDeflectedByRacket(it, game.racket) -> reflectBallLeftS2(it)
                detectBallRightS1(it, game.racket) && isDeflectedByRacket(it, game.racket) -> reflectBallRightS1(it)
                detectBallRightS2(it, game.racket) && isDeflectedByRacket(it, game.racket) -> reflectBallRightS2(it)
                detectBallMiddleSector(it, game.racket) && isDeflectedByRacket(it, game.racket) -> reflectBallMiddle(it)


                collidingBottomBricks(game.bricks, it) -> reflectBottomBrick(it, game)
                collidingTopBricks(game.bricks, it) -> reflectTopBrick(it)
                collidingRightBricks(game.bricks, it) -> reflectRightBrick(it)
                collidingLeftBricks(game.bricks, it) -> reflectLeftBrick(it)


                else -> movedBall
            }

        }.filter {
            ballInsideArena(it)
        }
    return movedball
    }

/**
 * The function ComputeNextLivesAndBall will analyse the game and return a new one with the amount of lives and balls
 * set in the parameters
 * @param game Game that is going to be analysed
 */

fun computeNextLivesAndBall(game: Game) : Game{
    return if(game.state == GameState.STARTED && game.ball.isEmpty())
        Game(listOf(createBallOnRacket(game.racket)),game.lifes - game.lifes.last(), game.racket, game.bricks, GameState.NOT_STARTED , game.score)
    else
        Game(game.ball, game.lifes, game.racket, game.bricks, game.state, game.score)
}

/**
 * The function finishGame will analyse the game and return true or false when the necessary conditions are meet
 * @param game Game that is going to be analysed
 */

fun finishGame(game: Game) : Boolean =
        game.state == GameState.STARTED && game.lifes.isEmpty() && game.ball.isEmpty() ||
                game.state == GameState.STARTED && game.bricks.none { it.hits != 0 }

/**
 * The function ComputeNextBricks will modify the Bricks that are hit by the ball, so the amount of lives get decreased
 * @param ball Ball that is going to be used to react to collisions
 * @param bricks List of bricks that is going to be modified when the ball hits them.
 */

fun computeNextBricks(ball :Ball, bricks :List<Brick>) =
        bricks.mapNotNull { if (detectHitTopBrick(ball, it) || detectHitBottomBrick(ball,it) || detectHitRightSideBrick(ball, it) || detectHitLeftSideBrick(ball, it) )
            it.touch()
        else
            it
        }

/**
 * The function ComputeNextScore will modify the Score based on the type of bricks that are hitted by the ball
 * @param game Game that the function recive to analyse and modify the new score
 */

fun computeNextScore(game: Game) : Int{
        
    return game.bricks.filter { collides(game.ball.first(),it) }.map { it.valueScore }.fold(game.score, {total,item ->total + item })

}
/**
 * The function ComputeNextGame will create a new Game based on the old one, and  make the necessary adjustments.
 * @param game Game that the function recive to analyse and modify to return a new one
 */

fun computeNextGame(game: Game) : Game =
    Game(computeNextBall(game), game.lifes, game.racket, computeNextBricks(game.ball.first(), game.bricks), game.state, computeNextScore(game))

