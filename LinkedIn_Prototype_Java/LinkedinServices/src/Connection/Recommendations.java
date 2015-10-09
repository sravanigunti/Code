package Connection;

public class Recommendations {

	private int id;
	private int from_user_id;
	private int to_user_id;
	private String recommendation;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFrom_user_id() {
		return from_user_id;
	}
	public void setFrom_user_id(int from_user_id) {
		this.from_user_id = from_user_id;
	}
	public int getTo_user_id() {
		return to_user_id;
	}
	public void setTo_user_id(int to_user_id) {
		this.to_user_id = to_user_id;
	}
	public String getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}
	
	
	
}
