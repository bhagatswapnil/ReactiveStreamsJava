package subscriber;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import model.Player;

public class PlayerSubscriber implements Subscriber<Player> {
	
	private Subscription subscription;

	@Override
	public void onSubscribe(Subscription subscription) {
		System.out.println(Thread.currentThread().getId());
		System.out.println("onSubscribe");
		this.subscription = subscription;
		this.subscription.request(1);
		System.out.println("After req");
	}

	@Override
	public void onNext(Player item) {
		System.out.println(item);
		this.subscription.request(1);
	}

	@Override
	public void onError(Throwable throwable) {
		System.out.println("onError");
		throwable.printStackTrace();
	}

	@Override
	public void onComplete() {
		// TODO Auto-generated method stub
		System.out.println("onComplete");
	}

}
