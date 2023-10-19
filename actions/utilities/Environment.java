package utilities;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({ "classpath:${evn}.properties" })
public interface Environment extends Config {
	String url();

	@Key("db.url")
	String getDBUrl();

	@Key("db.username")
	String getUserName();

	@Key("db.password")
	String getPassword();
}
