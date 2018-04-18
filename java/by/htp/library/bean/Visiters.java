package by.htp.library.bean;

public class Visiters {

	/*
	 * `ID`, `COUNTRY_CODE`, `REGION_CODE`, `REGION_NAME`, `CITY`, `ZIP_CODE`,
	 * `TIME_ZONE`, `LATITUDE`, `LANGITUDE`, `METRO_CODE`
	 */

	private int id;
	private String IP;
	private String countryCode;
	private String countyName;
	private String regionCode;
	private String regionName;
	private String city;
	private String zipCode;
	private String timeZone;
	private double latitude;
	private double langitude;
	private int metroCode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLangitude() {
		return langitude;
	}

	public void setLangitude(double langitude) {
		this.langitude = langitude;
	}

	public int getMetroCode() {
		return metroCode;
	}

	public void setMetroCode(int metroCode) {
		this.metroCode = metroCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IP == null) ? 0 : IP.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result + ((countyName == null) ? 0 : countyName.hashCode());
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(langitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + metroCode;
		result = prime * result + ((regionCode == null) ? 0 : regionCode.hashCode());
		result = prime * result + ((regionName == null) ? 0 : regionName.hashCode());
		result = prime * result + ((timeZone == null) ? 0 : timeZone.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visiters other = (Visiters) obj;
		if (IP == null) {
			if (other.IP != null)
				return false;
		} else if (!IP.equals(other.IP))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		if (countyName == null) {
			if (other.countyName != null)
				return false;
		} else if (!countyName.equals(other.countyName))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(langitude) != Double.doubleToLongBits(other.langitude))
			return false;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			return false;
		if (metroCode != other.metroCode)
			return false;
		if (regionCode == null) {
			if (other.regionCode != null)
				return false;
		} else if (!regionCode.equals(other.regionCode))
			return false;
		if (regionName == null) {
			if (other.regionName != null)
				return false;
		} else if (!regionName.equals(other.regionName))
			return false;
		if (timeZone == null) {
			if (other.timeZone != null)
				return false;
		} else if (!timeZone.equals(other.timeZone))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Visiters [id=" + id + ", IP=" + IP + ", countryCode=" + countryCode + ", countyName=" + countyName
				+ ", regionCode=" + regionCode + ", regionName=" + regionName + ", city=" + city + ", zipCode="
				+ zipCode + ", timeZone=" + timeZone + ", latitude=" + latitude + ", langitude=" + langitude
				+ ", metroCode=" + metroCode + "]";
	}

}
