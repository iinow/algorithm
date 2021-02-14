package algorithm.hyperconnect;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Ex3 {
	public static Boolean canViewAll(Collection<Movie> movies) {
		List<Movie> list = movies.stream().collect(Collectors.toList());
		for(int i = 0; i < list.size() - 1; i++) {
			for(int j = i + 1; j < list.size(); j++) {
				boolean contain = contain(list.get(i), list.get(j));
				if(contain) {
					return false;
				}
			}	
		}
		return true;
    }

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie(sdf.parse("2015-01-01 20:00"), sdf.parse("2015-01-01 21:30")));
        movies.add(new Movie(sdf.parse("2015-01-01 23:10"), sdf.parse("2015-01-01 23:30")));
        movies.add(new Movie(sdf.parse("2015-01-01 21:20"), sdf.parse("2015-01-01 23:00")));

//        System.out.println(movies.get(0).getStart().getTime());
        System.out.println(Ex3.canViewAll(movies));
    }
    
    public static boolean contain(Movie m1, Movie m2) {
    	if(m1.getStart().getTime() < m2.getStart().getTime() && m2.getStart().getTime() < m1.getEnd().getTime()) {
    		return true;
    	}
    	
    	if(m1.getStart().getTime() < m2.getEnd().getTime() && m2.getEnd().getTime() < m1.getEnd().getTime()) {
    		return true;
    	}
    	return false;
    }
}

class Movie {
    private Date start, end;
    
    public Movie(Date start, Date end) {
        this.start = start;
        this.end = end;
    }
    
    public Date getStart() {
        return this.start;
    }
    
    public Date getEnd() {
        return this.end;
    } 
}