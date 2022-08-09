package _04_netflix;

public class Moviemainandrunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Movie movie1 = new Movie("Clue",5);
		Movie movie2 = new Movie("Friday the thirteenth part III",3);
		Movie movie3 = new Movie("Forrest Gump",5);
		Movie movie4 = new Movie("The outsiders",4);
		Movie movie5 = new Movie("Jaws",5);
		
		movie1.getTicketPrice();
		
		NetflixQueue queue = new NetflixQueue();
		queue.addMovie(movie1);
		queue.addMovie(movie2);
		queue.addMovie(movie3);
		queue.addMovie(movie4);
		queue.addMovie(movie5);
		
		queue.printMovies();
		queue.sortMoviesByRating();
		System.out.println("the best movie is"+	queue.getBestMovie());
		System.out.println("the second best movie is"+queue.getMovie(1));
		
		
		
		
		
		
		
	}

}
