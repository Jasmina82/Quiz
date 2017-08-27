package db_handle;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import user.UserProfile;

public class UserDAOImplementation implements UserDAO {

	public List<String> getHighscoresList() {
		List<String> highscores = new ArrayList<>();

		Connection conn = ConnectionManager.getInstance().getConnection();
		try (Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(
						"SELECT username,MAX(score) AS players FROM usersGames GROUP BY username ORDER BY score DESC LIMIT 100;");) {
			while (rs.next()) {
				highscores.add(rs.getString("username") + " - " + rs.getInt("players"));
			}

		} catch (SQLException e) {

			System.err.println(e);
		}
		return highscores;
	}

	@Override
	public void register(UserProfile userProfile) {

		Connection conn = ConnectionManager.getInstance().getConnection();
		try (Statement stmt = conn.createStatement()) {
			stmt.executeUpdate(
					"INSERT INTO users VALUES('" + userProfile.getUsername() + "'," + userProfile.getPassword() + ");");

		} catch (SQLException e) {

			System.err.println(e);
		}

	}

	@Override
	public void recordPlay(String username, int score) {

		Connection conn = ConnectionManager.getInstance().getConnection();
		try (Statement stmt = conn.createStatement()) {

			stmt.executeUpdate("INSERT INTO usersGames (usersGames.score,usersGames.username) VALUES(" + score + ",'"
					+ username + "');");

		} catch (SQLException e) {

			System.err.println(e);
		}

	}

	@Override
	public List<String> getGameHistory(String username) {

		List<String> gameHistory = new ArrayList<>();

		Connection conn = ConnectionManager.getInstance().getConnection();
		try (Statement stmt = conn.createStatement();
				ResultSet rs = stmt
						.executeQuery("SELECT score FROM usersGames WHERE username = '" + username + "';");) {
			while (rs.next()) {
				gameHistory.add("Score : " + rs.getInt("score"));

			}

		} catch (SQLException e) {

			System.err.println(e);
		}
		return gameHistory;

	}

	@Override
	public Map<String, String> getListOfUsers() {

		Map<String, String> users = new HashMap<>();

		Connection conn = ConnectionManager.getInstance().getConnection();
		try (Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT username,password FROM users");) {
			while (rs.next()) {
				users.put(rs.getString("username"), rs.getString("password"));
			}

		} catch (SQLException e) {

			System.err.println(e);
		}
		return users;
	}

}
