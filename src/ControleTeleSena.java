public class ControleTeleSena {
    Pessoa[] pessoas = new Pessoa[20];
    Pessoa[] pessoasGanhadoras = new Pessoa[20];
    public ControleTeleSena(){//Cosntrutor para criar o array de pessoas
        for(int i = 0; i < pessoas.length; i++){
            Pessoa p = new Pessoa();
            pessoas[i] = p;
        }
    }

    public int telesVendidas(){//Método para obter o número de Tele Senas vendidas
        int telesVendidas = 0;
        for(int i = 0; i < pessoas.length; i++)
            telesVendidas += pessoas[i].contaTele();
        return telesVendidas;
    }

    public double precoVendasTeles(){//Método para obter o dinheiro arrecadado com a venda das Tele Senas
        double precoVendasTeles = 0;
        for(int i = 0; i < pessoas.length; i++){
            precoVendasTeles += pessoas[i].precoTeles();
        }
        return precoVendasTeles;
    }

    public double valorPremio(){//Método para calcular o prêmio do sorteio
        return precoVendasTeles() * 0.8;
    }

    public double lucroSilvioSantos(){//Método para calcular o lucro obtido pelo Silvio Santos
        return precoVendasTeles() * 0.2;
    }

    public void insereGanhador(Pessoa pessoa){//Método que insere a pessoa que ganhou o sorteio no array de ganhadores
        for(int i = 0; i < pessoasGanhadoras.length; i++){
            if(pessoasGanhadoras[i] == null){
                pessoasGanhadoras[i] = pessoa;
                break;
            }
        }
    }

    public void sorteio(){ //Método para realizar o sorteio
        int[] arrayVerificador = new int[60];
        int[] arraySorteio = new int[60];
        for(int i = 0; i < 25; i++){//Sorteia os 25 valores iniciais da Tele Sena
            arraySorteio[i] = (1 + (int) (Math.random() * 60));
            for(int j = 0; j < arrayVerificador.length; j++){
                if(arraySorteio[i] == arrayVerificador[j]){
                    i--;
                    break;
                }
            }
            arrayVerificador[i] = arraySorteio[i];
        }

        int ganhadores = 0;
        String nomesGanhadores = "";
        for(int i = 0; i < pessoas.length; i++){//Compara os 25 valores iniciais sorteados com as Tele Senas dos compradores
            TeleSena tl;
            for(int j = 0; j < pessoas[i].contaTele(); j++){
                TeleSena a = (pessoas[i].getTele(j));
                if(a.sorteiaArray1(arraySorteio) == true || a.sorteiaArray2(arraySorteio) == true){
                    ganhadores ++;
                    nomesGanhadores += pessoas[i].getNome();
                    break;
                }
            }
        }

        if(ganhadores == 0){//Se nenhum ganhador for encontrado, é realizado o sorteio até achar um ganhador
            for(int i = 25; i < arraySorteio.length; i++){
                boolean repetiu = false;
                arraySorteio[i] = (1 + (int) (Math.random() * 60));
                for(int j = 0; j < arrayVerificador.length; j++){
                    if(arraySorteio[i] == arrayVerificador[j]){
                        i--;
                        repetiu = true;
                        break;
                    }
                }
                if(repetiu == false){
                    arrayVerificador[i] = arraySorteio[i];
                    for(int k = 0; k < pessoas.length; k++){
                        TeleSena tl;
                        for(int j = 0; j < pessoas[k].contaTele(); j++){
                            TeleSena a = (pessoas[k].getTele(j));
                            if(a.sorteiaArray1(arraySorteio) == true || a.sorteiaArray2(arraySorteio) == true){
                                ganhadores ++;
                                nomesGanhadores += pessoas[k].getNome()+" | ";
                                insereGanhador(pessoas[k]);
                                break;
                            }
                        }
                    }
                }
                if(ganhadores > 0)
                    break;
            }
        }
        int cont = 0;
        System.out.print("Números sorteados: ");
        for(int i = 0; i < arraySorteio.length; i++){//Realiza a contagem de nímeros sorteados
            if(arraySorteio[i] != 0){
                System.out.print(arraySorteio[i]+" ");
                cont ++;
            }
        }
        try{
            Thread.sleep(500);
        }catch(Exception e){}
        System.out.println("\nQuantidade de números sortedaos: "+cont);
        try{
            Thread.sleep(500);
        }catch(Exception e){}
        System.out.println("Ganhadores: "+nomesGanhadores);
        try{
            Thread.sleep(500);
        }catch(Exception e){}
        System.out.println("Quantidade de ganhadores: "+ganhadores);
        double premioVencedor = valorPremio() / ganhadores;// Divide o valor do prêmio pela quantidade de ganhadores
        for(int i = 0; i < pessoasGanhadoras.length; i++){//Transfere o valor do prêmio para cada ganhador
            if(pessoasGanhadoras[i] != null)
                pessoasGanhadoras[i].setValorPremio(premioVencedor);
        }
        try{
            Thread.sleep(500);
        }catch(Exception e){}
        System.out.println("Quantidade de Tele Senas Vendidas: "+telesVendidas());
        try{
            Thread.sleep(500);
        }catch(Exception e){}
        System.out.println("Prêmio para cada ganhador: R$ "+premioVencedor);
        try{
            Thread.sleep(500);
        }catch(Exception e){}
        System.out.println("Lucro obtido pelo Silvio Santos: R$ "+lucroSilvioSantos());
    }
}
