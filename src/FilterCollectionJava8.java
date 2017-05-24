import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import org.junit.Before;
import org.junit.Test;


/*Predicate - func. takes in value returns true/false

Stream - seq. of data items that are produced one at
a time. Classes to support functional-style operations,
it isn't meant to replace collection, just make it easier 
to interact with them.
*/


public class FilterCollectionJava8 {

	enum Region{
		NORTH, SOUTH, EAST, WEST;
	}
	
	class BBTeam{
		
		int pointScored;
		String teamName;
		Region region;
		
		public BBTeam(int pointScored, String teamName, Region region){
			super();
			this.pointScored = pointScored;
			this.teamName = teamName;
			this.region = region;
		}
		
		public String toString(){
			return "BBTeam [pointScored= " + pointScored +
					" teamName= " + teamName + ", region= " + region + "]";
		}
		
	}
	
	List<BBTeam> teams;
	
	public void setUP(){
		
		teams = new ArrayList<>();
		
		teams.add(new BBTeam(55,"Wisconsin", Region.WEST));
		teams.add(new BBTeam(65,"Wisconsin", Region.WEST));
		teams.add(new BBTeam(67,"San Diego", Region.WEST));
		teams.add(new BBTeam(43,"Iowa State", Region.EAST));
		teams.add(new BBTeam(43,"Iowa State", Region.EAST));
		teams.add(new BBTeam(43,"Iowa State", Region.EAST));
		teams.add(new BBTeam(43,"Iowa State", Region.EAST));
		teams.add(new BBTeam(98,"Florida", Region.SOUTH));
		teams.add(null);
		teams.add(new BBTeam(98, null, Region.SOUTH));
		
	}
	
	//Create Predicate
	Predicate<BBTeam> westRegion = new Predicate<BBTeam>(){
		public boolean test(BBTeam t){
			return t.region == Region.WEST;
			
		}
	};
	
	Predicate<BBTeam> eastRegion = (BBTeam p) -> p.region == Region.EAST;
	
	public void filter_by_region(){
		teams.stream().filter(westRegion).forEach(p -> System.out.println(p) );
	}
	
	public void filter_by_score(){
		teams.stream().filter(p -> p.pointScored >= 60).forEach(p -> System.out.println(p));
	}
	
	public void filter_by_team_to_collection(){
		
		Predicate<BBTeam> nonNullPredicate = Objects::nonNull;
		Predicate<BBTeam> nameNotNull = p -> p.teamName != null;
		Predicate<BBTeam> teamPredicate = p -> p.teamName.equals("Wisconsin");
		
		Predicate<BBTeam> fullPredicate = nonNullPredicate.and(nameNotNull).and(teamPredicate);
		
		teams.stream().filter(p -> p.teamName.equals("Wisconsin")).forEach(p -> System.out.println(p));
	}
	
		
}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	

