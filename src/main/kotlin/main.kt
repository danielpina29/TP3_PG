import pt.isel.canvas.*

const val ARENA_WIDTH = 416
const val ARENA_HEIGHT = 600

/**
 * Implementation of the retro game "Arkanoid"
 * The game presents a bug in the ball reflection in the Bricks
 */

fun main () {
    onStart {
        val arena = Canvas(ARENA_WIDTH,ARENA_HEIGHT, BLACK)
        var game = initializeGame()

        arena.onMouseDown {
            game = game.startGame(game)
        }

        arena.onMouseMove {
            game = Game(game.ball,game.lifes, moveRacket(it.x,game), game.bricks, game.state, game.score)
        }

        arena.onTimeProgress(10) {

            game = computeNextLivesAndBall(game)

            game = computeNextGame(game)

            drawGame(arena, game)

            if (finishGame(game))
                    game = game.addFinalPoints()

        }
    }

    onFinish {

    }

}