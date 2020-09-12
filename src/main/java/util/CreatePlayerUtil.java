package util;

import playerInfo.*;

public class CreatePlayerUtil {

    public static Player createPlayer(String name, String role, int position) {
        switch(role) {
            case "Mafia" : return new Mafia(name, role, position);
            case "Doctor" :  return new Doctor(name, role, position);
            default : return new Townie(name, role, position);

        }
    }
    public static Player createPlayer(String name, String role, int position, int status, boolean target) {
        switch(role) {
            case "Mafia" : return new Mafia(name, role, position, status, target);
            case "Doctor" : return new Doctor(name, role, position, status, target);
            default : return new Townie(name, role, position, status, target);
        }
    }

}
