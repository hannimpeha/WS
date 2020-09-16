package Test;

import java.util.HashMap;
import java.util.Map;

class Mobile1
{
    enum State {
        FIRST, SECOND, THIRD
    }

    enum Event {
        FIRST, SECOND, THIRD
    }

    public Mobile1() {       // initialization may be done by loading a file
        Map< Event, State > tr;
        tr = new HashMap<>();
        tr.put( Event.FIRST, State.SECOND );
        _fsm.put( State.FIRST, tr );
        tr = new HashMap<>();
        tr.put( Event.SECOND, State.THIRD );
        _fsm.put( State.SECOND, tr );
        tr = new HashMap<>();
        tr.put( Event.THIRD, State.FIRST );
        _fsm.put( State.THIRD, tr );
    }

    public void activity() {        // May be a long process, generating events,
        System.err.println( _state );// to opposite to "action()" see below
    }

    public void handleEvent( Event event ) {
        Map<Event, State> trs = _fsm.get(_state);
        if( trs != null ) {
            State futur = trs.get(event);
            if( futur != null ) {
                _state = futur;
                // here we may call "action()" a small piece of code executed
                // once per transition
            }
        }
    }

    private final Map<State, Map<Event, State >> _fsm   = new HashMap<>();
    private State _state = State.FIRST;
}
