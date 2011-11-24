package ajtrl;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.InputSource;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

/** Retrieves Infos about upcoming shows which are in TVRages' Countdown XML
  * <ul>
  * <li>A TVRage API Key is required in order for this to work</li>
  * </ul>
  * 
  * @author stylesuxx@gmail.com
  */
public class TVRageCountdown{
  private int days = -1;
  private String apikey = null;
  private ArrayList<TodayEpisode> episodes = new ArrayList<TodayEpisode>();
  private ArrayList<TodayEpisode> tmp = new ArrayList<TodayEpisode>();

  private ArrayList<Integer> shows;

  private boolean Xshowname = false; 
  private boolean Xshowid = false;
  private boolean Xshowlink = false;
  private boolean Xepisodelink = false;
  private boolean Xepisodetitle = false;
  private boolean Xepnum = false;
  private boolean Xairdate = false;
  private boolean Xrelativedate = false;
  private boolean Xstartitem = false;
  private boolean Xenditem = false;

  private boolean items = false;

  /** Returns provided shows if they are airing today
    * @param shows ID's to check if show airs today
    * @param apikey A TVRage API Key
    */
  public TVRageCountdown( ArrayList<Integer> shows, String apikey ){
    days = 0;
    this.apikey = apikey;
    this.shows = shows;
    items = true;
  }

  /** Returns all shows in the countdown file
    * @param apikey A TVRage API Key
    */
  public TVRageCountdown( String apikey ){
    this.apikey = apikey;
  }

  /** Returns provided shows if they are airing in the next days
    * @param shows ID's to check if show airs today
    * @param days Days to check in advance
    * @param apikey A TVRage API Key
    */
  public TVRageCountdown( ArrayList<Integer> shows, int days, String apikey ){
    this.days = days;
    this.apikey = apikey;
    this.shows = shows;
    items = true;
  }

  /** Returns all shows if they are airing in the next days
    * @param days Days to check in advance
    * @param apikey A TVRage API Key
    */
  public TVRageCountdown( int days, String apikey ){
    this.days = days;
    this.apikey = apikey;
  }

