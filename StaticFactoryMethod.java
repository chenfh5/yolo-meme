//静态工厂方法模式
interface Sender {
	public void Send();
}

class MailSender implements Sender {
	public void Send() {
		System.out.println("this is mailsender!");
	}
}

class SmsSender implements Sender {
	public void Send() {
		System.out.println("this is sms sender!");
	}
}

class SendFactory {
	public static Sender produceMail() {
		return new MailSender();
	}

	public static Sender produceSms() {
		return new SmsSender();
	}
}

public class FactoryTest {
	public static void main(String[] args) {
		Sender sender = SendFactory.produceMail();
		Sender sender2 = SendFactory.produceSms();
		sender.Send();
		sender2.Send();
	}
}
