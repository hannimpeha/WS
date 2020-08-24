package util;

import playerInfo.*;

public class CreatePlayerUtil {

    public static Player createPlayer(String name, String role, int position) {
        switch(role) {
            case "Mafia" : return new Mafia(name, position);
            case "Doctor" :  return new Doctor(name, position);
            default : return new Townie(name, position);

        }
    }

    public static Player createPlayer(String name, String role, int position, int status, boolean target) {
        switch(role) {
            case "Mafia" : return new Mafia(name, position, status, target);
            case "Doctor" : return new Doctor(name, position, status, target);
            default : return new Townie(name, position, status, target);
        }
    }
}
