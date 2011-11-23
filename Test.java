class Test{
  public static void main( String[] args ){
    TVRageLookup himym = new TVRageLookup( 2930 );
    himym.lookup();
    
    if( himym.isValidshow() ){
      System.out.println( "Showname: " + himym.getShowname());
      System.out.println( himym.getShowlink());
      System.out.println( himym.getOrigin_country());
      System.out.println( himym.getStatus());
      System.out.println( himym.getClassification());
      System.out.println( himym.getNetwork());
      System.out.println( himym.getAirtime());
      System.out.println( himym.getAirday());
      System.out.println( himym.getTimezone());
      System.out.println( himym.getRuntime());
      System.out.println( himym.getStarted());
      System.out.println( himym.getSeasons());
      for(int i=0; i < himym.getGenresArray().length; i++){
	System.out.println( "Genre: " + himym.getGenresArray()[i] );
      }
    }
    else System.out.println("This is not a valid Show.");
  }
}