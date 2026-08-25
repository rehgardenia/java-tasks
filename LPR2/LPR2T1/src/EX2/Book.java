package EX2;

public class Book {
    private String name = "";
    private Author[] authors = null;
    private double price;
    private int qtd =0;
    
    public Book(String n, Author[] a, double p){
        this.name = n;
        this.authors = a;
        this.price = p;
    }
    public Book(String n, Author[] a, double p, int q){
        this.name = n;
        this.authors = a;
        this.price = p;
        this.qtd = q;
    }
    public String getName(){ return this.name;}
    public Author[] getAuthors() { return this.authors ;}
    public double getPrice() {return this.price;}
    public void setPrice( double p) { this.price = p;}
    public int getQty(){return this.qtd;}
    public void setQty(int q){this.qtd = q;}
    
    public String toString(){
        String resultado = "Book[name="+this.getName()+ ", authors=[{";
            for( Author item : authors){
                resultado += item.toString() + " ";
             }
            resultado += "},price="+this.getPrice()+",qty="+getQty()+"]";
            return resultado;
    }
    public String getAuthorNames(){
        String r = "[";
        for( Author item : authors){
            r += item.getName() + ", ";
         }
         r += "]";
         return r;
    }
}
