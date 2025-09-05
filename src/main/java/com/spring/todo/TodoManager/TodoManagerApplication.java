package com.spring.todo.TodoManager;

import com.spring.todo.TodoManager.DataAccessObject.TodoDao;
import com.spring.todo.TodoManager.models.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public  class TodoManagerApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(TodoManagerApplication.class);
	@Autowired
	private TodoDao todoDao;
	public static void main(String[] args) {
		SpringApplication.run(TodoManagerApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("Application Started: ");
//		JdbcTemplate template = todoDao.getTemplate();
//		logger.info("Template Object : {}", template);
//		logger.info(" {} " , template.getDataSource().getConnection());
//================================== = Insert values table ==============================================
//		Todo todo = new Todo();
//		todo.setId(9725);
//		todo.setTitle(" Java placement Course");
//		todo.setContent("Wow its working ");
//		todo.setStatus("Fee Pending");
//		todo.setAddedDate(new Date());
//		todo.setToDoDate(new Date());
//
//		todoDao.saveTodo(todo);
		//================================ insert multiple value in table ===================
//		List<Todo>todos = new ArrayList<>();
//		Todo todo1 = new Todo();
//		todo1.setId(9726);
//		todo1.setTitle("Learn Java Core");
//		todo1.setContent("Practice OOPs concepts");
//		todo1.setStatus("Pending");
//		todo1.setAddedDate(new Date());
//		todo1.setToDoDate(new Date());
//		todos.add(todo1);
//
//		Todo todo2 = new Todo();
//		todo2.setId(9727);
//		todo2.setTitle("Spring boot Project");
//		todo2.setContent("Build TodoMangar");
//		todo2.setStatus("Pending");
//		todo2.setAddedDate(new Date());
//		todo2.setToDoDate(new Date());

//		// ---------------------- fast way used list -------------
//		List<Todo> todos = List.of(
//				new Todo(9731, "Learn Java", "Complete OOPs and Collections framework", "In Progress", new Date(), new Date()),
//				new Todo(9732, "Spring Boot Basics", "Understand Dependency Injection and Annotations", "Pending", new Date(), new Date()),
//				new Todo(9733, "Database Practice", "Practice MySQL Joins, Subqueries, Indexing", "Pending", new Date(), new Date()),
//				new Todo(9734, "Build Todo App", "Develop CRUD operations with Spring JDBC", "In Progress", new Date(), new Date()),
//				new Todo(9735, "Interview Prep", "Revise DSA, System Design, and SQL", "Planned", new Date(), new Date())
//		);
//		for (Todo todo:todos){
//			todoDao.saveTodo(todo);
//		}
//

// ================== get the value by using id ==============================
//        Todo todo =todoDao.getTodo(9731);
//		logger.info("TODO: {}" ,todo);

		// =================== to get all todos =====================
//		 List<Todo> allTodos= todoDao.getAllTodos();
//		 logger.info("All todos: {}", allTodos);
		 //====================== Here we update the query ==========================
//		Todo todo =todoDao.getTodo(9725);
//		logger.info("TODO: {}" ,todo);
//		todo.setTitle("Learn Spring Boot");
//		todo.setContent("In this playlist we learn spring mvc");
//		todo.setStatus("Fees NOT FOUND");
//		todo.setAddedDate(new Date());
//		todo.setToDoDate(new Date());
//		todoDao.updateTodo(9713,todo);
		// todoDao.updateTodo(1913,"Learn Spring Boot","In this playlist we learn spring mvc ","Fees NOT FOUND",new Date(),new Date(),9713);

		//=========================== here we delete query ===============================
//		todoDao.deleteTodo(9725);
//		// = ================ delete multiple ====================
//		todoDao.deleteMultiple(new int[]{ 9714,9715}); // inside the pass ids
	}
}
