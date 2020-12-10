import java.util.*;
/* Bad Smells: Long Method, Duplicate code, (Bad and inconsistent exception messages?)

* To solve the long method smell, I extracted the checking operation into 3 different methods

* To solve Duplicate code, I enumerated through my properties and extracted the key and value in the loop

* I am not sure if bad and inconsistent messages is a bad smell, but i am sure it's not a good one :),
  The exception messages were unclear and inconsistent  ex: if interval is null, we printed "monitor interval",
  but if duration is null we simply printed "duration".

* Note: instead of switch statement, we can also create a more polymorphic solution using classes and interfaces
   But I left that for the next exercise(expressions) since I didn't thing the added complexity is worth it in this case

  */

public class Configuration {
	public int interval,duration,departure;

	public void load(Properties props) throws ConfigurationException {
		//enumerate through all properties and check their validity
		Enumeration<String> enums = (Enumeration<String>) props.propertyNames();
		while (enums.hasMoreElements()) {
			String key = enums.nextElement();
			int value = Integer.parseInt(props.getProperty(key));
			switch(key)
			{
				case "interval":
					checkInterval(key,value);
					interval = value;
					break;
				case "duration":
					checkDuration(key,value);
					duration = value;
					break;
				case "departure":
					checkDeparture(key,value);
					departure = value;
					break;
				default:
					throw new ConfigurationException("Please make sure you only have interval, duration and departure values");
			}
		}

	}

	private void checkInterval(String intervalStr, int interval) throws ConfigurationException {
		if (intervalStr == null) {
			throw new ConfigurationException("Interval was not given");
		}else if (interval <= 0) {
			throw new ConfigurationException("Please make sure that the interval is greater than zero");
		}
	}

	private void checkDuration(String durationStr, int duration) throws ConfigurationException {
		if (durationStr == null) {
			throw new ConfigurationException("Duration was not given");
		}
		if (duration <= 0) {
			throw new ConfigurationException("Please make sure that the duration is greater than zero");
		}
		if ((duration % this.interval) != 0) {
			throw new ConfigurationException("duration is not divisible by interval");
		}
	}

	private void checkDeparture(String departureStr, int departure) throws ConfigurationException {
		if (departureStr == null) {
			throw new ConfigurationException("Departure was not given");
		}
		if (departure <= 0) {
			throw new ConfigurationException("Please make sure that the departure is greater than zero\"");
		}
		if ((departure % interval) != 0) {
			throw new ConfigurationException("departure is not divisible by interval");
		}
	}

}
