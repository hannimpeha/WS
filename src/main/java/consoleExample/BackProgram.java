package consoleExample;

import consoles.ConsolePane;

import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BackProgram extends ConsolePane {

    private ExecutorService execService = Executors.newFixedThreadPool(1);
    private ConsolePane cp;

    public BackProgram(ActionListener listener) {
        super(listener);
    }

    public void getBackendWorker() {
        try {
            execService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        while(true)
                        {
                            try{
                                cp.outputToJTextArea("Game or Exit");

//                                System.out.println("(BackProgram Class) Enter two Numbers:");
//                                Scanner s=new Scanner(System.in);
//                                int a=s.nextInt();
//                                int b=s.nextInt();
//                                int c=a+b;
//                                System.out.println("Number Sum is:"+c);
                            }catch(Exception ed){}
                        }
                    } catch (Exception ex) {}
                }
            });
        } catch (Exception ex) {}

    }

}
