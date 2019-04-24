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
                dbUri = new URI("postgres://mrlegwtebcblxo:aa2719e251ec182861ea51579bfa77990d57aac60c1eff89507c960b81167b03@ec2-54-225-116-36.compute-1.amazonaws.com:5432/d7l4lmosh9gq76@localhost:5432/hair_salon_one");
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