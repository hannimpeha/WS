package Test;

public class FSM_Test {
    public static void main( String[] args ) {
        Mobile1 m1 = new Mobile1();
        m1.activity();
        m1.handleEvent( Mobile1.Event.FIRST );
        m1.activity();
        m1.handleEvent( Mobile1.Event.SECOND );
        m1.activity();
        m1.handleEvent( Mobile1.Event.FIRST );   // Event not handled
        m1.activity();
        m1.handleEvent( Mobile1.Event.THIRD );
        m1.activity();
    }
}