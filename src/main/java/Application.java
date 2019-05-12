
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Application {

    public static void main(String[] args) throws Exception {
        final ActorSystem system = ActorSystem.create();
        System.out.println("Press any key to terminate");
        System.in.read();
        System.out.println("Shutting down actor system...");
        system.terminate();
    }
}
