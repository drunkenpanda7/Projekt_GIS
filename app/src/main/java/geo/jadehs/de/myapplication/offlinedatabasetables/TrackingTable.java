package geo.jadehs.de.myapplication.offlinedatabasetables;

/**
 * Created by Maik on 28.05.2015.
 */
public class TrackingTable implements iTableColumns {

    /**
     * Tabellennamen
     */

    public static final String TABLE_NAME = "trackingtable";

    /**
     * SQL Anweisung zur L&ouml;schung der Tabelle.
     */

    public static final String SQL_DROP =
            "DROP TABLE IF EXISTS " +
                    TABLE_NAME;


    /**
     * SQL Anweisung zur Schemadefinition.
     */


    public static final String SQL_CREATE =
                    "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "trackname TEXT NOT NULL," +
                    "zeitstempel TEXT," +
                    "geschwindigkeit TEXT" +
                    ");";


    /**
     * Standard-Sortierreihenfolge fuer die Tabelle.
     * <br>
     * Sortiert wird nach Zeitstempel absteigend.
     */
    public static final String DEFAULT_SORT_ORDER =
            ZEITSTEMPEL +
                    " DESC";
    /**
     * SQL Anweisung f&uuml;r Erzeugung eines
     * Minimal-OfflineTrees aus Name.
     */
    public static final String STMT_MIN_INSERT =
            "INSERT INTO spatialite " +
                    "(name) " +
                    "VALUES (?)";

    /**
     * SQL Anweisung f&uuml;r Erzeugung eines OfflineTrees
     * aus den Stammdaten Name, Laengengrad, Breitengrad.
     */
    public static final String STMT_INSERT_TRACK =
            "INSERT INTO " + TABLE_NAME +
                    "(trackname,zeitstempel,geschwindigkeit,"+GPSPOSITION+ ")" +
                    "VALUES";

    /**
     * SQL-Anweisung zur L&ouml;schung aller OfflineTrees.
     */
    public static final String STMT_OFFLINE_TREE_DELETE =
            "DELETE spatialite ";

    /**
     * SQL-Anweisung zur L&ouml;schung eines OfflineTrees
     * anhand seines Schl&uuml;sselwerts.
     */
    public static final String STMT_OFFLINE_TREE_DELETE_BY_ID =
            "DELETE spatialite " +
                    "WHERE id = ?";

    /**
     * Liste aller bekannten Attribute.
     */
    public static final String[] ALL_COLUMNS = new String[]{
            ID,
            TRACKNAME,
            GESCHWINDIGKEIT,
            ZEITSTEMPEL
    };

    /**
     * WHERE-Bedingung f&uuml;r ID-Anfrage.
     */
    public static final String WHERE_ID_EQUALS =
            ID + "=?";


    /**
     * Create Spatialite Columns
     */

    public static final String CREATE_SPATIALITE_COLUMN =
            "SELECT AddGeometryColumn(" + "'"+ TABLE_NAME +"'"+ "," + "'"+GPSPOSITION +"'"+ "," + 4258 + "," + "'"+"POINT"+ "'"+","+ 2 +","+ 0 +");";


}
