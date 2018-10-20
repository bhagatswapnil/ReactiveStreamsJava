package main;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.SubmissionPublisher;
import java.util.stream.Stream;

import model.Player;
import subscriber.PlayerSubscriber;

public class Main {

	public static void main(String[] args) {

		/*
		 * Player player1 = new Player(101, "Topson", "Mid", "OG", "Invoker", 8550);
		 * Player player2 = new Player(202, "JerAx", "Support", "OG", "Earth Spirit",
		 * 8550); Player player3 = new Player(303, "N0tail", "Support", "OG",
		 * "Silencer", 8550); Player player4 = new Player(404, "Ceb", "Offlane", "OG",
		 * "Axe", 8550); Player player5 = new Player(505, "Ana", "Carry", "OG",
		 * "Phantom Lancer", 8550);
		 */

		List<Player> ti8winners = Arrays.asList(new Player(101, "Topson", "Mid", "OG", "Invoker", 8550),
				new Player(202, "JerAx", "Support", "OG", "Earth Spirit", 8550),
				new Player(303, "N0tail", "Support", "OG", "Silencer", 8550),
				new Player(404, "7ckngMad", "Offlane", "OG", "Axe", 8550),
				new Player(505, "Ana", "Carry", "OG", "Phantom Lancer", 8550));

		List<Player> ti7winners = Arrays.asList(new Player(111, "Miracle", "Mid", "Liquid", "Invoker", 8550),
				new Player(222, "Gh", "Support", "Liquid", "KOTL", 8550),
				new Player(333, "Kuroky", "Support", "Liquid", "Silencer", 8550),
				new Player(444, "MindControl", "Offlane", "Liquid", "Natures Prophet", 8550),
				new Player(555, "Matumbaman", "Carry", "Liquid", "Brood Mother", 8550));

		SubmissionPublisher<Player> submissionPublisher = new SubmissionPublisher<>();
		PlayerSubscriber playerSubscriber = new PlayerSubscriber();
		submissionPublisher.subscribe(playerSubscriber);

		System.out.println(Thread.currentThread().getId());
		System.out.println("Request data");
		Stream<List<Player>> stream = Stream.of(ti8winners, ti7winners);
		stream
		.flatMap(winner -> winner.stream())
		.forEach(player -> {
			submissionPublisher.submit(player);
		});

		// Thread sleep to prevent from publisher from closing before all items are consumed
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		submissionPublisher.close();
		/*System.out.println("\n\n\n\n");

		//throws java.lang.IllegalStateException as Publisher is closed
		Stream<List<Player>> stream2 = Stream.of(ti8winners, ti7winners);
		stream2
		.flatMap(winner -> winner.stream())
		.forEach(player -> submissionPublisher.submit(player));

		//added delay to prevent main thread from ending
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
	}

}
