

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MOVIE_TABLE")
public class TeluguMovie {
	
	@Id
	@Column(name="Movie_ID")
	private int id;

	@Column(name="Title")
	private String  title = null;
	
	@Column(name="Synoposis")
	private String  synopsis = null;

	@Column(name="Director")
	private String  director = null;
	
	public TeluguMovie(){
		
	}
	
	public TeluguMovie(String title, String synopsis, String director){
		this.title=title;
		this.synopsis=synopsis;
		this.director=director;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getDirector() {
		return director;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getSynopsis() {
		return synopsis;
	}
}
