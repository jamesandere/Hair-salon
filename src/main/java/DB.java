// import org.sql2o.*;

// public class DB {
//  public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_one", "moringa", "moringa");
// }
import org.sql2o.*;
import java.net.URI;
import java.net.URISyntaxException;
public class DB {
    private static URI dbUri;
    public static Sql2o sql2o;
    static {

        try {
            if (System.getenv("DATABASE_URL") == null) {
                dbUri = new URI("postgres://ewegydeytusebs:e333db2f4208e7bbace4e51df32d8f4e18f4ab462ec020e9c8bbbc47f8145ae3@ec2-174-129-208-118.compute-1.amazonaws.com:5432/d3njgr6dboe2a9
@localhost:5432/hair_salon_one");
            } else {
                dbUri = new URI(System.getenv("DATABASE_URL"));
            }
            int port = dbUri.getPort();
            String host = dbUri.getHost();
            String path = dbUri.getPath();
            String username = (dbUri.getUserInfo() == null) ? null : dbUri.getUserInfo().split(":")[0];
            String password = (dbUri.getUserInfo() == null) ? null : dbUri.getUserInfo().split(":")[1];
            sql2o = new Sql2o("jdbc:postgresql://" + host + ":" + port + path, username, password);
        } catch (URISyntaxException e ) {

        }
    }
}