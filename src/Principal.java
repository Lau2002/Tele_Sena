public class Principal {
    public static void main(String[] args){//Método principal para realizar o sorteio
        ControleTeleSena ctl = new ControleTeleSena();
        System.out.println("----------------- SORTEIO TELE SENA -----------------");
        try{
            Thread.sleep(500);
        }catch(Exception e){}
        System.out.println("Sorteando em:");
        try{
            Thread.sleep(1000);
        }catch(Exception e){}
        System.out.println("3...");
        try{
            Thread.sleep(1000);
        }catch(Exception e){}
        System.out.println("2...");
        try{
            Thread.sleep(1000);
        }catch(Exception e){}
        System.out.println("1!");
        try{
            Thread.sleep(500);
        }catch(Exception e){}
        ctl.sorteio();//Chama o método que realiza o sorteio
        try{
            Thread.sleep(500);
        }catch(Exception e){}
        System.out.println("------------------------------------------------------");
    }
}
