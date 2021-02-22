import pt.isel.canvas.*

const val ARENA_WIDTH = 416
const val ARENA_HEIGHT = 600

fun main () {
    onStart {
        val arena = Canvas(ARENA_WIDTH,ARENA_HEIGHT, BLACK)
        var game = initializeGame()



        arena.onMouseDown {
            game = Game(createBall(game),game.racket, game.brick, game.state)
        }

        arena.onMouseMove {
            game = Game(game.balls,moveRacket(it.x,game), game.brick, game.state)

        }

        arena.onTimeProgress(10) {
            game = computeNextGame(game)
            drawGame(arena, game)




        }
    }

    onFinish {

    }

}