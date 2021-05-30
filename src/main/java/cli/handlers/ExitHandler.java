package cli.handlers;

public class ExitHandler implements ActionHandler {
    @Override
    public void handle() {

        System.out.println("Exit ...");
        // simulate delay as if the program is saving right now...
        sleep(1);
        System.exit(0);
    }

    private void sleep(int seconds){
        try{
            Thread.sleep(seconds*1000);
        }catch(Exception e){ }
    }
}
