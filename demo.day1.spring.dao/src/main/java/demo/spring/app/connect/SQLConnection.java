package demo.spring.app.connect;

import org.springframework.stereotype.Component;

@Component(value="sql")
public class SQLConnection implements Connection {

	public SQLConnection() {
		System.out.println("SQLConnection constructor");
	}

	@Override
	public void open() {
		System.out.println("Open method of SQLConnection invoked.");

	}

	@Override
	public void close() {
		System.out.println("close method of SQLConnection invoked.");

	}

}
