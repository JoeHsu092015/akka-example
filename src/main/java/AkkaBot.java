import java.util.Optional;

import akka.actor.AbstractActor;
public class AkkaBot extends AbstractActor {
    public Receive createReceive() {
        //return receiveBuilder().build();
        return receiveBuilder()
                .match(Move.class, this::onMove)
                .match(Stop.class, this::onStop)
                .build();
    }

    public enum Direction { FORWARD, BACKWARDS, RIGHT, LEFT }
    public static class Move {
        public final Direction direction;
        public Move(Direction direction) {
            this.direction = direction;
        }
    }
    public static class Stop {}
    public static class GetRobotState {}
    public static class RobotState {
        public final Direction direction;
        public final boolean moving;
        public RobotState(Direction direction, boolean moving) {
            this.direction = direction;
            this.moving = moving;
        }
    }

    private Optional<Direction> direction = Optional.empty();
    private boolean moving = false;

    private void onMove(Move move) {
        moving = true;
        direction = Optional.of(move.direction);
        System.out.println("I am now moving " + direction.get());
    }
    private void onStop(Stop stop) {
        moving = false;
        System.out.println("I stopped moving");
    }
}

