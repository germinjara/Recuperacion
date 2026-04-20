public class PaginaWeb {
    private String url;
    private String titulo;
    private String fechaAcceso;

    public PaginaWeb(String url, String titulo, String fechaAcceso) {
        this.url = url;
        this.titulo = titulo;
        this.fechaAcceso = fechaAcceso;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaAcceso() {
        return fechaAcceso;
    }

    public void setFechaAcceso(String fechaAcceso) {
        this.fechaAcceso = fechaAcceso;
    }

    

    
    
}