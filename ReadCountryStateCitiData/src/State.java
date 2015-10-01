
public class State {
	
	private String stateId;
	private String stateName;
	private String countryId;
	public String getStateId() {
		return stateId;
	}
	public void setStateId(String stateId) {
		this.stateId = stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("State [stateId=");
		builder.append(stateId);
		builder.append(", stateName=");
		builder.append(stateName);
		builder.append(", countryId=");
		builder.append(countryId);
		builder.append("]");
		return builder.toString();
	}
	
	

}
