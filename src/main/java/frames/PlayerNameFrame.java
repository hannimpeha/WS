package frames;

import org.gephi.graph.api.types.IntervalSet;

import javax.swing.*;

public class PlayerNameFrame extends JFrame {


    public PlayerNameFrame(){
        System.out.println("Press PlayerCount to start");
        //displayCenter(3);
    }


//    public List<String> getPlayerNames(){
//        List<String> names = new ArrayList<>();
//
//        for(JTextField f: textFields){
//            if(f.getText().equals("")||f.getText()==null){
//                names.add("Player "+f.getName());
//            }else{
//                names.add(f.getText());
//            }
//        }
//        return names;
//    }
//
//    public void displayCenter(int playerTotal) {
//        for (int count = 0; count < playerTotal; count++) {
//            JTextField playerNameInput = new JTextField("", 30);
//            playerNameInput.setName(Integer.toString(count+1));
//            textFields.add(playerNameInput);
//        }
//    }
}
