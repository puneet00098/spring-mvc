package demo.spring.app.connect;

import org.springframework.stereotype.Component;

@Component(value="ora")
public class OracleConnection implements Connection {

	public OracleConnection() {
		System.out.println("OracleConnection constructor");
	}

	@Override
	public void open() {
		System.out.println("Open method of OracleConnection invoked.");

	}

	@Override
	public void close() {
		System.out.println("close method of OracleConnection invoked.");

	}

}
