
public class City {
	
	private String name;
	private String stateId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStateId() {
		return stateId;
	}
	public void setStateId(String stateId) {
		this.stateId = stateId;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("City [name=");
		builder.append(name);
		builder.append(", stateId=");
		builder.append(stateId);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
