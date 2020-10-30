package practice;

public class Trader {
	
		private final String name;
		private final String city;
		
		public String getName() {
			return name;
		}

		public String getCity() {
			return city;
		}

		public Trader(String name, String city) {
			
			this.name = name;
			this.city = city;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("[name=");
			builder.append(name);
			builder.append(", city=");
			builder.append(city);
			
			return builder.toString();
		}

	
		
}
