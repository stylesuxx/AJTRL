class Test{
  public static void main( String[] args ){
    TVRageLookup himym = new TVRageLookup( 2930 );
    himym.lookup();
    
    if( himym.isValidshow() ){
      System.out.println( "Name: " + himym.getShowname());
      System.out.println( "Link: " + himym.getShowlink());
      System.out.println( "Origin: " + himym.getOrigin_country());
      System.out.println( "Status: " + himym.getStatus());
      System.out.println( "Classification: " + himym.getClassification());
      System.out.println( "Network: " + himym.getNetwork());
      System.out.println( "Airtime: " + himym.getAirtime());
      System.out.println( "Airday: " + himym.getAirday());
      System.out.println( "Timezone: " + himym.getTimezone());
      System.out.println( "Runtime: " + himym.getRuntime());
      System.out.println( "Started: " + himym.getStarted());
      System.out.println( "Seasons: " + himym.getSeasons());
      for(int i=0; i < himym.getGenresArray().length; i++){
	System.out.println( "Genre: " + himym.getGenresArray()[i] );
      }
      System.out.println( "Started: " + himym.getStartdate().toString() );
      System.out.println( "Started: " + himym.getEnded().toString() );
    }
    else System.out.println("This is not a valid Show.");
  }
}