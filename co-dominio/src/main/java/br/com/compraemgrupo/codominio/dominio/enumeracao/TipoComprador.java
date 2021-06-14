package br.com.compraemgrupo.codominio.dominio.enumeracao;

public enum TipoComprador {

	PESSOA_FISICA (1,"Pessoa Fisica"), 
	PESSOA_JURIDICA (2, "Pessoa Juridica");
	
	private int codigo;
	private String descricao;
	
	private TipoComprador (int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoComprador getEnum(Integer codigo) {
		
		if (codigo == null) {
			return null;
		}
		
		for (TipoComprador tipo : TipoComprador.values()) {
			if (tipo.getCodigo() == codigo.intValue()) {
				return tipo;
			}
		}
		
		throw new IllegalArgumentException("Codigo enum invalido: " + codigo);
	}
}
