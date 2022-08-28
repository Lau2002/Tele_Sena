public class TeleSena{
    private double preco;
    private int[] array1 = new int[25], array2 = new int[25];
    public TeleSena(){//Cosntrutor da Classe TeleSena
        preco = 10;
        int[] arrayVerificador = new int[25];
        for(int i = 0; i < array1.length; i++){//Cria os valores do primeiro array da Tele Sena
            array1[i] = (1 + (int) (Math.random() * 60));

            for(int j = 0; j < arrayVerificador.length; j++){
                if(array1[i] == arrayVerificador[j]){
                    i--;
                    break;
                }
            }
            arrayVerificador[i] = array1[i];
        }

        for(int i = 0; i < arrayVerificador.length; i++ ){//Zera os valores do Array Verificador
            arrayVerificador[i] = 0;
        }

        for(int i = 0; i < array2.length; i++){ //Cria os valores do segundo array da Tele Sena
            array2[i] = (1 + (int) (Math.random() * 60));

            for(int j = 0; j < arrayVerificador.length; j++){
                if(array2[i] == arrayVerificador[j]){
                    i--;
                    break;
                }
            }
            arrayVerificador[i] = array2[i];
        }
    }

    public double getPreco(){//Método que retorna o preço da Tele Sena
        return preco;
    }

    public void imprimeArray(){//Método que imprime os números dos dois arrays da Tele Sena
        System.out.println("\nArray1");
        for(int i = 0; i < array1.length; i++)
            System.out.println(array1[i]);
        System.out.println("\nArray2");
        for(int i = 0; i < array2.length; i++)
            System.out.println(array2[i]);
    }

    public boolean sorteiaArray1(int[] arraySorteio){//Método que compara os valores do array1 com os valores sorteados
        int contador = 0;
        for(int i = 0; i < array1.length; i++){
            for(int j = 0; j < arraySorteio.length; j++){
                if((array1[i] == arraySorteio[j]) && arraySorteio[j] != 0){
                    contador ++;
                    break;
                }
            }
        }
        if(contador == 25)
            return true;
        else
            return false;
    }

    public boolean sorteiaArray2(int[] arraySorteio){//Método que compara os valores do array2 com os valores sorteados
        int contador = 0;
        for(int i = 0; i < array2.length; i++){
            for(int j = 0; j < arraySorteio.length; j++){
                if((array2[i] == arraySorteio[j]) && arraySorteio[j] != 0){
                    contador ++;
                    break;
                }
            }
        }
        if(contador == 25)
            return true;
        else
            return false;
    }
}
