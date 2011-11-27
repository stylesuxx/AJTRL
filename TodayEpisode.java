import java.util.Calendar;
/** This Object holds all Infos about a show in the Countdown XML
  * <ul>
  * <li>Show ID</li>
  * <li>Show name</li>
  * <li>Show link</li>
  * <li>Episode link</li>
  * <li>Episode title</li>
  * <li>Season and episode number</li>
  * <li>Air date</li>
  * <li>Relative date</li>
  * </ul>
  */
public class TodayEpisode{
  private String showname = null;
  private int showid = -1;
  private String showlink = null;
  private String episodelink = null;
  private String episodetitle;
  private String epnum = null;
  private Calendar airdate = null;
  private String relativedate = null;

  /** Default Constructor
    */
  public TodayEpisode(){}

  //Here we go with all the Setter
  /** Sets the show ID
    * @param showid The ID of the show
    */
  public void setShowid( int showid ){
    this.showid = showid;
  }

  /** Sets the showname
    * @param showname The Title of the show
    */
  public void setShowname( String showname ){
    this.showname = showname;
  }

  /** Sets the link to the show
    * @param showlink The link to the show
    */
  public void setShowlink( String showlink ){
    this.showlink = showlink;
  }

  /** Sets the link to the episode
    * @param episodelink The link to the episode
    */
  public void setEpisodelink( String episodelink ){
    this.episodelink = episodelink;
  }

  /** Sets the title of the episode
    * @param episodetitle The title of the episode
    */
  public void setEpisodetitle( String episodetitle ){
    this.episodetitle = episodetitle;
  }

  /** Sets the season and episode number
    * @param epnum The the season and epsiode number of the show
    */
  public void setEpnum( String epnum ){
    this.epnum = epnum;
  }

  /** Sets the air date
    * @param airdate The airdate of the episode
    */
  public void setAirdate( Calendar airdate ){
    this.airdate = airdate;
  }

  /** Sets the relative date
    * @param relativedate The Title of the show
    */
  public void setRelativedate( String relativedate ){
    this.relativedate = relativedate;
  }

  //Here we go with all the getters
  /** Returns the showname
    * @return String
    */
  public String getShowname(){
    return showname;
  }

  /** Returns the link to the show
    * @return String
    */
  public String getShowlink(){
    return showlink;
  }

  /** Returnss the link to the episode
    * @return String
    */
  public String getEpisodelink(){
    return episodelink;
  }

  /** Returns the title of the episode
    * @return Srtring 
    */
  public String getEpisodetitle(){
    return episodetitle;
  }

  /** Returns the season and episode number
    * @return String
    */
  public String getEpnum(){
    return epnum;
  }

  /** Returns the air date
    * @return Calendar
    */
  public Calendar getAirdate(){
    return airdate;
  }

  /** Returns the relative date
    * @return String
    */
  public String getRelativedate(){
    return relativedate;
  }

  /** Returns the show ID
    * @return int
    */
  public int getShowid(){
    return showid;
  }
}