package Source;

/**
 *
 * @author Dwi Rifki Novianto
 */
public class session {
    private static String log_id;
    private static String level;
    
    public static String get_Level(){
        return level;
    }
    public static void set_Level(String level){
        session.level = level;
    }
    
    public static String get_log_id(){
        return log_id;
    }
    public static void set_Log_id(String log_id){
        session.log_id = log_id;
    }
}
