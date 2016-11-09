package persistlayer;
import java.sql.*;
import persistlayer.*;
import objectlayer.*;
import java.util.*;

public class MoviePersistImpl {
	/*
	 * This is a sample of how the methods in this class will look...
	 * The database query is created here and  
	//Select * from movies m, reviews rw where m.id=rw.movie_id and m.name='" + genre+"'";
	//Select movies.name from movie
	//INSERT INTO reviews(movie_id,review) VALUES(movie_id,review)
	//DELETE FROM movies WHERE name=userMovieName;
	//DELETE FROM movies WHERE name=userMovieName;
	
	public ResultSet getRSByGenre(String genre)
	{
		DbAccessImpl da= new DbAccessImpl();
		Connection con= da.connect();
		String query="Select * from movies m, movies_genres mg where m.id=mg.movie_id and mg.genre='" + genre+"'";
		return da.retrieve(con, query);
	}
	
	public ResultSet getRSByMovieName(String movieName)
	{
		DbAccessImpl da= new DbAccessImpl();
		Connection con= da.connect();
		String query="Select * from movies m, reviews rw where m.id=rw.movie_id and m.name='" + movieName+"'";
		return da.retrieve(con, query);
	}

	public ResultSet getRSByInsertMovie(String movieName, String year, String rank)
	{
		DbAccessImpl da= new DbAccessImpl();
		Connection con= da.connect();
		String query="INSERT INTO movies(name, year, rank) VALUES('"+movieName+"',"+ year + "," +rank+")";
		da.create(con, query);	
		query="Select * from movies";
		return da.retrieve(con, query);
	}
	
	//Insert Review
	public ResultSet getRSByInsertReview(String movieName, String review)
	{
		DbAccessImpl da= new DbAccessImpl();
		Connection con= da.connect();
		String query;
		int movie_id=0;
		try {
		query="Select id from imdb2.movies where movies.name='" +movieName+"'";
		ResultSet rs= da.retrieve(con, query);
		movie_id=rs.getInt("id");
		}
		catch (SQLException e) 
		{e.printStackTrace();}
		//movie_id=300229;
		query="INSERT INTO imdb2.reviews(movie_id,review) VALUES("+ movie_id +",'"+ review +"')";
		da.create(con, query);	
		query="Select * from reviews";
		return da.retrieve(con, query);
	}
	
	//Delete reviews of a specific movie
	public ResultSet getRSByDeleteReview(String reviewDelete)
	{
		DbAccessImpl da= new DbAccessImpl();
		Connection con= da.connect();
		String query="Delete from reviews Innerjoin movies on movies.id=reviews.movie_id where movies.name='"+reviewDelete+"'";
		da.delete(con, query);	
		query="Select * from movies";
		return da.retrieve(con, query);
	}
	
	//Delete Movie and its reviews
	public ResultSet getRSByDeleteMovie(String movieDelete)
	{
		DbAccessImpl da= new DbAccessImpl();
		Connection con= da.connect();
		String query="Delete from movies,reviews where movies.id=reviews.movie_id and movies.name='"+movieDelete+"'";
		da.delete(con, query);	
		query="Select * from movies";
		return da.retrieve(con, query);
	}
	*/
	
}
