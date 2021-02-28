/**
 * The following functions return true if the ball has hitted a determined spot in the Brick
 */

fun detectHitBottomBrick(ball: Ball, brick: Brick) : Boolean =
        ball.current.x in brick.position.x - BALL_RADIUS .. brick.position.x+BRICK_WIDTH + BALL_RADIUS &&
                ball.current.y == brick.position.y + BALL_RADIUS + BRICK_HEIGHT

fun detectHitTopBrick(ball: Ball, brick: Brick) : Boolean =
        ball.current.x in brick.position.x - BALL_RADIUS .. brick.position.x+BRICK_WIDTH+BALL_RADIUS &&
                ball.current.y == brick.position.y - BALL_RADIUS

fun detectHitLeftSideBrick(ball: Ball, brick: Brick) : Boolean =
        ball.current.x == brick.position.x - BALL_RADIUS &&
                ball.current.y in brick.position.y .. brick.position.y + BRICK_HEIGHT

fun detectHitRightSideBrick(ball: Ball, brick: Brick) : Boolean =
        ball.current.x == brick.position.x + BALL_RADIUS + BRICK_WIDTH &&
                ball.current.y in brick.position.y .. brick.position.y + BRICK_HEIGHT

