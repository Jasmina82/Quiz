package db_handle;

import java.util.List;

import admin.Question;

public interface AdminDAO {

	public void addQuestion(Question question);

	public void editQuestion(Question question,int row);

	public void deleteUser(String username);
	
	List<Question> getAllQuestions();
}
