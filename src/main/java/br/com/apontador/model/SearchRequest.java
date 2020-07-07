package br.com.apontador.model;

public class SearchRequest {

        private int page;
        private int pageSize;
        private String tipoEmpresa;
        
        
        public int getPage() {
            return page;
        }
        public void setPage(int page) {
            this.page = page;
        }
        public int getPageSize() {
            return pageSize;
        }
        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }
        public String getTipoEmpresa() {
            return tipoEmpresa;
        }
        public void setTipoEmpresa(String tipoEmpresa) {
            this.tipoEmpresa = tipoEmpresa;
        }
        public SearchRequest(int page, int pageSize, String tipoEmpresa) {
            super();
            this.page = page;
            this.pageSize = pageSize;
            this.tipoEmpresa = tipoEmpresa;
        }
        public SearchRequest() {
        }
    
}