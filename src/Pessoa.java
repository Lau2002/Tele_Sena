public class Pessoa {
    private String nome;
    private TeleSena[] tl;
    private double valorPremio;

    public Pessoa(){//Construtor da classe Pessoa
        String[] primeiroNomes = {"Maria", "José", "Paula", "Gabriel", "Andressa", "Fernando", "Lúcia", "Francisco",
                "Luciana", "João", "Laura", "Matheus", "Carolina", "André", "Clara", "Lucas", "Amanda", "Pedro", "Ana", "Bruno"};

        String[] segundoNomes = {"Silva", "Santos", "Oliveira", "Souza", "Rodrigues", "Ferreira", "Alves", "Pereira",
                "Lima", "Gomes", "Ribeiro", "Martins", "Almeida", "Campos", "Dias", "Duarte", "Freitas", "Garcia", "Lopes",
                "Machado"};

        String primeiroNome = primeiroNomes[(int)(Math.random() * primeiroNomes.length)];//Sorteia o primeiro nome
        String segundoNome = segundoNomes[(int)(Math.random() * segundoNomes.length)];//Sorteia o segundo nome
        nome = primeiroNome+" "+segundoNome;
        int quantTeleSenas = (1 + (int) (Math.random() * 15));
        tl = new TeleSena[quantTeleSenas];
        for(int i = 0; i < quantTeleSenas; i++){//Cria os objetos TeleSena de acordo com o número sorteado acima
            TeleSena a = new TeleSena();
            tl[i] = a;
        }
    }

    public String getNome(){//Método que retorna o nome da pessoa
        return nome;
    }

    public int contaTele(){//Método que retorna a quantidade de Tele Senas do objeto Pessoa
        return tl.length;
    }

    public TeleSena getTele(int i){//Método que retorna a Tele Sena de acordo com a posição indicada no array
        return tl[i];
    }

    public double precoTeles(){//Método que retorna o valor pago pelas Tele Senas
        double retornoPreco = 0;
        for(int i = 0; i < tl.length; i++){
            retornoPreco += tl[i].getPreco();
        }
        return retornoPreco;
    }

    public void setValorPremio(double valorPremio){//Método que atribui um novo valor para a variável valorPremio
        this.valorPremio = valorPremio;
    }
}
