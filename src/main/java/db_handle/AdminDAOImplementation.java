package db_handle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import admin.Question;

public class AdminDAOImplementation implements AdminDAO {

	@Override
	public void addQuestion(Question question) {

		Connection conn = ConnectionManager.getInstance().getConnection();
		try (Statement stmt = conn.createStatement()) {

			stmt.executeUpdate(
					"INSERT INTO questions (question,correctAnswer,wrongAnswer1,wrongAnswer2,wrongAnswer3)  VALUES('"
							+ question.getQuestion() + "','" + question.getCorrectAnswer() + "','"
							+ question.getWrongAnswer1() + "','" + question.getWrongAnswer2() + "','"
							+ question.getWrongAnswer3() + "');");

			System.out.println("Question added!");

		} catch (SQLException e) {

			System.err.println(e);
		}

	}

	@Override
	public void editQuestion(Question question, int row) {

		int id = getId(row);

		Connection conn = ConnectionManager.getInstance().getConnection();
		try (Statement stmt = conn.createStatement()) {

			stmt.executeUpdate("UPDATE questions SET question='" + question.getQuestion() + "',correctAnswer='"
					+ question.getCorrectAnswer() + "',wrongAnswer1='" + question.getWrongAnswer1() + "',wrongAnswer2='"
					+ question.getWrongAnswer2() + "',wrongAnswer3='" + question.getWrongAnswer3() + "' WHERE id=" + id
					+ ";");

			System.out.println("Question updated!");

		} catch (SQLException e) {

			System.err.println(e);
		}
	}

	@Override
	public void deleteUser(String username) {

		Connection conn = ConnectionManager.getInstance().getConnection();
		try (Statement stmt = conn.createStatement()) {
			stmt.executeUpdate("DELETE usersGames FROM game.usersGames WHERE username = '" + username + "';");
			stmt.executeUpdate("DELETE users From game.users WHERE username = '" + username + "';");

			System.out.println("User deleted!");

		} catch (SQLException e) {

			System.err.println(e);
		}
	}

	@Override
	public List<Question> getAllQuestions() {

		List<Question> questions = new ArrayList<>();

		Connection conn = ConnectionManager.getInstance().getConnection();
		try (Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(
						"SELECT question,correctAnswer,wrongAnswer1,wrongAnswer2,wrongAnswer3 FROM questions");) {
			while (rs.next()) {
				questions.add(new Question(rs.getString("question"), rs.getString("correctAnswer"),
						rs.getString("wrongAnswer1"), rs.getString("wrongAnswer2"), rs.getString("wrongAnswer3")));

			}

		} catch (SQLException e) {

			System.err.println(e);
		}
		return questions;

	}

	public static int getId(int row) {

		int id = 0;
		Connection conn = ConnectionManager.getInstance().getConnection();
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT id FROM questions");) {
			rs.absolute(row);
			id = rs.getInt(1);

		} catch (SQLException e) {

			System.err.println(e);
		}
		return id;
	}

}
