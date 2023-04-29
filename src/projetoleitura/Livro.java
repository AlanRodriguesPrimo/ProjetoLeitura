package projetoleitura;
/**
 *
 * @author Alan Rodrigues Primo
 */
public class Livro implements Publicacao{
       private String titulo;
    private String autor;
    private int totPag;
    private int pagAtual;
    private boolean aberto;
    private Pessoa leitor;

    public Livro(String titulo, String autor, int totPag, Pessoa leitor) {
        this.titulo = titulo;
        this.autor = autor;
        this.totPag = totPag;
        this.pagAtual = 0;
        this.leitor = leitor;
        this.aberto = false;
    }
    
    
     public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getTotPag() {
        return totPag;
    }

    public void setTotPag(int totPag) {
        this.totPag = totPag;
    }

    public int getPagAtual() {
        return pagAtual;
    }

    public void setPagAtual(int pagAtual) {
        this.pagAtual = pagAtual;
    }

    public boolean getAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public Pessoa getLeitor() {
        return leitor;
    }

    public void setLeitor(Pessoa leitor) {
        this.leitor = leitor;
    }
    
    public void detalhes(){
        System.out.println("---------------------------");
        System.out.println("Titulo: "+this.titulo);
        System.out.println("Autor: "+this.autor);
        System.out.println("Quantidade de paginas: "+this.totPag);
        System.out.println("Pagina atual: "+this.pagAtual);
        System.out.println("Esta aberto: "+this.aberto);
        System.out.println("Nome do leitor: "+this.leitor.getNome());
        System.out.println("idade do leitor: "+this.leitor.getIdade());
        System.out.println("Sexo do leitor: "+this.leitor.getSexo());
        System.out.println("---------------------------");
    }

    @Override
    public void abrir(){
        if(!getAberto()){
            this.setAberto(true);
            this.setPagAtual(0);
            System.out.println("Livro aberto");
        }else{
            System.out.println("O livro ja esta aberto");
        }
    }
    @Override
    public void fechar(){
        if(getAberto()){
            this.setAberto(false);
            this.setPagAtual(0);
            System.out.println("Livro Fechado");
        }else{
            System.out.println("O livro ja esta aberto");
        }
    }
    @Override
    public void folhear(int pag){
        if(pag<this.totPag){
        int linhas = 0;
        for(int i=1; i<=pag;i++){
            linhas++;
            if(linhas>9){
                System.out.println("");
                linhas=0;
            }
            if(i<=pag-1){                 
            System.out.print("pagina"+i+", ");
            }else if(i==pag){
                System.out.println("pagina"+i+".");
            this.pagAtual = pag;
            }
            
        }
        }else{
            System.out.println("não e possivel folhear, o livro possui somente "+this.totPag+" paginas.");
        }
        this.aberto=true;
        }   
    @Override
    public void avancarPag(){
        if(this.getAberto()){
            if (this.getPagAtual()< this.getTotPag()) {
            this.setPagAtual(getPagAtual()+1);
            }else{
                System.out.println("você ja esta na ultima pagina! ");
            }
            
        }else{
            System.out.println("O livro esta fechado, abra-o para avançar a pagina");
        }
    }
    @Override
    public void voltarPag(){
                if(this.getAberto()){
            if (this.getPagAtual()> 0){
                this.setPagAtual(getPagAtual()-1);
            }else{
                System.out.println("você esta no começo do livro não e possivel voltar mais! ");
            }
            
        }else{
            System.out.println("O livro esta fechado");
        }
    }
}
