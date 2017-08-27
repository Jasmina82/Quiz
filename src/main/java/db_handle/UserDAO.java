package db_handle;

import java.util.List;
import java.util.Map;

import user.UserProfile;

public interface UserDAO {

	public List<String> getHighscoresList();

	public void register(UserProfile userProfile);

	public void recordPlay(String username, int score);

	public List<String> getGameHistory(String username);

	public Map<String, String> getListOfUsers();

}
