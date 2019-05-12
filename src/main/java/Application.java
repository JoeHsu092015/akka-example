
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Application {

    public static void main(String[] args) throws Exception {
        final ActorSystem system = ActorSystem.create();
        System.out.println("Press any key to terminate");

        final ActorRef akkaBot = system.actorOf(
                Props.create(AkkaBot.class),
                "akkaBot");
        System.in.read();

        akkaBot.tell(
                new AkkaBot.Move(AkkaBot.Direction.FORWARD),
                ActorRef.noSender());
        akkaBot.tell(
                new AkkaBot.Move(AkkaBot.Direction.BACKWARDS),
                ActorRef.noSender());
        akkaBot.tell(
                new AkkaBot.Stop(),
                ActorRef.noSender());
        System.out.println("Shutting down actor system...");
        system.terminate();
    }
}
