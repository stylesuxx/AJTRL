import java.util.ArrayList;

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
      
    ArrayList<Integer> tmpA = new ArrayList<Integer>();
    tmpA.add(22033);
    tmpA.add(30042);
    tmpA.add(8511);

    TVRageCountdown cntdwn = new TVRageCountdown( tmpA, 8, "" );
    ArrayList<TodayEpisode> tmp = cntdwn.getInfo();

    for( int i = 0; i < tmp.size(); i++ ){
      System.out.println( "ID: " + tmp.get(i).getShowid() );
      System.out.println( "Name: " + tmp.get(i).getShowname() );
      System.out.println( "Show Link: " + tmp.get(i).getShowlink() );
      System.out.println( "Episode Link: " + tmp.get(i).getEpisodelink() );
      System.out.println( "Episode Title: " + tmp.get(i).getEpisodetitle() );
      System.out.println( "Epnum: " + tmp.get(i).getEpnum() );
      System.out.println( "Relative Date: " + tmp.get(i).getRelativedate() );
      System.out.println( "Air Date: " + tmp.get(i).getAirdate() );
      
      System.out.println( "-------------------------------" );
    }

  }
}