  public ArrayList<TodayEpisode> getInfo(){
    SAXParserFactory factory = SAXParserFactory.newInstance();
    try{
      SAXParser saxParser = factory.newSAXParser();
      DefaultHandler handler = new DefaultHandler() {
	// Checks wchich start Elements are set for further processing
	public void startElement(String uri, String localName,String qName, Attributes attributes){
	  if (qName.equalsIgnoreCase("show")) Xstartitem = true; 
	  if (qName.equalsIgnoreCase("showname")) Xshowname = true; 
	  if (qName.equalsIgnoreCase("showid")) Xshowid = true;
	  if (qName.equalsIgnoreCase("showlink")) Xshowlink = true;
	  if (qName.equalsIgnoreCase("link")) Xepisodelink = true;
	  if (qName.equalsIgnoreCase("title")) Xepisodetitle = true;
	  if (qName.equalsIgnoreCase("epnum")) Xepnum = true;
	  if (qName.equalsIgnoreCase("airdate")) Xairdate = true;
	  if (qName.equalsIgnoreCase("relativedate")) Xrelativedate = true;
	}

	public void characters(char ch[], int start, int length){
	    if( Xstartitem ){ 
	      episodes.add( new TodayEpisode() );
	      Xstartitem = false;
	    }
	    if( Xshowname ){
	      episodes.get( episodes.size() - 1 ).setShowname( new String( ch, start, length ) );
	      Xshowname = false;
	    } 
	    if( Xshowlink ){
	      episodes.get( episodes.size() - 1 ).setShowlink( new String( ch, start, length ) );
	      Xshowlink = false;
	    } 
	    if( Xepisodelink ){
	      episodes.get( episodes.size() - 1 ).setEpisodelink( new String( ch, start, length ) );
	      Xepisodelink = false;
	    } 
	    if( Xepisodetitle ){
	      episodes.get( episodes.size() - 1 ).setEpisodetitle( new String( ch, start, length ) );
	      Xepisodetitle = false;
	    } 
	    if( Xepnum ){
	      episodes.get( episodes.size() - 1 ).setEpnum( new String( ch, start, length ) );
	      Xepnum = false;
	    }
	    if( Xrelativedate ){
	      episodes.get( episodes.size() - 1 ).setRelativedate( new String( ch, start, length ) );
	      Xrelativedate = false;
	    }
	    if( Xairdate ){
	      episodes.get( episodes.size() - 1 ).setAirdate( null ); //new String( ch, start, length ) );
	      Xairdate = false;
	    }
	    if( Xshowid ){
	      episodes.get( episodes.size() - 1 ).setShowid( Integer.parseInt( new String( ch, start, length ) ) );
	      Xshowid = false;
	    }
	}
      };
      saxParser.parse( new InputSource( new URL( "http://services.tvrage.com/myfeeds/countdown.php?key=" + apikey ).openStream()), handler);
    }catch( Exception e ){ System.out.println("TV Rage Offline,.."); }

    for( int i = 0; i < episodes.size(); i++ ){
      if( items ){
	int tmpShowid = episodes.get(i).getShowid();
	if( shows.contains( tmpShowid ) && days == 0 && episodes.get(i).getRelativedate().equals( "Tonight" ) ){ tmp.add( episodes.get(i) ); }
	if( shows.contains( tmpShowid ) && days == 1 && ( episodes.get(i).getRelativedate().equals( "Tonight" ) | episodes.get(i).getRelativedate().equals( "1 day" ) ) ){ tmp.add( episodes.get(i) ); }
	if( shows.contains( tmpShowid ) && days == 2 && ( episodes.get(i).getRelativedate().equals( "Tonight" ) | episodes.get(i).getRelativedate().equals( "1 day" ) | episodes.get(i).getRelativedate().equals( "2 days" ) ) ){ tmp.add( episodes.get(i) ); }  
	if( shows.contains( tmpShowid ) && days == 3 && ( episodes.get(i).getRelativedate().equals( "Tonight" ) | episodes.get(i).getRelativedate().equals( "1 day" ) | episodes.get(i).getRelativedate().equals( "2 days" ) | episodes.get(i).getRelativedate().equals( "3 days" ) ) ){ tmp.add( episodes.get(i) ); }  
	if( shows.contains( tmpShowid ) && days == 4 && ( episodes.get(i).getRelativedate().equals( "Tonight" ) | episodes.get(i).getRelativedate().equals( "1 day" ) | episodes.get(i).getRelativedate().equals( "2 days" ) | episodes.get(i).getRelativedate().equals( "3 days" ) | episodes.get(i).getRelativedate().equals( "4 days" ) ) ){ tmp.add( episodes.get(i) ); }      
	if( shows.contains( tmpShowid ) && days == 5 && ( episodes.get(i).getRelativedate().equals( "Tonight" ) | episodes.get(i).getRelativedate().equals( "1 day" ) | episodes.get(i).getRelativedate().equals( "2 days" ) | episodes.get(i).getRelativedate().equals( "3 days" ) | episodes.get(i).getRelativedate().equals( "4 days" ) | episodes.get(i).getRelativedate().equals( "5 days" ) ) ){ tmp.add( episodes.get(i) ); }      
	if( shows.contains( tmpShowid ) && days == 6 && ( episodes.get(i).getRelativedate().equals( "Tonight" ) | episodes.get(i).getRelativedate().equals( "1 day" ) | episodes.get(i).getRelativedate().equals( "2 days" ) | episodes.get(i).getRelativedate().equals( "3 days" ) | episodes.get(i).getRelativedate().equals( "4 days" ) | episodes.get(i).getRelativedate().equals( "5 days" ) | episodes.get(i).getRelativedate().equals( "6 days" ) ) ){ tmp.add( episodes.get(i) ); }      
	if( shows.contains( tmpShowid ) && days == 7 && ( episodes.get(i).getRelativedate().equals( "Tonight" ) | episodes.get(i).getRelativedate().equals( "1 day" ) | episodes.get(i).getRelativedate().equals( "2 days" ) | episodes.get(i).getRelativedate().equals( "3 days" ) | episodes.get(i).getRelativedate().equals( "4 days" ) | episodes.get(i).getRelativedate().equals( "5 days" ) | episodes.get(i).getRelativedate().equals( "6 days" ) | episodes.get(i).getRelativedate().equals( "7 days" ) ) ){ tmp.add( episodes.get(i) ); }      
	if( shows.contains( tmpShowid ) && ( days > 7 | days < 0 ) ){ tmp.add( episodes.get(i) ); }
      }
      else{
	if( days == 0 && episodes.get(i).getRelativedate().equals( "Tonight" ) ){ tmp.add( episodes.get(i) ); }
	if( days == 1 && ( episodes.get(i).getRelativedate().equals( "Tonight" ) | episodes.get(i).getRelativedate().equals( "1 day" ) ) ){ tmp.add( episodes.get(i) ); }
	if( days == 2 && ( episodes.get(i).getRelativedate().equals( "Tonight" ) | episodes.get(i).getRelativedate().equals( "1 day" ) | episodes.get(i).getRelativedate().equals( "2 days" ) ) ){ tmp.add( episodes.get(i) ); }  
	if( days == 3 && ( episodes.get(i).getRelativedate().equals( "Tonight" ) | episodes.get(i).getRelativedate().equals( "1 day" ) | episodes.get(i).getRelativedate().equals( "2 days" ) | episodes.get(i).getRelativedate().equals( "3 days" ) ) ){ tmp.add( episodes.get(i) ); }  
	if( days == 4 && ( episodes.get(i).getRelativedate().equals( "Tonight" ) | episodes.get(i).getRelativedate().equals( "1 day" ) | episodes.get(i).getRelativedate().equals( "2 days" ) | episodes.get(i).getRelativedate().equals( "3 days" ) | episodes.get(i).getRelativedate().equals( "4 days" ) ) ){ tmp.add( episodes.get(i) ); }      
	if( days == 5 && ( episodes.get(i).getRelativedate().equals( "Tonight" ) | episodes.get(i).getRelativedate().equals( "1 day" ) | episodes.get(i).getRelativedate().equals( "2 days" ) | episodes.get(i).getRelativedate().equals( "3 days" ) | episodes.get(i).getRelativedate().equals( "4 days" ) | episodes.get(i).getRelativedate().equals( "5 days" ) ) ){ tmp.add( episodes.get(i) ); }      
	if( days == 6 && ( episodes.get(i).getRelativedate().equals( "Tonight" ) | episodes.get(i).getRelativedate().equals( "1 day" ) | episodes.get(i).getRelativedate().equals( "2 days" ) | episodes.get(i).getRelativedate().equals( "3 days" ) | episodes.get(i).getRelativedate().equals( "4 days" ) | episodes.get(i).getRelativedate().equals( "5 days" ) | episodes.get(i).getRelativedate().equals( "6 days" ) ) ){ tmp.add( episodes.get(i) ); }      
	if( days == 7 && ( episodes.get(i).getRelativedate().equals( "Tonight" ) | episodes.get(i).getRelativedate().equals( "1 day" ) | episodes.get(i).getRelativedate().equals( "2 days" ) | episodes.get(i).getRelativedate().equals( "3 days" ) | episodes.get(i).getRelativedate().equals( "4 days" ) | episodes.get(i).getRelativedate().equals( "5 days" ) | episodes.get(i).getRelativedate().equals( "6 days" ) | episodes.get(i).getRelativedate().equals( "7 days" ) ) ){ tmp.add( episodes.get(i) ); }      
	if( days > 7 | days < 0 ){ tmp.add( episodes.get(i) ); }
      }
    }
    return tmp;
  }
}