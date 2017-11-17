package com.example;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.util.Timeout;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;
/**
 * Created by M1039838 on 11/15/2017.
 */
public class Application {

    private static Timeout t = new Timeout(Duration.create(5, TimeUnit.SECONDS));

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("ClusterClient");

        ActorSelection selection = system.actorSelection("akka.tcp://ClusterSystem@127.0.0.1:2551/user/billingService");
        selection.tell(new MyMessage("Hello"), ActorRef.noSender());
        selection.tell(new MyMessage("Hello"), ActorRef.noSender());
        selection.tell(new MyMessage("Hello"), ActorRef.noSender());
        selection.tell(new MyMessage("Hello"), ActorRef.noSender());
        selection.tell(new MyMessage("Hello"), ActorRef.noSender());
    }
}
